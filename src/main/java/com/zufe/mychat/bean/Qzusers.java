package com.zufe.mychat.bean;

import java.util.Date;

public class Qzusers extends QzusersKey {
    private String qzusersId;

    private Date joinTime;

    private Boolean yx;

    public String getQzusersId() {
        return qzusersId;
    }

    public void setQzusersId(String qzusersId) {
        this.qzusersId = qzusersId == null ? null : qzusersId.trim();
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Boolean getYx() {
        return yx;
    }

    public void setYx(Boolean yx) {
        this.yx = yx;
    }
}