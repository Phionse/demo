package com.example.demo.controller;

import com.example.demo.server.BroadcastingFormalService;
import com.example.demo.util.PagePro;
import com.example.demo.util.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.ma.com
 * @explain
 * @date 2021/7/2 11:17
 */
@Slf4j
@RestController
@RequestMapping("/Public")
public class PublicController {


    @Autowired
    public BroadcastingFormalService broadcastingFormalService;


    @PostMapping("/getMenus")
    public ResultView getMenus(int num,int size){
        PagePro pagePro = new PagePro();
        pagePro.setPageNum(num);
        pagePro.setPageSize(size);
        return ResultView.success(broadcastingFormalService.process(pagePro));
    }

}
