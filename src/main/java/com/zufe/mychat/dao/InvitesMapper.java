package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Invites;
import com.zufe.mychat.bean.InvitesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvitesMapper {
	long countByExample(InvitesExample example);

	int deleteByExample(InvitesExample example);

	int deleteByPrimaryKey(Integer invitesId);

	int insert(Invites record);

	int insertSelective(Invites record);

	List<Invites> selectByExample(InvitesExample example);

	Invites selectByPrimaryKey(Integer invitesId);

	int updateByExampleSelective(@Param("record") Invites record,
			@Param("example") InvitesExample example);

	int updateByExample(@Param("record") Invites record,
			@Param("example") InvitesExample example);

	int updateByPrimaryKeySelective(Invites record);

	int updateByPrimaryKey(Invites record);
}