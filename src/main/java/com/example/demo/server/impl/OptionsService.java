package com.example.demo.server.impl;

import com.example.demo.pojo.Options;
public interface OptionsService{

    int deleteByPrimaryKey(Integer id);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);

}
