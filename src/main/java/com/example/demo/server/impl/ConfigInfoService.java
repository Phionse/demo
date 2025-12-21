package com.example.demo.server.impl;

import com.example.demo.pojo.ConfigInfo;
public interface ConfigInfoService{

    int deleteByPrimaryKey(Long id);

    int insert(ConfigInfo record);

    int insertSelective(ConfigInfo record);

    ConfigInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigInfo record);

    int updateByPrimaryKey(ConfigInfo record);

}
