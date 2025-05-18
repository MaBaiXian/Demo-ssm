package edu.GDPU.Demo.Repair.entity;

import java.util.Date;

public class BaseEntity {
    private  Date beginTime;
    private Date endTime;
    public BaseEntity() {
    }
    public BaseEntity(Date beginTime, Date endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
