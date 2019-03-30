package com.zufe.mychat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Qzinvites;
import com.zufe.mychat.bean.QzinvitesExample;
import com.zufe.mychat.bean.QzinvitesExample.Criteria;
import com.zufe.mychat.dao.QzinvitesMapper;
import com.zufe.mychat.service.QzinvitesService;

@Service
public class QzinvitesServiceImpl implements QzinvitesService {
	@Autowired
	QzinvitesMapper qzinvitesMapper;

	@Override
	public boolean insertQzinvites(String sender, String qzid, String message) {
		// TODO Auto-generated method stub
		List<Qzinvites> list = this.queryQzinvites(sender, qzid);
		if (list.isEmpty()) {
			Qzinvites qzinvites = new Qzinvites();
			qzinvites.setQzid(qzid);
			qzinvites.setSender(sender);
			qzinvites.setMessage(message);

			qzinvitesMapper.insertSelective(qzinvites);
			return true;

		}

		if (this.updateQzinvites(sender, qzid, message, false))
			return true;
		return false;

	}

	@Override
	public boolean updateQzinvites(String sender, String qzid, String message,
			boolean status) {
		// TODO Auto-generated method stub
		QzinvitesExample ex = new QzinvitesExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andQzidEqualTo(qzid);

		Qzinvites qzinvites = new Qzinvites();
		qzinvites.setQzid(qzid);
		qzinvites.setSender(sender);
		qzinvites.setMessage(message);
		qzinvites.setSatus(status);
		qzinvitesMapper.updateByExampleSelective(qzinvites, ex);

		return true;
	}

	@Override
	public List<Qzinvites> queryQzinvites(String sender, String qzid) {
		// TODO Auto-generated method stub

		QzinvitesExample ex = new QzinvitesExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andQzidEqualTo(qzid);
		return qzinvitesMapper.selectByExample(ex);

	}

	@Override
	public List<Qzinvites> queryQzinvitesByCreater(String username) {
		// TODO Auto-generated method stub

		return qzinvitesMapper.selectQzusersByCreater(username);
	}

	@Override
	public boolean clearQzinvites(String sender, String qzid) {
		// TODO Auto-generated method stub

		QzinvitesExample ex = new QzinvitesExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andQzidEqualTo(qzid);

		Qzinvites qzinvites = new Qzinvites();
		qzinvites.setQzid(qzid);
		qzinvites.setSender(sender);

		qzinvites.setSatus(true);
		try {
			qzinvitesMapper.updateByExampleSelective(qzinvites, ex);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	
	@Override
	public boolean reloadQzinvites(String sender, String qzid) {
		// TODO Auto-generated method stub

		QzinvitesExample ex = new QzinvitesExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andQzidEqualTo(qzid);

		Qzinvites qzinvites = new Qzinvites();
		qzinvites.setQzid(qzid);
		qzinvites.setSender(sender);

		qzinvites.setSatus(false);
		try {
			qzinvitesMapper.updateByExampleSelective(qzinvites, ex);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean checkQzinvites(String sender, String qzid) {
		// TODO Auto-generated method stub
		QzinvitesExample ex = new QzinvitesExample();
		Criteria cr = ex.createCriteria();
		cr.andSenderEqualTo(sender);
		cr.andQzidEqualTo(qzid);
        cr.andSatusEqualTo(false);
		
		if(qzinvitesMapper.selectByExample(ex).isEmpty())return false;
		return true;
	}
}
