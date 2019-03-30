package com.zufe.mychat.bean;

import java.util.Date;

public class Ltlb {
    private Integer ltlbId;

    private Date sj;

    private String username;

    private String content;

    private String touser;

    private Byte myread;
    private String sjCn;
    
    public String getSjCn() {
		return sjCn;
	}

	public void setSjCn(String sjCn) {
		this.sjCn = sjCn;
	}

	public Integer getLtlbId() {
        return ltlbId;
    }

    public void setLtlbId(Integer ltlbId) {
        this.ltlbId = ltlbId;
    }

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser == null ? null : touser.trim();
    }

    public Byte getMyread() {
        return myread;
    }

    public void setMyread(Byte myread) {
        this.myread = myread;
    }
}