package com.coder520.attend.controller;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : Hellxz
 * @Description: 打卡Controller
 * @Date : 2018/3/7 22:16
 */
@Controller
@RequestMapping("attend")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @RequestMapping
    public String toAttendList(){
        return "attend";
    }

    /**
     * @Author: Hellxz
     * @Description: 打卡
     * @Date: 2018/3/7 23:15
     */
    @RequestMapping("/sign")
    @ResponseBody
    public String attendNow(@RequestBody Attend attend){
        int result = attendService.attend(attend);
        if(result>0){
            return "attendSuccess";
        }else{
            return "attendFail";
        }
    }
}
