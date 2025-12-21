package com.example.demo.mapper;

import com.example.demo.pojo.Options;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}