package com.xy.spring_ai_demo.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder.defaultSystem("你是一个专业助手")
                .defaultOptions(OpenAiChatOptions.builder()
                        .temperature(0.7))
                .build();
    }
}
