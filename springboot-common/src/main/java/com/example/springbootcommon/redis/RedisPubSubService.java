package com.example.springbootcommon.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息发布订阅服务
 * @author wutong
 * @date 2023/12/14
 */
@Service
public class RedisPubSubService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisMessageListenerContainer redisMessageListenerContainer;

    private final Map<String, MessageListenerAdapter> listeners = new HashMap<>();

    /**
     * 发布消息
     */
    public void publish(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }

    /**
     * 订阅频道
     */
    public void subscribe(String channel, MessageListenerAdapter listenerAdapter) {
        redisMessageListenerContainer.addMessageListener(listenerAdapter, new ChannelTopic(channel));
        listeners.put(channel, listenerAdapter);
    }

    /**
     * 取消订阅
     */
    public void unsubscribe(String channel) {
        MessageListenerAdapter listenerAdapter = listeners.get(channel);
        if (listenerAdapter != null) {
            redisMessageListenerContainer.removeMessageListener(listenerAdapter);
            listeners.remove(channel);
        }
    }

    /**
     * 创建消息监听适配器
     */
    public MessageListenerAdapter createListenerAdapter(Object delegate, String methodName) {
        return new MessageListenerAdapter(delegate, methodName);
    }
}