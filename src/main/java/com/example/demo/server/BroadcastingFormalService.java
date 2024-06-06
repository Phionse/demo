package com.example.demo.server;

import com.example.demo.pojo.BroadcastingFormal;
import com.example.demo.util.PagePro;
import com.example.demo.util.ResultView;

public interface BroadcastingFormalService{

    int deleteByPrimaryKey(Long id);

    int insert(BroadcastingFormal record);

    int insertSelective(BroadcastingFormal record);

    BroadcastingFormal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BroadcastingFormal record);

    int updateByPrimaryKey(BroadcastingFormal record);


    ResultView process(PagePro pagePro);






}
