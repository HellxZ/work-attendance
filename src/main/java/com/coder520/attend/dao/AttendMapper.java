package com.coder520.attend.dao;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.vo.QueryConditions;

import java.util.List;

public interface AttendMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Attend record);

    int insertSelective(Attend record);

    Attend selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);

    Attend selectAttendByToday(long userId);

    int selectAttendListCount(QueryConditions conditions);

    List<Attend> selectAttendListByCondition(QueryConditions conditions);

    List<Long> getTodayAbsenceIds();

    void batchInsertAttend(List<Attend> attendList);

    List<Attend> getTodayEveningAbsenceList();
}