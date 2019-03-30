package com.zufe.mychat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.bean.Qzxx;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.service.Chat_notificationService;
import com.zufe.mychat.service.QzcountService;
import com.zufe.mychat.service.QzusersService;
import com.zufe.mychat.service.QzxxService;

@Controller
public class QzxxController {

	@Autowired
	QzxxService qzxxService;
	@Autowired
	QzusersService qzusersService;
	@Autowired
	QzcountService qzcountService;
	@Autowired
	Chat_notificationService chat_service;

	@RequestMapping("/qzxxCreate")
	@ResponseBody
	public Msg createQz(@Valid Qzxx qzxx, BindingResult result,
			HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		String qzcreater = (String) session.getAttribute("username");
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {

				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("qzErrorFields", map);
		} else {
			if (qzxxService.insertOneQz(qzxx.getQzid(), qzxx.getQzname(),
					qzcreater)
					&& qzusersService
							.insertOneQzUser(qzxx.getQzid(), qzcreater)
					&& qzcountService.insertOneQzcount(qzxx.getQzid())
					&& chat_service.InsertQzChatNotification(qzcreater,
							qzxx.getQzid()))
				return Msg.success();
		}

		return Msg.fail();

	}

	@RequestMapping("/queryQzid")
	@ResponseBody
	public Msg queryQzid(String qzid) {

		if (qzxxService.getQzxxList(qzid).isEmpty())
			return Msg.success();

		return Msg.fail();
	}

	@RequestMapping("/queryQzxxWithJson")
	@ResponseBody
	public Msg queryQzxxWithStatus(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpSession session, String qzid) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String qzcreater = (String) session.getAttribute("username");
		PageHelper.startPage(pn, 5);

		List<Qzxx> list = qzxxService.queryQzxxWithStatus(qzid, qzcreater);
		PageInfo page = new PageInfo(list, 5);

		return Msg.success().add("pageInfo", page);

	}

	@RequestMapping("/QueryQz")
	public ModelAndView queryQz(String qzid) {
if(qzid.equals("")||qzid==null)return null;
		ModelAndView mv = new ModelAndView();
		mv.addObject("keyword", qzid);
		mv.setViewName("qzList");

		return mv;

	}
	
	
	
	@RequestMapping("/QueryQzxxWithCn")
	@ResponseBody
	public Msg queryQzxxWithCn(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
		PageHelper.startPage(pn, 5);

		List<Qzxx> list = qzxxService.queryQzxxWithQzcn(username);
		PageInfo page = new PageInfo(list, 5);

		return Msg.success().add("pageInfo", page);

	}
	
	@RequestMapping("/FindQzcreater")
	@ResponseBody
	public Msg findQzcreater(HttpSession session,String qzid) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
		
       if(!qzusersService.checkQzUsers(username, qzid))return Msg.fail();
       
       String creater;
       
       creater=qzxxService.getQzxxList(qzid).get(0).getQzcreater();
		
   return Msg.success().add("creater", creater);

	}
	

}
