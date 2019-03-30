package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Qzcount;
import com.zufe.mychat.bean.QzcountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QzcountMapper {
	long countByExample(QzcountExample example);

	int deleteByExample(QzcountExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Qzcount record);

	int insertSelective(Qzcount record);

	List<Qzcount> selectByExample(QzcountExample example);

	Qzcount selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Qzcount record,
			@Param("example") QzcountExample example);

	int updateByExample(@Param("record") Qzcount record,
			@Param("example") QzcountExample example);

	int updateByPrimaryKeySelective(Qzcount record);

	int updateByPrimaryKey(Qzcount record);
}