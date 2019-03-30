package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Friends;
import com.zufe.mychat.bean.FriendsExample;
import com.zufe.mychat.bean.FriendsKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FriendsMapper {
	long countByExample(FriendsExample example);

	int deleteByExample(FriendsExample example);

	int deleteByPrimaryKey(FriendsKey key);

	int insert(Friends record);

	int insertSelective(Friends record);

	List<Friends> selectByExample(FriendsExample example);

	Friends selectByPrimaryKey(FriendsKey key);

	int updateByExampleSelective(@Param("record") Friends record,
			@Param("example") FriendsExample example);

	int updateByExample(@Param("record") Friends record,
			@Param("example") FriendsExample example);

	int updateByPrimaryKeySelective(Friends record);

	int updateByPrimaryKey(Friends record);

	List<Friends> selectFriendsWithStatus(String username);
}