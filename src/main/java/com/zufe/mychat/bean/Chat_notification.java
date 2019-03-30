package com.zufe.mychat.bean;

public class Chat_notification {
    private Integer id;

    private String sender;

    private String receiver;

    private String qzId;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getQzId() {
        return qzId;
    }

    public void setQzId(String qzId) {
        this.qzId = qzId == null ? null : qzId.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}