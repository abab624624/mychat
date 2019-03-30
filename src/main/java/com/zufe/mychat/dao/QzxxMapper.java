package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Qzxx;
import com.zufe.mychat.bean.QzxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QzxxMapper {
	long countByExample(QzxxExample example);

	int deleteByExample(QzxxExample example);

	int deleteByPrimaryKey(String qzid);

	int insert(Qzxx record);

	int insertSelective(Qzxx record);

	List<Qzxx> selectByExample(QzxxExample example);

	Qzxx selectByPrimaryKey(String qzid);

	int updateByExampleSelective(@Param("record") Qzxx record,
			@Param("example") QzxxExample example);

	int updateByExample(@Param("record") Qzxx record,
			@Param("example") QzxxExample example);

	int updateByPrimaryKeySelective(Qzxx record);

	int updateByPrimaryKey(Qzxx record);

	List<Qzxx> selectQzxxWithStatus(String qzid,String qzcreater);
	
	List<Qzxx> selectQzxxWithCn(String username);
}