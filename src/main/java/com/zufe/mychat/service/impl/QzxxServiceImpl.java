package com.zufe.mychat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Qzxx;
import com.zufe.mychat.bean.QzxxExample;
import com.zufe.mychat.bean.QzxxExample.Criteria;
import com.zufe.mychat.dao.QzxxMapper;
import com.zufe.mychat.service.QzxxService;

@Service
public class QzxxServiceImpl implements QzxxService {
	@Autowired
	QzxxMapper qzxxMapper;

	@Override
	public boolean insertOneQz(String qzid, String qzname, String qzcreater) {
		List<Qzxx> list = getQzxxList(qzid);
		if (!list.isEmpty()) {

			if (!list.get(0).getYx()) {
				if (upDateQzxx(qzid, true))
					return true;
				return false;
			}

			if (list.get(0).getYx()) {

				return false;

			}

		}
		Qzxx qzxx = new Qzxx();
		qzxx.setQzid(qzid);
		qzxx.setQzname(qzname);
		qzxx.setQzcreater(qzcreater);
		qzxx.setCreateTime(new Date());
		qzxxMapper.insertSelective(qzxx);

		return true;
		// TODO Auto-generated method stub

	}

	public List<Qzxx> getQzxxList(String qzid) {

		QzxxExample example = new QzxxExample();
		Criteria criteria = example.createCriteria();
		criteria.andQzidEqualTo(qzid);
		return qzxxMapper.selectByExample(example);

	}

	@Override
	public List<Qzxx> queryQzxxWithStatus(String qzid, String qzcreater) {
		// TODO Auto-generated method stub
		qzid = '%' + qzid + '%';
		List<Qzxx> list = qzxxMapper.selectQzxxWithStatus(qzid, qzcreater);

		return list;
	}

	@Override
	public boolean upDateQzxx(String qzid, boolean yx) {
		QzxxExample example = new QzxxExample();
		Criteria criteria = example.createCriteria();
		criteria.andQzidEqualTo(qzid);
		Qzxx qzxx = new Qzxx();

		qzxx.setCreateTime(new Date());
		qzxx.setYx(yx);

		try {
			qzxxMapper.updateByExampleSelective(qzxx, example);
		}

		catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean disableQzxx(String qzid) {
		// TODO Auto-generated method stub
		List<Qzxx> list = getQzxxList(qzid);
		if (list.isEmpty())
			return false;

		if (upDateQzxx(qzid, false))
			return true;

		return false;
	}

	@Override
	public boolean SecurySys(String qzid, String username) {
		// TODO Auto-generated method stub

		if (qzxxMapper.selectByPrimaryKey(qzid).getQzcreater().equals(username))
			return true;

		return false;
	}

	@Override
	public List<Qzxx> queryQzxxWithQzount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qzxx> queryQzxxWithQzcn(String username) {
		// TODO Auto-generated method stub
		return qzxxMapper.selectQzxxWithCn(username);
	}

}
