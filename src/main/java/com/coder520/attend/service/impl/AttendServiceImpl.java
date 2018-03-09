package com.coder520.attend.service.impl;

import com.coder520.attend.dao.AttendMapper;
import com.coder520.attend.entity.Attend;
import com.coder520.attend.service.AttendService;
import com.coder520.attend.vo.QueryConditions;
import com.coder520.common.page.PageQueryBean;
import com.coder520.common.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("attendServiceImpl")
public class AttendServiceImpl implements AttendService {

    //log4j对象
    private Log log = LogFactory.getLog(AttendServiceImpl.class);
    private static final int NOON_HOUR = 12;
    private static final int NOON_MINUTE = 0;
    @Autowired
    private AttendMapper attendMapper;

    /**
     * 缺席整天：默认设置480分钟
     */
    private static final int ABSENCE_DURING_TODAY = 480;
    private static final byte ABSENCE_STATUS = 2;
    private static final byte NORMAL_STATUS = 1;

    /**
     * @Author: Hellxz
     * @Description:
     * @Date: 2018/3/8 9:22
     */
    @Override
    public void attend(Attend attend) {
        int i = 0;
        Date now = new Date();
        attend.setAttendDate(now);
        attend.setAttendWeek((byte) DateUtils.getWeek());
        //获取当天中午时间
        Date noon = DateUtils.getDate(NOON_HOUR, NOON_MINUTE);
        //查询是否今天该用户是否有打卡记录
        Attend today = attendMapper.selectAttendByToday(attend.getUserId());
        //无打卡记录
        if (today == null) {
            if (now.compareTo(noon) <= 0) {
                //登录时间如果早于12点，则设置为上午打卡
                attend.setAttendMorning(now);
            } else {//登录时间如果超过12点，则设置为下午打卡
                attend.setAttendEvening(now);
            }
            try {
                attendMapper.insertSelective(attend);
            } catch (Exception e) {
                log.error("签到方法出现异常", e);
            }
        } else { //有打卡记录
            if (now.compareTo(noon) <= 0) {
                return; //有打卡记录说明上午已经打卡了，以最早为准
            } else {//登录时间如果超过12点，则设置为下午打卡
                today.setAttendEvening(now);
            }
            try {
                attendMapper.updateByPrimaryKeySelective(today);
            } catch (Exception e) {
                log.error("签到方法出现异常", e);
            }
        }
    }

    /**
     * @Author: Hellxz
     * @Description: 根据条件获取列表并分页
     * @Date: 2018/3/8 13:48
     */
    @Override
    public PageQueryBean getAttendList(QueryConditions conditions) {
        //查询该表数据量
        int count = attendMapper.selectAttendListCount(conditions);
        //返回数据载体
        PageQueryBean pageQueryBean = new PageQueryBean();
        //判断是否有数据
        if (count > 0) {
            pageQueryBean.setCurrentPage(conditions.getCurrentPage());
            pageQueryBean.setPageSize(conditions.getPageSize());
            pageQueryBean.setTotalRows(count);
            //查询 返回list
            List<Attend> list = attendMapper.selectAttendListByCondition(conditions);
            //添加数据list
            pageQueryBean.setItems(list);
        }
        //无论数据有无，都返回
        return pageQueryBean;
    }

    /**
     * @Author: Hellxz
     * @Description: 检查打卡逻辑
     * @Date: 2018/3/9 15:26
     */
    @Override
    public void checkAttend() {
        //检查当天缺勤人的id
        List<Long> duringDayAbsenceIds = attendMapper.getTodayAbsenceIds();
        Attend attend = null;
        if(CollectionUtils.isNotEmpty(duringDayAbsenceIds)){
            List<Attend> attendList = new ArrayList<Attend>();
            for (Long userId : duringDayAbsenceIds) {
                attend = new Attend();
                attend.setUserId(userId);
                attend.setAttendWeek((byte)DateUtils.getWeek());
                attend.setAttendDate(new Date());
                attend.setAbsence(ABSENCE_DURING_TODAY);
                attend.setAttendStatus((byte)ABSENCE_STATUS);
                attendList.add(attend);
            }
            //批量插入异常签到信息
            attendMapper.batchInsertAttend(attendList);
        }
        //检查当天漏打晚上考勤的人
        List<Attend> eveningAbsenceList = attendMapper.getTodayEveningAbsenceList();
        if(CollectionUtils.isNotEmpty(eveningAbsenceList)){
            for(Attend atd : eveningAbsenceList){
                atd.setAbsence(ABSENCE_DURING_TODAY);
                atd.setAttendStatus(ABSENCE_STATUS);
                attendMapper.updateByPrimaryKeySelective(atd);
            }
        }

    }
}
