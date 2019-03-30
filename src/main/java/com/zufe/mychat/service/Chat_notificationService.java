package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Chat_notification;

public interface Chat_notificationService {

	public void InsertChatNotification(String sender, String receiver);

	public void UpdateChatNotification(String sender, String receiver, int count);

	public List<Chat_notification> QueryChatNotification(String sender,
			String receiver);

	public void DeleteChatNotification(String sender, String receiver);

	public boolean InsertQzChatNotification(String receiver, String qz_id);

	public List<Chat_notification> QueryQzChatNotification(String receiver,
			String qz_id);

	public void UpdateQzChatNotification(String receiver, String qz_id, int count);

	public boolean DeleteQzChatNotification(String receiver, String qz_id);

   public  boolean addQzCount (String receiver,String qzid) ;
	
}


