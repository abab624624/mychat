package com.zufe.mychat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.service.Chat_notificationService;
import com.zufe.mychat.service.FriendsService;
import com.zufe.mychat.service.UsersService;

@Controller
public class FriendsController {

	@Autowired
	private FriendsService friendsService;

	@Autowired
	private Chat_notificationService _chat_notificationService;

	@RequestMapping("/QueryFriends")
	@ResponseBody
	public Msg getFriensWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "username", defaultValue = "") String username) {

		// 引入pageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页显示数量
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟着的一个查询，就是一个分页查询
		List<Friends> list = friendsService.queryFriends(username);
		// 用PageInfo对结果进行包装,连续传入5页
		PageInfo page = new PageInfo(list, 5);

		return Msg.success().add("pageInfo", page);

	}

	@RequestMapping("/QueryFriendsWithStatus")
	@ResponseBody
	public Msg getFriensWithStatusWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "username", defaultValue = "") String username) {
  if(username.equals(""))return Msg.fail();
		// 引入pageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页显示数量
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟着的一个查询，就是一个分页查询
		List<Friends> list = friendsService.queryFriendsWithStatus(username);
		// 用PageInfo对结果进行包装,连续传入5页
		PageInfo page = new PageInfo(list, 5);

		return Msg.success().add("pageInfo", page);

	}

	@RequestMapping("/deleteFriends")
	@ResponseBody
	public Msg deletFriends(String user1, String user2, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		if (session.getAttribute("username").equals(user1)) {

			if (friendsService.deleteFriends(user1, user2)) {

				if (!_chat_notificationService.QueryChatNotification(user1,
						user2).isEmpty())
					_chat_notificationService.DeleteChatNotification(user1,
							user2);

				if (!_chat_notificationService.QueryChatNotification(user2,
						user1).isEmpty())
					_chat_notificationService.DeleteChatNotification(user2,
							user1);

				return Msg.success();

			}

		}

		return Msg.fail();

	}

}
