package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Qzltlb;
import com.zufe.mychat.bean.QzltlbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QzltlbMapper {
    long countByExample(QzltlbExample example);

    int deleteByExample(QzltlbExample example);

    int deleteByPrimaryKey(Integer qzltlbId);

    int insert(Qzltlb record);

    int insertSelective(Qzltlb record);

    List<Qzltlb> selectByExample(QzltlbExample example);

    Qzltlb selectByPrimaryKey(Integer qzltlbId);

    int updateByExampleSelective(@Param("record") Qzltlb record, @Param("example") QzltlbExample example);

    int updateByExample(@Param("record") Qzltlb record, @Param("example") QzltlbExample example);

    int updateByPrimaryKeySelective(Qzltlb record);

    int updateByPrimaryKey(Qzltlb record);
    
    List<Qzltlb> selectQzContentOrderByTime(String qzid);
}