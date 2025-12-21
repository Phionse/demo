package com.example.demo.server;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.pojo.ConfigInfo;
import com.example.demo.mapper.ConfigInfoMapper;
import com.example.demo.server.impl.ConfigInfoService;
@Service
public class ConfigInfoServiceImpl implements ConfigInfoService{

    @Autowired
    private ConfigInfoMapper configInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return configInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ConfigInfo record) {
        return configInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ConfigInfo record) {
        return configInfoMapper.insertSelective(record);
    }

    @Override
    @DS("slave_1")
    public ConfigInfo selectByPrimaryKey(Long id) {
        return configInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ConfigInfo record) {
        return configInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ConfigInfo record) {
        return configInfoMapper.updateByPrimaryKey(record);
    }

}
