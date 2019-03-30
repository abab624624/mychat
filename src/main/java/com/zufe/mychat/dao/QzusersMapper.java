package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Qzusers;
import com.zufe.mychat.bean.QzusersExample;
import com.zufe.mychat.bean.QzusersKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QzusersMapper {
	long countByExample(QzusersExample example);

	int deleteByExample(QzusersExample example);

	int deleteByPrimaryKey(QzusersKey key);

	int insert(Qzusers record);

	int insertSelective(Qzusers record);

	List<Qzusers> selectByExample(QzusersExample example);

	Qzusers selectByPrimaryKey(QzusersKey key);

	int updateByExampleSelective(@Param("record") Qzusers record,
			@Param("example") QzusersExample example);

	int updateByExample(@Param("record") Qzusers record,
			@Param("example") QzusersExample example);

	int updateByPrimaryKeySelective(Qzusers record);

	int updateByPrimaryKey(Qzusers record);
}