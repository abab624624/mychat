package com.zufe.mychat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Ltlb;
import com.zufe.mychat.bean.LtlbExample;
import com.zufe.mychat.bean.LtlbExample.Criteria;
import com.zufe.mychat.dao.LtlbMapper;
import com.zufe.mychat.service.LtlbService;

@Service
public class LtlbServiceImpl implements LtlbService {
	@Autowired
	LtlbMapper ltlbMapper;

	@Override
	public List<Ltlb> queryLtlb(String username, String touser) {
		// TODO Auto-generated method stub
		LtlbExample ex = new LtlbExample();

		Criteria criteria = ex.createCriteria();

		ex.or().andUsernameEqualTo(username).andTouserEqualTo(touser);
		ex.or().andTouserEqualTo(username).andUsernameEqualTo(touser);
		return ltlbMapper.selectByExample(ex);

	}

	@Override
	public boolean insertContent(String username, String touser, String content) {
		// TODO Auto-generated method stub

		Ltlb ltlb = new Ltlb();
		ltlb.setUsername(username);
		ltlb.setTouser(touser);
		ltlb.setSj(new Date());
		ltlb.setContent(content);
		try {
			ltlbMapper.insertSelective(ltlb);
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	@Override
	public boolean updateContentRead(String username, String touser) {
		// TODO Auto-generated method stub
		LtlbExample ex = new LtlbExample();

		Criteria cr = ex.createCriteria();

		cr.andUsernameEqualTo(touser);
		cr.andTouserEqualTo(username);

		Ltlb ltlb = new Ltlb();
		ltlb.setMyread((byte) 1);

		ltlbMapper.updateByExampleSelective(ltlb, ex);
		return true;
	}

	@Override
	public List<Ltlb> queryLtlbByTime(String username, String touser) {
		// TODO Auto-generated method stub
		return ltlbMapper.selectContentOrderByTime(username, touser);
	}

}
