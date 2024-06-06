package com.example.demo.controller;

//# 业务空间模型调用请参考文档传入workspace信息: https://help.aliyun.com/document_detail/2746874.html
// Copyright (c) Alibaba, Inc. and its affiliates.
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Semaphore;
import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.ResultCallback;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import io.reactivex.Flowable;


public class Main {
  public static void streamCallWithMessage()
      throws NoApiKeyException, ApiException, InputRequiredException {
    Constants.apiKey="sk-2bffb610672e4c07be25d4d4490e51f8";
    Generation gen = new Generation();
    Message userMsg = Message.builder().role(Role.USER.getValue()).content("用萝卜、土豆、茄子做饭，给我个菜谱").build();
    QwenParam param =
        QwenParam.builder().model("qwen-7b-chat")
            .messages(Collections.singletonList(userMsg))
            .resultFormat(QwenParam.ResultFormat.MESSAGE)
            .topP(0.8)
            .incrementalOutput(true) // get streaming output incrementally
            .build();
    Flowable<GenerationResult> result = gen.streamCall(param);
    StringBuilder fullContent = new StringBuilder();
    result.blockingForEach(item->{
      fullContent.append(item.getOutput().getChoices().get(0).getMessage().getContent());
      System.out.println(item);
    });
    System.out.println("Full content: \n" + fullContent);
  }

  public static void streamCallWithMessageCallback()
      throws NoApiKeyException, ApiException, InputRequiredException, InterruptedException {
    Generation gen = new Generation();
    Message userMsg = Message.builder().role(Role.USER.getValue()).content("用萝卜、土豆、茄子做饭，给我个菜谱").build();
    QwenParam param =
        QwenParam.builder().model("qwen1.5-14b-chat")
            .messages(Collections.singletonList(userMsg))
            .resultFormat(QwenParam.ResultFormat.MESSAGE)
            .topP(0.8)
            .incrementalOutput(true) // get streaming output incrementally
            .build();
    Semaphore semaphore = new Semaphore(0);
    StringBuilder fullContent = new StringBuilder();
    gen.streamCall(param, new ResultCallback<GenerationResult>() {

      @Override
      public void onEvent(GenerationResult message) {
        fullContent.append(message.getOutput().getChoices().get(0).getMessage().getContent());
        System.out.println(message);
      }
      @Override
      public void onError(Exception ex){
        System.out.println(ex.getMessage());
        semaphore.release();
      }
      @Override
      public void onComplete(){
        System.out.println("onComplete");
        semaphore.release();
      }
      
    });
    semaphore.acquire();
    System.out.println("Full content: \n" + fullContent);
  }

  public static void main(String[] args){
        try {
          streamCallWithMessage();
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
          System.out.println(e.getMessage());
        }
        try {
          streamCallWithMessageCallback();
        } catch (ApiException | NoApiKeyException | InputRequiredException | InterruptedException e) {
          System.out.println(e.getMessage());
        }
        System.exit(0);
  }
}
