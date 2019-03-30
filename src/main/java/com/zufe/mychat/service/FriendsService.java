package com.zufe.mychat.service;

import java.util.List;

import com.zufe.mychat.bean.Friends;

public interface FriendsService {

	public List<Friends> queryFriends(String username);

	public List<Friends> queryFriendsWithStatus(String username);

	public boolean addFriends(String user1, String user2);

	public boolean deleteFriends(String user1, String user2);
	
	public boolean checkRelation(String user1,String user2);

}
