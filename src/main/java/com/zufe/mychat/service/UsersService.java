package com.zufe.mychat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.Users;

public interface UsersService {
	public List<Users> getUserList(Users users);

	public void saveUsers(Users users);

	public List<Users> queryUsersList(Users users);

	public void UpDateStatus(byte i, String username);

	public List<Users> getUserLikeList(String username);

	public List<Users> fixUserList(String username, String key);
	
	public List<Users>  getUserListInQz(String qzid);
		
	

}
