package com.coder520.attend.service;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.vo.QueryConditions;
import com.coder520.common.page.PageQueryBean;

/**
 * @Author : Hellxz
 * @Description: 签到服务
 * @Date : 2018/3/7 23:05
 */
public interface AttendService {

    //签到
    void attend(Attend attend);
    //分页查询签到信息
    PageQueryBean getAttendList(QueryConditions queryConditions);
}
