package com.zufe.mychat.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hamcrest.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.FriendsExample;
import com.zufe.mychat.bean.FriendsExample.Criteria;
import com.zufe.mychat.dao.FriendsMapper;
import com.zufe.mychat.service.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService {
	@Autowired
	FriendsMapper friendsMapper;

	@Override
	public List<Friends> queryFriends(String username) {

		List<Friends> list = null;
		FriendsExample example = new FriendsExample();
		example.or().andUser1EqualTo(username);
		example.or().andUser2EqualTo(username);

		list = friendsMapper.selectByExample(example);
		return list;

		// TODO Auto-generated method stub

	}

	@Override
	public List<Friends> queryFriendsWithStatus(String username) {

		List<Friends> list = null;

		list = friendsMapper.selectFriendsWithStatus(username);

		return list;

		// TODO Auto-generated method stub

	}

	@Override
	public boolean addFriends(String user1, String user2) {
		// TODO Auto-generated method stub

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");// 可以方便地修改日期格式

		String id = dateFormat.format(now);

		if(this.checkRelation(user1, user2))return false; 
		
		Friends friends = new Friends();
		friends.setFriendsId(id);
		friends.setUser1(user1);
		friends.setUser2(user2);
		friendsMapper.insert(friends);
		return true;
	}

	@Override
	public boolean deleteFriends(String user1, String user2) {
		// TODO Auto-generated method stub
		FriendsExample example = new FriendsExample();

		example.or().andUser1EqualTo(user1).andUser2EqualTo(user2);
		example.or().andUser2EqualTo(user1).andUser1EqualTo(user2);

		try {
			friendsMapper.deleteByExample(example);
		}

		catch (Exception e) {
			return false;
		}

		return true;

	}

	@Override
	public boolean checkRelation(String user1, String user2) {
		// TODO Auto-generated method stub
		FriendsExample ex = new FriendsExample();
		Criteria cr=ex.createCriteria();
		ex.or().andUser1EqualTo(user1).andUser2EqualTo(user2);
		ex.or().andUser2EqualTo(user1).andUser1EqualTo(user2);
		if(friendsMapper.selectByExample(ex).isEmpty())return false;
		return true;
	}

}
