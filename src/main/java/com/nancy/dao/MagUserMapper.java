package com.nancy.dao;

import com.nancy.entity.example.MagUserExample;
import com.nancy.entity.model.MagUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagUserMapper {
    int countByExample(MagUserExample example);

    int deleteByExample(MagUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(MagUser record);

    int insertSelective(MagUser record);

    List<MagUser> selectByExample(MagUserExample example);

    MagUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MagUser record, @Param("example") MagUserExample example);

    int updateByExample(@Param("record") MagUser record, @Param("example") MagUserExample example);

    int updateByPrimaryKeySelective(MagUser record);

    int updateByPrimaryKey(MagUser record);

    List<MagUser> findUserByName(String name);
}
