package com.zufe.mychat.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zufe.mychat.bean.Msg;
import com.zufe.mychat.bean.Qzltlb;
import com.zufe.mychat.service.Chat_notificationService;
import com.zufe.mychat.service.QzltlbService;
import com.zufe.mychat.service.QzusersService;
import com.zufe.mychat.utils.QzChatHashMap;

@Controller
public class QzltlbController {


	@Autowired
	QzusersService qzusersService;
	@Autowired 
	Chat_notificationService cn;
	@Autowired
	QzltlbService qzltlbService;
	@RequestMapping("/QueryQzContentWithJson")
	@ResponseBody
	public Msg queryQzContentWithJson(String qzid, HttpSession session,String count) {
		if(session.getAttribute("username")==null)return Msg.fail();
		List<Qzltlb> list = null;
		String username = (String) session.getAttribute("username");
		int count1 = Integer.parseInt(count);
		if(!qzusersService.checkQzUsers(username, qzid))return Msg.fail();
		try {

			while (true) {
				Thread.sleep(300);
				
		         if(QzChatHashMap.QzChat_hashMap.get(qzid)>count1)
		         {
		        	 if (!cn.QueryQzChatNotification(username, qzid).isEmpty())
		 				cn.UpdateQzChatNotification(username, qzid, 0);
		        	 break;
		         }
				
			}
		
		
			
			list = qzltlbService.queryQzLtlbByTime( qzid);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			for (Qzltlb qzltlb : list) {

				String dateString = formatter.format(qzltlb.getSj());
				qzltlb.setSjCn(dateString);

			}

		} catch (Exception e) {
			return Msg.fail();
		}
		return Msg.success().add("QzLtlbList", list);

	}
	
	@RequestMapping("/QueryQzContentWithJsonFirst")
	@ResponseBody
	public Msg queryQzContentWithJsonFirst(String qzid, HttpSession session) {
		if(session.getAttribute("username")==null)return Msg.fail();
		List<Qzltlb> list = null;
		String username = (String) session.getAttribute("username");
		if(!qzusersService.checkQzUsers(username, qzid))return Msg.fail();
		try {

		
			if (!cn.QueryQzChatNotification(username, qzid).isEmpty())
				cn.UpdateQzChatNotification(username, qzid, 0);
		
			
			list = qzltlbService.queryQzLtlbByTime(qzid);

				
				QzChatHashMap.QzChat_hashMap.put(qzid,list.size());
				
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			for (Qzltlb qzltlb : list) {

				String dateString = formatter.format(qzltlb.getSj());
				qzltlb.setSjCn(dateString);

			}

		} catch (Exception e) {
			return Msg.fail();
		}
		return Msg.success().add("QzLtlbList", list).add("count", list.size());

	}
	
	
	@RequestMapping("/InsertQzContent")
	@ResponseBody
	public  Msg insertContent(String qzid, String content, HttpSession session) throws InterruptedException {
		if(session.getAttribute("username")==null)return Msg.fail();
		String username = (String) session.getAttribute("username");
	
		if(!qzusersService.checkQzUsers(username, qzid))return Msg.fail();
		List<Qzltlb>list = qzltlbService.queryQzLtlbByTime(qzid);
		if (qzltlbService.insertQzContent(username, qzid, content)) {
			QzChatHashMap.QzChat_hashMap.put(qzid,list.size()+1);
		
			return Msg.success();
		}
		
		

		return Msg.fail();

	}
}
