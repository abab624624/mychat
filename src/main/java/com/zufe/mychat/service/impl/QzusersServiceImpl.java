package com.zufe.mychat.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Qzcount;
import com.zufe.mychat.bean.Qzusers;
import com.zufe.mychat.bean.QzusersExample;
import com.zufe.mychat.bean.QzusersExample.Criteria;
import com.zufe.mychat.dao.QzusersMapper;
import com.zufe.mychat.service.QzusersService;

@Service
public class QzusersServiceImpl implements QzusersService {
	@Autowired
	QzusersMapper qzusersMapper;

	@Override
	public boolean insertOneQzUser(String qzid, String username) {
		// TODO Auto-generated method stub

		if (queryQzusers(qzid, username).isEmpty()) {

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyyMMddHHmmssS");

			String id = dateFormat.format(new Date());
			Qzusers qzusers = new Qzusers();
			qzusers.setQzid(qzid);
			qzusers.setUsername(username);
			qzusers.setJoinTime(new Date());
			qzusers.setQzusersId(id);
			;
			qzusersMapper.insertSelective(qzusers);
			return true;
		}

		if (this.UpdateQzusers(qzid, username, true))
			return true;

		return false;
	}

	@Override
	public List<Qzusers> queryQzusers(String qzid, String username) {
		// TODO Auto-generated method stub

		QzusersExample ex = new QzusersExample();
		Criteria cr = ex.createCriteria();
		cr.andQzidEqualTo(qzid);
		cr.andUsernameEqualTo(username);
	
		return qzusersMapper.selectByExample(ex);

	}
	
	public List<Qzusers> queryQzusersWithYx(String qzid,String username) {
		
		

		QzusersExample ex = new QzusersExample();
		Criteria cr = ex.createCriteria();
		cr.andQzidEqualTo(qzid);
		cr.andUsernameEqualTo(username);
		cr.andYxEqualTo(true);
		return qzusersMapper.selectByExample(ex);

		
	}

	public boolean UpdateQzusers(String qzid, String username, Boolean yx) {
		// TODO Auto-generated method stub

		QzusersExample ex = new QzusersExample();
		Criteria cr = ex.createCriteria();
		cr.andQzidEqualTo(qzid);
		cr.andUsernameEqualTo(username);

		Qzusers qzusers = new Qzusers();
		qzusers.setYx(yx);
		try {
			qzusersMapper.updateByExampleSelective(qzusers, ex);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean leaveOneQz(String qzid, String username) {
		// TODO Auto-generated method stub
		List<Qzusers> list = this.queryQzusers(qzid, username);

		if (list.isEmpty())
			return false;
		this.UpdateQzusers(qzid, username, false);
		return true;
	}

	@Override
	public boolean checkQzUsers(String username, String qzid) {
		// TODO Auto-generated method stub
		
		
		return !this.queryQzusersWithYx(qzid, username).isEmpty();
		
		
		
		
		
	}

}
