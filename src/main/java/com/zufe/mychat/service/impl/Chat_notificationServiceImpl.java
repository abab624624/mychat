package com.zufe.mychat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Chat_notification;
import com.zufe.mychat.bean.Chat_notificationExample;
import com.zufe.mychat.bean.Chat_notificationExample.Criteria;
import com.zufe.mychat.dao.Chat_notificationMapper;
import com.zufe.mychat.service.Chat_notificationService;

@Service
public class Chat_notificationServiceImpl implements Chat_notificationService {
	@Autowired
	Chat_notificationMapper chat_notificationMapper;

	@Override
	public void InsertChatNotification(String sender, String receiver) {
		// TODO Auto-generated method stub

		Chat_notification chat_notification = new Chat_notification();
		chat_notification.setSender(sender);
		chat_notification.setReceiver(receiver);

		chat_notificationMapper.insertSelective(chat_notification);

	}

	@Override
	public void UpdateChatNotification(String sender, String receiver, int count) {
		// TODO Auto-generated method stub

		Chat_notificationExample ex = new Chat_notificationExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andReceiverEqualTo(receiver);

		List<Chat_notification> list = chat_notificationMapper
				.selectByExample(ex);

		Chat_notification chat_notification = new Chat_notification();
		chat_notification.setSender(sender);
		chat_notification.setReceiver(receiver);
		chat_notification.setCount(count);
		chat_notificationMapper.updateByExampleSelective(chat_notification, ex);

	}

	@Override
	public List<Chat_notification> QueryChatNotification(String sender,
			String receiver) {
		// TODO Auto-generated method stub

		Chat_notificationExample ex = new Chat_notificationExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andReceiverEqualTo(receiver);

		List<Chat_notification> list = chat_notificationMapper
				.selectByExample(ex);

		return list;
	}

	@Override
	public void DeleteChatNotification(String sender, String receiver) {
		// TODO Auto-generated method stub

		Chat_notificationExample ex = new Chat_notificationExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andReceiverEqualTo(receiver);

		chat_notificationMapper.deleteByExample(ex);

	}

	@Override
	public boolean DeleteQzChatNotification(String receiver, String qz_id) {
		// TODO Auto-generated method stub

		Chat_notificationExample ex = new Chat_notificationExample();
		Criteria cr = ex.createCriteria();
		cr.andReceiverEqualTo(receiver);
		cr.andQzIdEqualTo(qz_id);

		try {
			chat_notificationMapper.deleteByExample(ex);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean InsertQzChatNotification(String receiver, String qz_id) {
		// TODO Auto-generated method stub
		List<Chat_notification> list = this.QueryQzChatNotification(receiver,
				qz_id);
		if (!list.isEmpty())

		{

			return false;
		}
		Chat_notification c_n = new Chat_notification();
		c_n.setQzId(qz_id);
		c_n.setReceiver(receiver);
		c_n.setCount(0);
		chat_notificationMapper.insertSelective(c_n);
		return true;

	}

	@Override
	public List<Chat_notification> QueryQzChatNotification(String receiver,
			String qz_id) {
		// TODO Auto-generated method stub
		Chat_notificationExample ex = new Chat_notificationExample();
		Criteria cr = ex.createCriteria();
		cr.andReceiverEqualTo(receiver);
		cr.andQzIdEqualTo(qz_id);
		return chat_notificationMapper.selectByExample(ex);

	}


	@Override
	public void UpdateQzChatNotification(String receiver, String qz_id,
			int count) {
		// TODO Auto-generated method stub
		Chat_notificationExample ex = new Chat_notificationExample();
		Criteria cr = ex.createCriteria();
		cr.andReceiverEqualTo(receiver);
		cr.andQzIdEqualTo(qz_id);
		Chat_notification c_n = new Chat_notification();
		c_n.setReceiver(receiver);
		c_n.setQzId(qz_id);
		c_n.setCount(count);
		chat_notificationMapper.updateByExampleSelective(c_n, ex);
	}

	@Override
	public boolean addQzCount(String receiver, String qzid) {
		// TODO Auto-generated method stub
		try{chat_notificationMapper.addQzCounts(receiver, qzid);}
		catch(Exception e) {return false;}
		return true;
	}

	

}
