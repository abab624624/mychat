package com.zufe.mychat.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.bean.UsersExample;
import com.zufe.mychat.bean.UsersExample.Criteria;
import com.zufe.mychat.dao.UsersMapper;
import com.zufe.mychat.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersMapper usersMapper;

	@Override
	public List<Users> getUserList(Users users) {

		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(users.getUsername());
		return usersMapper.selectByExample(example);

	}

	@Override
	public void saveUsers(Users users) {

		if (this.getUserList(users).isEmpty())
			usersMapper.insertSelective(users);

	}

	@Override
	public List<Users> queryUsersList(Users users) {

		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(users.getUsername());
		criteria.andPasswordEqualTo(users.getPassword());
		return usersMapper.selectByExample(example);
		// TODO Auto-generated method stub

	}

	@Override
	public void UpDateStatus(byte i, String username) {

		Users users = new Users();
		users.setSatus(i);
		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		usersMapper.updateByExampleSelective(users, example);

	}

	@Override
	public List<Users> getUserLikeList(String username) {
		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		username = '%' + username + '%';
		criteria.andUsernameLike(username);
		List<Users> list = usersMapper.selectByExample(example);

		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Users> fixUserList(String username, String key) {

		List<Users> list = usersMapper.selectUsersFix(username, key);

		return list;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> getUserListInQz(String qzid) {
		// TODO Auto-generated method stub
		return usersMapper.selectUsersInQz(qzid);
	}

}
