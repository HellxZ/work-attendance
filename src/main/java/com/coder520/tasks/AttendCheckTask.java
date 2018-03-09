package com.coder520.tasks;

import com.coder520.attend.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : Hellxz
 * @Description: 签到定时检查任务
 * @Date : 2018/3/9 14:17
 */
public class AttendCheckTask {

    @Autowired
    private AttendService attendService;
    /**
     * 检查定时任务
     */
    public void check(){
        attendService.checkAttend();
    }
}
