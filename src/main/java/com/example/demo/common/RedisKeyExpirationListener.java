package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * Redis事件监听器
 */
@Slf4j
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {


    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 重写omMessage方法，当Redis中的Key过期时会执行该方法
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 过期的key
        String expireKey = message.toString();
        log.info("key:{}过期了", expireKey);
        if (expireKey.equals("")){

        }

        // 根据key,执行自己需要实现的功能。
    }
}

