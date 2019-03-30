package com.zufe.mychat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zufe.mychat.bean.Chat_notification;
import com.zufe.mychat.bean.Invites;
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.service.Chat_notificationService;
import com.zufe.mychat.service.FriendsService;
import com.zufe.mychat.service.InvitesService;
import com.zufe.mychat.service.UsersService;

@Controller
public class InvitesController {

	@Autowired
	InvitesService invitesService;
	@Autowired
	FriendsService friendsService;
	@Autowired
	Chat_notificationService _chat_notificationService;
	@Autowired
	UsersService usersService;

	@RequestMapping("/sendMessage")
	@ResponseBody
	public Msg SendMessage(HttpSession session, String receiver, String message) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String sender = (String) session.getAttribute("username");
		
		if(friendsService.checkRelation(sender, receiver))return Msg.fail();
		invitesService.InsertInvites(sender, receiver, message);

		return Msg.success();

	}

	@RequestMapping("queryInvitesCount")
	@ResponseBody
	public Msg QueryInvitesCount(String username) {

		int count = invitesService.QueryInvitesCount(username);

		return Msg.success().add("count", count);

	}

	@RequestMapping("/queryInvitesWithJson")
	@ResponseBody
	public Msg QueryUsersWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			String username) {
if(username.equals("")||username==null)return Msg.fail();
		// 引入pageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页显示数量
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟着的一个查询，就是一个分页查询
		List<Invites> list = invitesService.QueryInvites(username);
		// 用PageInfo对结果进行包装,连续传入5页
		PageInfo page = new PageInfo(list, 5);

		return Msg.success().add("pageInfo", page);

	}

	@RequestMapping("/agreeInvites")
	@ResponseBody
	public Msg AgreeInvites(String sender, String receiver, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
		if(!invitesService.CheckInvites(sender, receiver))return Msg.fail();
		
		if (sender.equals(username))
			return Msg.fail();

		if (username.equals(receiver)) {
			if (friendsService.addFriends(receiver, sender)) {

				invitesService.UpdateInvites(sender, receiver);

					if (_chat_notificationService.QueryChatNotification(sender,
							receiver).isEmpty())
						_chat_notificationService.InsertChatNotification(
								sender, receiver);

				if (_chat_notificationService.QueryChatNotification(receiver,
						sender).isEmpty())
					_chat_notificationService.InsertChatNotification(receiver,
							sender);
				
				return Msg.success();
			}
		}
		return Msg.fail();

	}

	@RequestMapping("/refuseInvites")
	@ResponseBody
	public Msg RefuseInvites(String sender, String receiver, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
		if (username.equals(receiver)) {

			if (invitesService.UpdateInvites(sender, receiver))

				return Msg.success();
		}

		return Msg.fail();

	}

}
