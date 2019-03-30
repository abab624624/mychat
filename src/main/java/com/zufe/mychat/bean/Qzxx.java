package com.zufe.mychat.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;

public class Qzxx {
	
	 @Pattern(regexp="(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})"
	    		,message="群组id格式为2-5位字符或3-16位数字和字母组合")
    private String qzid;

    private Integer qzxxId;
	 @Pattern(regexp="(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})"
	    		,message="群组姓名格式为2-5位字符或3-16位数字和字母组合")
    private String qzname;

    private String qzcreater;

    private Boolean yx;

    private Date createTime;
    
    private Qzcount qzcount;
    
   private Chat_notification chat_notification;
    
    public Chat_notification getChat_notification() {
	return chat_notification;
}

public void setChat_notification(Chat_notification chat_notification) {
	this.chat_notification = chat_notification;
}

	public Qzcount getQzcount() {
		return qzcount;
	}

	public void setQzcount(Qzcount qzcount) {
		this.qzcount = qzcount;
	}

	

  

	public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public Integer getQzxxId() {
        return qzxxId;
    }

    public void setQzxxId(Integer qzxxId) {
        this.qzxxId = qzxxId;
    }

    public String getQzname() {
        return qzname;
    }

    public void setQzname(String qzname) {
        this.qzname = qzname == null ? null : qzname.trim();
    }

    public String getQzcreater() {
        return qzcreater;
    }

    public void setQzcreater(String qzcreater) {
        this.qzcreater = qzcreater == null ? null : qzcreater.trim();
    }

    public Boolean getYx() {
        return yx;
    }

    public void setYx(Boolean yx) {
        this.yx = yx;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}