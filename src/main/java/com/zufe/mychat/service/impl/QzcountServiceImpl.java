package com.zufe.mychat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Qzcount;
import com.zufe.mychat.bean.QzcountExample;
import com.zufe.mychat.bean.QzcountExample.Criteria;
import com.zufe.mychat.dao.QzcountMapper;
import com.zufe.mychat.service.QzcountService;

@Service
public class QzcountServiceImpl implements QzcountService {
	@Autowired
	QzcountMapper qzcountMapper;

	@Override
	public boolean insertOneQzcount(String qzid) {
		// TODO Auto-generated method stub
		Qzcount qzcount = new Qzcount();
		qzcount.setCount(1);
		qzcount.setQzid(qzid);
		List<Qzcount> list = queryQzcount(qzid);
		if (list.isEmpty()) {
			qzcountMapper.insertSelective(qzcount);
			return true;
		}

		return false;
	}

	@Override
	public List<Qzcount> queryQzcount(String qzid) {
		// TODO Auto-generated method stub

		QzcountExample ex = new QzcountExample();
		Criteria cr = ex.createCriteria();
		cr.andQzidEqualTo(qzid);
		List<Qzcount> list = qzcountMapper.selectByExample(ex);

		return list;
	}

	@Override
	public boolean updateQzcount(String qzid, int count) {
		// TODO Auto-generated method stub

		if (queryQzcount(qzid).isEmpty())
			return false;

		Qzcount qzcount = new Qzcount();
		qzcount.setCount(count);

		QzcountExample ex = new QzcountExample();
		Criteria cr = ex.createCriteria();
		cr.andQzidEqualTo(qzid);

		qzcountMapper.updateByExampleSelective(qzcount, ex);
		return true;
	}

	@Override
	public boolean addQzCount(String qzid) {
		// TODO Auto-generated method stub
		List<Qzcount> list = queryQzcount(qzid);

		if (this.updateQzcount(qzid, list.get(0).getCount() + 1))
			return true;
		return false;
	}

	@Override
	public boolean reduceQzCount(String qzid) {
		// TODO Auto-generated method stub

		List<Qzcount> list = queryQzcount(qzid);
		if (this.updateQzcount(qzid, list.get(0).getCount() - 1))
			return true;

		return false;
	}

}
