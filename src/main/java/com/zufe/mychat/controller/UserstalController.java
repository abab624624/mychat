package com.zufe.mychat.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.service.FriendsService;
import com.zufe.mychat.service.QzusersService;
import com.zufe.mychat.service.UsersService;

@Controller
public class UserstalController {
	@Autowired
	 private UsersService usersService;
	@Autowired
	 private FriendsService friendsService;
@Autowired
QzusersService qzusersService;
	@RequestMapping("/checkUsers")
	@ResponseBody
	public Msg CheckUsers(String username) throws Exception {
		Users users = new Users();

		users.setUsername(username);

		List<Users> list = usersService.getUserList(users);
		if (list.isEmpty())
			return Msg.success();

		else
			return Msg.fail();
	}

	@RequestMapping("/registerUsers")
	@ResponseBody
	public Msg SaveUsers(@Valid Users users, BindingResult result) {

		Map<String, Object> map = new HashMap<String, Object>();
		if (result.hasErrors()) {
			// 校验失败返回模态框的错误信息
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {

				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		} else {
			usersService.saveUsers(users);
			return Msg.success();
		}

	}

	@RequestMapping("/loginUsers")
	public ModelAndView LoginUsers(HttpSession session, Users users)
			throws Exception {
	
		ModelAndView modelAndview = new ModelAndView();
		List<Users> list = null;
		list = usersService.queryUsersList(users);
		List<Friends> list1 = friendsService.queryFriends(users.getUsername());

		try {
			if (!list.isEmpty()) {

				session.setAttribute("username", users.getUsername());
				session.setAttribute("myfriendList", list1);

				modelAndview.addObject("status", list.get(0).getSatus());

				modelAndview.setViewName("list");

				return modelAndview;

			}

			modelAndview.setViewName("loginfail");

			return modelAndview;

		} catch (Exception e) {
			modelAndview.setViewName("loginfail");

			return modelAndview;
		}

	}

	@RequestMapping("/loginOut")
	public String LoginOut(HttpSession session) throws Exception {
		if(session.getAttribute("username")==null)return null;
		session.invalidate();

		return "redirect:/index.jsp";

	}

	@RequestMapping("/onLine")
	public ModelAndView OnLine(String username) {
		ModelAndView modelAndview = new ModelAndView();
		usersService.UpDateStatus((byte) 1, username);

		modelAndview.addObject("status", 1);
		modelAndview.setViewName("list");
		return modelAndview;

	}

	@RequestMapping("/outLine")
	public ModelAndView OutLine(String username) {
		ModelAndView modelAndview = new ModelAndView();
		usersService.UpDateStatus((byte) 0, username);

		modelAndview.addObject("status", 0);
		modelAndview.setViewName("list");
		return modelAndview;

	}

	@RequestMapping("/queryUsersWithJson")
	@ResponseBody
	public Msg QueryUsersWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			String username, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String usersession = (String) session.getAttribute("username");
		// 引入pageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页显示数量

		if (!username.equals("")) {
			String key = "%" + username + "%";
			// 用PageInfo对结果进行包装,连续传入5页

			PageHelper.startPage(pn, 5);
			// List<Users> list = usersService.getUserLikeList(username);
			List<Users> list = usersService.fixUserList(usersession, key);
			PageInfo page = new PageInfo(list, 5);
			return Msg.success().add("pageInfo", page);
		}
		return Msg.fail();

	}

	@RequestMapping("/queryUsers")
	public ModelAndView QueryUsers(String username) {
 if(username.equals("")||username==null)return null;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("queryList");
		mv.addObject("keyword", username);
		return mv;

	}
	
	
	@RequestMapping("/QueryQzusers")
	@ResponseBody
	public Msg QueryQzusersWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			String qzid, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		List<Users> list=null;
		String username = (String) session.getAttribute("username");
		if(!qzusersService.checkQzUsers(username, qzid))return Msg.fail();
		PageHelper.startPage(pn, 5);

		try {	
			// List<Users> list = usersService.getUserLikeList(username);
			 list = usersService.getUserListInQz(qzid);
			}
		catch(Exception e) {return Msg.fail();}
		
		PageInfo page = new PageInfo(list, 5);
			return Msg.success().add("pageInfo", page);
		
	

	}

}
