package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Chat_notification;
import com.zufe.mychat.bean.Chat_notificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Chat_notificationMapper {
	long countByExample(Chat_notificationExample example);

	int deleteByExample(Chat_notificationExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Chat_notification record);

	int insertSelective(Chat_notification record);

	List<Chat_notification> selectByExample(Chat_notificationExample example);

	Chat_notification selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Chat_notification record,
			@Param("example") Chat_notificationExample example);

	int updateByExample(@Param("record") Chat_notification record,
			@Param("example") Chat_notificationExample example);

	int updateByPrimaryKeySelective(Chat_notification record);

	int updateByPrimaryKey(Chat_notification record);
	
	int addQzCounts(String receiver,String qzid);
}