package com.zufe.mychat.bean;

public class Invites {
    private Integer invitesId;

    private String sender;

    private String receiver;

    private String message;

    private Byte status;

    public Integer getInvitesId() {
        return invitesId;
    }

    public void setInvitesId(Integer invitesId) {
        this.invitesId = invitesId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}