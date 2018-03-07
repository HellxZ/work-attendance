package com.coder520.attend.service.impl;

import com.coder520.attend.dao.AttendMapper;
import com.coder520.attend.entity.Attend;
import com.coder520.attend.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attendServiceImpl")
public class AttendServiceImpl implements AttendService{

    @Autowired
    private AttendMapper attendMapper;

    @Override
    public int attend(Attend attend) { //签到方法
        int i = attendMapper.insertSelective(attend);
        return i; //返回大于1，插入成功
    }
}
