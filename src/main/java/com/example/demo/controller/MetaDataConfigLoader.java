package com.example.demo.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MetaDataConfigLoader implements ApplicationRunner {
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("从数据库加载数据成功");
    }
}
