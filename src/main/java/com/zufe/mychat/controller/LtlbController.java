package com.zufe.mychat.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zufe.mychat.bean.Ltlb;
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.service.Chat_notificationService;
import com.zufe.mychat.service.FriendsService;
import com.zufe.mychat.service.LtlbService;
import com.zufe.mychat.utils.ChatHashMap;

@Controller
public class LtlbController {

	@Autowired
	LtlbService ltlbService;
	@Autowired
	Chat_notificationService _chat_notificationService;
   @Autowired
    FriendsService friendsService;
	@RequestMapping("/QueryContentWithJson")
	@ResponseBody
	public Msg queryContentWithJson(String touser, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		List<Ltlb> list = null;
		try {
			String username=(String) session.getAttribute("username");
              if(!friendsService.checkRelation(username, touser))return Msg.fail();
			
			if (!_chat_notificationService.QueryChatNotification(touser,
					username).isEmpty())
				_chat_notificationService.UpdateChatNotification(touser,
						username, 0);
			ltlbService.updateContentRead(username, touser);
		
			
			while (true) {
				
				
				Thread.sleep(500);
				
				if(ChatHashMap.chat_hashMap.get(username+"_"+touser)||ChatHashMap.chat_hashMap.get(touser+"_"+username))
					{
					
					if (!_chat_notificationService.QueryChatNotification(touser,
							username).isEmpty())
					_chat_notificationService.UpdateChatNotification(touser,
							username, 0);
					
					ltlbService.updateContentRead(username, touser);
					
					Thread.sleep(500);
					list = ltlbService.queryLtlbByTime(username, touser);
					break;}
				
			}
			
			
			
			 ChatHashMap.chat_hashMap.put(username+"_"+touser, false);
	         ChatHashMap.chat_hashMap.put(touser+"_"+username, false);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			for (Ltlb ltlb : list) {

				String dateString = formatter.format(ltlb.getSj());
				ltlb.setSjCn(dateString);

			}

		} catch (Exception e) {
			return Msg.fail();
		}
		return Msg.success().add("LtlbList", list);

	}

	
	
	@RequestMapping("/QueryContentWithJsonFirst")
	@ResponseBody
	public Msg queryContentWithJsonFirst(String touser, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		List<Ltlb> list = null;
		
		try {
			String username=(String) session.getAttribute("username");
              if(!friendsService.checkRelation(username, touser))return Msg.fail();
			
			if (!_chat_notificationService.QueryChatNotification(touser,
					username).isEmpty())
				_chat_notificationService.UpdateChatNotification(touser,
						username, 0);
			ltlbService.updateContentRead(username, touser);
		
			Thread.sleep(500);
			
			list = ltlbService.queryLtlbByTime(username, touser);
			
			   ChatHashMap.chat_hashMap.put(username+"_"+touser, true);
		       ChatHashMap.chat_hashMap.put(touser+"_"+username, true);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			for (Ltlb ltlb : list) {

				String dateString = formatter.format(ltlb.getSj());
				ltlb.setSjCn(dateString);

			}

		} catch (Exception e) {
			return Msg.fail();
		}
		return Msg.success().add("LtlbList", list);

	}

	@RequestMapping("/InsertContent")
	@ResponseBody
	public Msg insertContent(String touser, String content, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
	
		if(!friendsService.checkRelation(username, touser))return Msg.fail();
		List <Ltlb> list = ltlbService.queryLtlbByTime(username, touser);
         
		if (ltlbService.insertContent(username, touser, content)) {
			
			 ChatHashMap.chat_hashMap.put(username+"_"+touser, true);
/*	      ChatHashMap.chat_hashMap.put(touser+"_"+username, true);*/
			return Msg.success();
		}

		return Msg.fail();

	}

}
