package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.BroadcastingFormal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BroadcastingFormalMapper extends BaseMapper<BroadcastingFormal> {
    int deleteByPrimaryKey(Long id);

    int insert(BroadcastingFormal record);

    int insertSelective(BroadcastingFormal record);

    BroadcastingFormal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BroadcastingFormal record);

    int updateByPrimaryKey(BroadcastingFormal record);
}