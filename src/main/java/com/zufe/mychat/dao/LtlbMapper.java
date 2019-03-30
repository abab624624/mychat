package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Ltlb;
import com.zufe.mychat.bean.LtlbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LtlbMapper {
	long countByExample(LtlbExample example);

	int deleteByExample(LtlbExample example);

	int deleteByPrimaryKey(Integer ltlbId);

	int insert(Ltlb record);

	int insertSelective(Ltlb record);

	List<Ltlb> selectByExample(LtlbExample example);

	Ltlb selectByPrimaryKey(Integer ltlbId);

	int updateByExampleSelective(@Param("record") Ltlb record,
			@Param("example") LtlbExample example);

	int updateByExample(@Param("record") Ltlb record,
			@Param("example") LtlbExample example);

	int updateByPrimaryKeySelective(Ltlb record);

	int updateByPrimaryKey(Ltlb record);
	
	List<Ltlb> selectContentOrderByTime(String username,String touser);
}