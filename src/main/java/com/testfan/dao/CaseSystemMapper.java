package com.testfan.dao;

import com.testfan.model.CaseSystem;
import com.testfan.model.CaseSystemCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CaseSystemMapper {
    long countByExample(CaseSystemCriteria example);

    int deleteByExample(CaseSystemCriteria example);

    int deleteByPrimaryKey(String systemid);

    int insert(CaseSystem record);

    int insertSelective(CaseSystem record);

    List<CaseSystem> selectByExample(CaseSystemCriteria example);

    CaseSystem selectByPrimaryKey(String systemid);

    int updateByExampleSelective(@Param("record") CaseSystem record, @Param("example") CaseSystemCriteria example);

    int updateByExample(@Param("record") CaseSystem record, @Param("example") CaseSystemCriteria example);

    int updateByPrimaryKeySelective(CaseSystem record);

    int updateByPrimaryKey(CaseSystem record);
}