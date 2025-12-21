package com.example.demo.server;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.mapper.OptionsMapper;
import com.example.demo.pojo.Options;
import com.example.demo.server.impl.OptionsService;
@Service
public class OptionsServiceImpl implements OptionsService{

    @Autowired
    private OptionsMapper optionsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return optionsMapper.deleteByPrimaryKey(id);
    }

    @Override

    public int insert(Options record) {
        return optionsMapper.insert(record);
    }

    @Override
    public int insertSelective(Options record) {
        return optionsMapper.insertSelective(record);
    }

    @Override
    @DS("master")
    public Options selectByPrimaryKey(Integer id) {
        return optionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Options record) {
        return optionsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Options record) {
        return optionsMapper.updateByPrimaryKey(record);
    }

}
