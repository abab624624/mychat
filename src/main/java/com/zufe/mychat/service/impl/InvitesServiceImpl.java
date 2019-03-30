package com.zufe.mychat.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Invites;
import com.zufe.mychat.bean.InvitesExample;
import com.zufe.mychat.bean.InvitesExample.Criteria;
import com.zufe.mychat.bean.InvitesExample.Criterion;
import com.zufe.mychat.dao.InvitesMapper;
import com.zufe.mychat.service.InvitesService;

@Service
public class InvitesServiceImpl implements InvitesService {
	@Autowired
	InvitesMapper invitesMapper;

	@Override
	public void InsertInvites(String sender, String receiver, String message) {
		// TODO Auto-generated method stub
		Invites invites = new Invites();

		invites.setSender(sender);
		invites.setReceiver(receiver);
		invites.setStatus((byte) 0);
		invites.setMessage(message);
		invitesMapper.insert(invites);

	}

	@Override
	public int QueryInvitesCount(String username) {
		// TODO Auto-generated method stub
		InvitesExample example = new InvitesExample();
		Criteria criteria = example.createCriteria();
		criteria.andReceiverEqualTo(username);
		criteria.andStatusEqualTo((byte) 0);
		int count = (int) invitesMapper.countByExample(example);

		return count;
	}

	@Override
	public List<Invites> QueryInvites(String username) {
		// TODO Auto-generated method stub
		InvitesExample example = new InvitesExample();
		Criteria criteria = example.createCriteria();
		criteria.andReceiverEqualTo(username);
		criteria.andStatusEqualTo((byte) 0);
		List<Invites> list = invitesMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean DeleteInvites(String sender, String receiver) {
		// TODO Auto-generated method stub

		InvitesExample example = new InvitesExample();
		Criteria criteria = example.createCriteria();
		criteria.andSenderEqualTo(sender);
		criteria.andReceiverEqualTo(receiver);
		try {
			invitesMapper.deleteByExample(example);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean UpdateInvites(String sender, String receiver) {
		// TODO Auto-generated method stub
		InvitesExample example = new InvitesExample();
		Criteria criteria = example.createCriteria();
		criteria.andSenderEqualTo(sender);
		criteria.andReceiverEqualTo(receiver);
		Invites invites = new Invites();
		invites.setSender(sender);
		invites.setReceiver(receiver);
		invites.setStatus((byte) 1);
		invitesMapper.updateByExampleSelective(invites, example);
		return true;
	}

	@Override
	public boolean CheckInvites(String sender, String receiver) {
		// TODO Auto-generated method stub
		
		InvitesExample example=new InvitesExample();
		Criteria criteria=example.createCriteria();
		criteria.andSenderEqualTo(sender);
		criteria.andReceiverEqualTo(receiver);
		criteria.andStatusEqualTo((byte) 0);
		
		if(invitesMapper.selectByExample(example).isEmpty())return false;
		return true;
	}

}
