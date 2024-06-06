package com.example.demo.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    public static void main(String[] args) {
        System.out.println(System.getProperty("os.arch").toLowerCase());
    }











}
