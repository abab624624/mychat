package com.zufe.mychat.bean;

import javax.validation.constraints.Pattern;

public class Users {
    private Integer usersId;
    @Pattern(regexp="(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})"
    		,message="姓名格式为2-5位字符或3-16位数字和字母组合")
    private String username;
    @Pattern(regexp="^(?:(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])).{6,12}$"
    		,message="密码格式为6-16位数字和大小写字母组合") 
    private String password;

    private Byte satus;

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSatus() {
        return satus;
    }

    public void setSatus(Byte satus) {
        this.satus = satus;
    }
}