package com.coder520.attend.service.impl;

import com.coder520.attend.dao.AttendMapper;
import com.coder520.attend.entity.Attend;
import com.coder520.attend.service.AttendService;
import com.coder520.attend.vo.QueryConditions;
import com.coder520.common.page.PageQueryBean;
import com.coder520.common.utils.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("attendServiceImpl")
public class AttendServiceImpl implements AttendService {

    //log4j对象
    private Log log = LogFactory.getLog(AttendServiceImpl.class);
    private static final int NOON_HOUR = 12;
    private static final int NOON_MINUTE = 0;
    @Autowired
    private AttendMapper attendMapper;

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
        attend.setAttendWeek((byte)DateUtils.getWeek());
        //获取当天中午时间
        Date noon = DateUtils.getDate(NOON_HOUR, NOON_MINUTE);
        //查询是否今天该用户是否有打卡记录
        Attend today = attendMapper.selectAttendByToday(attend.getUserId());
        if (today == null) { //无打卡记录
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
    public PageQueryBean getAttendList(QueryConditions queryConditions){
        //查询该表数据量
        int count = attendMapper.selectAttendListCount(queryConditions);
        PageQueryBean pageQueryBean = new PageQueryBean();
        //判断是否有数据
        //查询 返回list

        return null;
    }
}
