package com.zufe.mychat.bean;

public class Qzinvites {
    private Integer id;

    private String qzid;

    private String sender;

    private String message;

    private Boolean satus;
    
    private Qzxx qzxx;

    public Qzxx getQzxx() {
		return qzxx;
	}

	public void setQzxx(Qzxx qzxx) {
		this.qzxx = qzxx;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Boolean getSatus() {
        return satus;
    }

    public void setSatus(Boolean satus) {
        this.satus = satus;
    }
}