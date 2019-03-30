package com.zufe.mychat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Qzltlb;
import com.zufe.mychat.bean.QzltlbExample;
import com.zufe.mychat.bean.QzltlbExample.Criteria;
import com.zufe.mychat.dao.QzltlbMapper;
import com.zufe.mychat.service.QzltlbService;
@Service
public class QzltlbServiceImpl implements QzltlbService {
@Autowired 
QzltlbMapper qzltlbMapper;
	@Override
	public List<Qzltlb> queryQzLtlb(String username, String qzid) {
		// TODO Auto-generated method stub
		QzltlbExample ex=new QzltlbExample();
		Criteria cr=ex.createCriteria();
		cr.andQzidEqualTo(qzid);
		cr.andUsernameEqualTo(username);
		return qzltlbMapper.selectByExample(ex);
	
		
	}

	@Override
	public boolean insertQzContent(String username, String qzid, String content) {
		// TODO Auto-generated method stub
		Qzltlb qzltlb=new Qzltlb();
		qzltlb.setQzid(qzid);
		qzltlb.setSj(new Date());
		qzltlb.setUsername(username);
		qzltlb.setContent(content);
		try {qzltlbMapper.insertSelective(qzltlb);}
		catch(Exception e) {return false;}
		return true;
	}



	@Override
	public List<Qzltlb> queryQzLtlbByTime(String qzid) {
		// TODO Auto-generated method stub
		return qzltlbMapper.selectQzContentOrderByTime(qzid);
	}

}
