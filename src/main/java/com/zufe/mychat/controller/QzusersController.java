package com.zufe.mychat.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.service.Chat_notificationService;
import com.zufe.mychat.service.QzcountService;
import com.zufe.mychat.service.QzinvitesService;
import com.zufe.mychat.service.QzusersService;
import com.zufe.mychat.service.QzxxService;

@Controller
public class QzusersController {
	@Autowired
	QzusersService qzusersService;
	@Autowired
	QzinvitesService qzinvitesService;
	@Autowired
	QzcountService qzcountService;
	@Autowired
	Chat_notificationService cnService;
	@Autowired
	QzxxService qzxxService;
	@RequestMapping("/JoinQz")
	@ResponseBody
	public Msg joinQz(String qzid, String sender, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");

		if (!qzxxService.SecurySys(qzid, username))
			return Msg.fail();
		if(!qzinvitesService.checkQzinvites(sender, qzid))return Msg.fail();
		
		if (qzusersService.insertOneQzUser(qzid, sender)
				&& qzinvitesService.clearQzinvites(sender, qzid)
				&& cnService.InsertQzChatNotification(sender, qzid)
				&& qzcountService.addQzCount(qzid))
			return Msg.success();

		return Msg.fail();
	}

	@RequestMapping("/LeaveQz")
	@ResponseBody
	public Msg leaveQz(String qzid, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
 if(qzxxService.SecurySys(qzid, username))return Msg.fail().add("msg", "群创始人不可退出群组!");
		if (qzusersService.leaveOneQz(qzid, username)
				&& cnService.DeleteQzChatNotification(username, qzid)
				&& qzcountService.reduceQzCount(qzid)
			)

			return Msg.success();

		return Msg.fail();

	}

}
