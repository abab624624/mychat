package com.zufe.mychat.bean;

public class FriendsKey {
    private String user1;

    private String user2;

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1 == null ? null : user1.trim();
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2 == null ? null : user2.trim();
    }
}