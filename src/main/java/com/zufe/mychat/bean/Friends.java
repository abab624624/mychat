package com.zufe.mychat.bean;

public class Friends extends FriendsKey {
    private String friendsId;
    private Users users;
    private Chat_notification chat_notification;
    public Chat_notification getChat_notification() {
		return chat_notification;
	}

	public void setChat_notification(Chat_notification chat_notification) {
		this.chat_notification = chat_notification;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(String friendsId) {
        this.friendsId = friendsId == null ? null : friendsId.trim();
    }
}