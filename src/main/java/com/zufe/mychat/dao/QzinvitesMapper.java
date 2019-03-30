package com.zufe.mychat.dao;

import com.zufe.mychat.bean.Qzinvites;
import com.zufe.mychat.bean.QzinvitesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QzinvitesMapper {
    long countByExample(QzinvitesExample example);

    int deleteByExample(QzinvitesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qzinvites record);

    int insertSelective(Qzinvites record);

    List<Qzinvites> selectByExample(QzinvitesExample example);

    Qzinvites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qzinvites record, @Param("example") QzinvitesExample example);

    int updateByExample(@Param("record") Qzinvites record, @Param("example") QzinvitesExample example);

    int updateByPrimaryKeySelective(Qzinvites record);

    int updateByPrimaryKey(Qzinvites record);
    
    List<Qzinvites> selectQzusersByCreater(String username);
}