package com.zufe.mychat.bean;

import java.util.Date;

public class Qzltlb {
    private Integer qzltlbId;

    private String qzid;

    private String username;

    private Date sj;

    private String content;

    private Boolean myqzread;

    private String sjCn;
    
    public String getSjCn() {
		return sjCn;
	}

	public void setSjCn(String sjCn) {
		this.sjCn = sjCn;
	}

	public Integer getQzltlbId() {
        return qzltlbId;
    }

    public void setQzltlbId(Integer qzltlbId) {
        this.qzltlbId = qzltlbId;
    }

    public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getMyqzread() {
        return myqzread;
    }

    public void setMyqzread(Boolean myqzread) {
        this.myqzread = myqzread;
    }
}