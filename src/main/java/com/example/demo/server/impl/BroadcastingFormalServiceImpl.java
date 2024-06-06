package com.example.demo.server.impl;

import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.IntensityAttenuationDto;
import com.example.demo.server.BroadcastingFormalService;
import com.example.demo.util.AlgorithmUntil;
import com.example.demo.util.PagePro;
import com.example.demo.util.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.mapper.BroadcastingFormalMapper;
import com.example.demo.pojo.BroadcastingFormal;

import java.util.List;

@Service
@Slf4j
public class BroadcastingFormalServiceImpl implements BroadcastingFormalService {

    @Autowired
    private BroadcastingFormalMapper broadcastingFormalMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return broadcastingFormalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BroadcastingFormal record) {
        return broadcastingFormalMapper.insert(record);
    }

    @Override
    public int insertSelective(BroadcastingFormal record) {
        return broadcastingFormalMapper.insertSelective(record);
    }

    @Override
    public BroadcastingFormal selectByPrimaryKey(Long id) {
        return broadcastingFormalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BroadcastingFormal record) {
        return broadcastingFormalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BroadcastingFormal record) {
        return broadcastingFormalMapper.updateByPrimaryKey(record);
    }

    @Override
    public ResultView process(PagePro pagePro) {
         int i = 0;
        Page<BroadcastingFormal> page = new Page<>(pagePro.getPageNum(),pagePro.getPageSize());
        QueryWrapper<BroadcastingFormal> queryWrapper = new QueryWrapper<>();
        Page<BroadcastingFormal> activityDataList = broadcastingFormalMapper.selectPage(page,queryWrapper);
        if (activityDataList.getRecords().isEmpty()) return ResultView.error();
        for (BroadcastingFormal bwgTable : activityDataList.getRecords()) {
            IntensityAttenuationDto intensityAttenuationDto = AlgorithmUntil.getIntensityAttenuationDto(Double.parseDouble(bwgTable.getLon()),Double.parseDouble(bwgTable.getLat()),2);
            if (intensityAttenuationDto.getIntensity()==null) continue;
            bwgTable.setIntensity(intensityAttenuationDto.getIntensity().toString());
            bwgTable.setM(intensityAttenuationDto.getM().toString());
            bwgTable.setDa(intensityAttenuationDto.getDa().toString());
            bwgTable.setDb(intensityAttenuationDto.getDb().toString());
            bwgTable.setDistance(intensityAttenuationDto.getDistance());
            updateByPrimaryKeySelective(bwgTable);
            log.info("Updated activity");
            log.info(bwgTable.toString());
            i++;
        }
        if (activityDataList.getRecords().isEmpty()) return ResultView.success("暂无数据");
        log.info("已完成"+"数据"+i);
        return ResultView.success(activityDataList);

    }

}
