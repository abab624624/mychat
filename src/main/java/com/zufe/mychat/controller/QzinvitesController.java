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
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.bean.Qzinvites;
import com.zufe.mychat.bean.Qzxx;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.service.QzinvitesService;
import com.zufe.mychat.service.QzusersService;
import com.zufe.mychat.service.QzxxService;

@Controller
public class QzinvitesController {
	@Autowired
	QzinvitesService qzinvitesService;
	@Autowired
	QzxxService qzxxService;
@Autowired
QzusersService qzusersService;
	@RequestMapping("/SendQzInvites")
	@ResponseBody
	public Msg sendQzInvitesMessage(String message, String qzid,
			HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String sender = (String) session.getAttribute("username");
          if(qzusersService.checkQzUsers(sender, qzid))return Msg.fail();
		if (qzinvitesService.insertQzinvites(sender, qzid, message))
			return Msg.success();

		return Msg.fail();
	}

	@RequestMapping("/QueryQzInvitesWithJson")
	@ResponseBody
	public Msg queryQzInvitesWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");

		PageHelper.startPage(pn, 5);

		List<Qzinvites> list = qzinvitesService
				.queryQzinvitesByCreater(username);
		PageInfo page = new PageInfo(list, 5);
		return Msg.success().add("pageInfo", page);

	}

	@RequestMapping("/QueryQzInvitesCount")
	@ResponseBody
	public Msg queryQzInvitesCount(HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
		List<Qzinvites> list = qzinvitesService
				.queryQzinvitesByCreater(username);

		return Msg.success().add("qzcount", list.size());

	}

	@RequestMapping("/RefuseQzInvites")
	@ResponseBody
	public Msg RefuseQzinvites(String sender, String qzid, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
		if (!qzxxService.SecurySys(qzid, username))
			return Msg.fail();
		if (qzinvitesService.clearQzinvites(sender, qzid))
			return Msg.success();
		return Msg.fail();

	}

}
