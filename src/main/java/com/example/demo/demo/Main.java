package com.example.demo.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {  
    public static void main(String[] args) throws ExecutionException, InterruptedException {  
        SmsService smsService = new SmsService();  
        // 主线程逻辑  
        System.out.println("Starting main thread logic..."); 
  
        // 使用CompletableFuture异步发送短信  
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {  
            smsService.sendSms("Hello", "1234567890");
        });
        // 主线程继续执行其他逻辑，不会被阻塞  
        System.out.println("Main thread is doing other tasks...");  

        // 如果需要等待异步任务完成，可以调用future.get()，但这会阻塞直到任务完成  
        // 通常不推荐在主线程中直接调用get()，除非你确定这样做不会造成问题  
        // future.get(); // 这会阻塞，直到sendSms方法执行完毕  
    }
}
