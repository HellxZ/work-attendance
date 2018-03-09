package com.coder520.attend.vo;

import com.coder520.common.page.PageQueryBean;

/**
 * @Author : Hellxz
 * @Description: 分页+条件查询
 * @Date : 2018/3/8 13:27
 */
public class QueryConditions extends PageQueryBean {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 开始日期
     */
    private String startDate;
    /**
     * 结束日期
     */
    private String endDate;
    /**
     * 日期范围
     */
    private String rangeDate;
    /**
     * 状态
     */
    private Byte attendStatus;

    public Byte getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(Byte attendStatus) {
        this.attendStatus = attendStatus;
    }

    public String getRangeDate() {
        return rangeDate;
    }

    public void setRangeDate(String rangeDate) {
        this.rangeDate = rangeDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
