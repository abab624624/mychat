package com.zufe.mychat.controller;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.service.Chat_notificationService;

@Controller
public class Chat_notificationCotroller {

	@Autowired
	Chat_notificationService _chat_notificationService;

	@RequestMapping("/AddNotification")
	@ResponseBody
	public Msg addNotification(String sender, String receiver,
			HttpSession session) {
if(session.getAttribute("username")==null)return Msg.fail();
		if (((String) session.getAttribute("username")).equals(sender)) {

			try {
				int count = ( _chat_notificationService
						.QueryChatNotification(sender, receiver).get(0))
						.getCount() + 1;
				_chat_notificationService.UpdateChatNotification(sender,
						receiver, count);
			}

			catch (Exception e) {
				return Msg.fail();
			}

		}
		return Msg.success();

	}

	

	@RequestMapping("/AddQzNotification")
	@ResponseBody
	public Msg addQzNotification(String qzid, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
  String receiver=(String) session.getAttribute("username");

			try {
				_chat_notificationService.addQzCount(receiver, qzid);
			}

			catch (Exception e) {
				return Msg.fail();
			}

		
		return Msg.success();

	}

	
	@RequestMapping("/ClearNotification")
	@ResponseBody
	public Msg clearNotification(String sender, String receiver,
			HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		if (session.getAttribute("username").equals(sender)) {

			if (!_chat_notificationService.QueryChatNotification(receiver,
					sender).isEmpty())
				_chat_notificationService.UpdateChatNotification(receiver,
						sender, 0);

		}
		return Msg.success();

	}

	@RequestMapping("/QueryNotificationCount")
	@ResponseBody
	public Msg queryNotificationCount(String sender, String receiver,
			HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		int count = 0;
		if (session.getAttribute("username").equals(sender)) {

			try {
				count = _chat_notificationService
						.QueryChatNotification(receiver, sender).get(0)
						.getCount();
			} catch (Exception e) {
				return Msg.fail();
			}

		}
		return Msg.success().add("countNotification", count);

	}

}
