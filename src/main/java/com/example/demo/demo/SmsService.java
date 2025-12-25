package com.example.demo.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;  
  
public class SmsService {  
    public void sendSms(String message, String phoneNumber) {  
        // 假设这是发送短信的实际逻辑  
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + message);  
        // 模拟耗时操作  
        try {  
            Thread.sleep(2000); // 假设发送短信需要2秒  
        } catch (InterruptedException e) {  
            Thread.currentThread().interrupt();  
        }  
    }  
}  
  
