package com.coder520.attend.controller;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.service.AttendService;
import com.coder520.attend.vo.QueryConditions;
import com.coder520.common.page.PageQueryBean;
import com.coder520.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
        attendService.attend(attend);
        return "attendSuccess";
    }

    /**
     * @Author: Hellxz
     * @Description: 获取分页后的签到信息
     * @Date: 2018/3/8 13:38
     */
    @RequestMapping("/attendList")
    @ResponseBody
    public PageQueryBean getAttendList(QueryConditions condition, HttpSession session){
//        User user = (User) MD5Utils.getSubject().getSession().getAttribute("userinfo");
        User user = (User)session.getAttribute("userinfo");
        String [] rangeDate = condition.getRangeDate().split("/");
        condition.setStartDate(rangeDate[0]);
        condition.setEndDate(rangeDate[1]);
        condition.setUserId(user.getId());
        return attendService.getAttendList(condition);
    }
}
