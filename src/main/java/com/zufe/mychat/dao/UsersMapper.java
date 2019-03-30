package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.Users;
import com.zufe.mychat.bean.UsersExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
	long countByExample(UsersExample example);

	int deleteByExample(UsersExample example);

	int deleteByPrimaryKey(Integer usersId);

	int insert(Users record);

	int insertSelective(Users record);

	List<Users> selectByExample(UsersExample example);

	Users selectByPrimaryKey(Integer usersId);

	int updateByExampleSelective(@Param("record") Users record,
			@Param("example") UsersExample example);

	int updateByExample(@Param("record") Users record,
			@Param("example") UsersExample example);

	int updateByPrimaryKeySelective(Users record);

	int updateByPrimaryKey(Users record);

	List<Users> selectUsersFix(String username, String key);
	
	List<Users> selectUsersInQz(String qzid);
}