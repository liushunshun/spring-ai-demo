package com.xy.spring_ai_demo.controller;

import com.xy.spring_ai_demo.tools.WeatherTool;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StreamChatController {

    @Resource
    private ChatClient chatClient;

    @Resource
    private WeatherTool weatherTool;
    @GetMapping(value = "/chat/stream" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> stream(@RequestParam String msg) {

            return chatClient.prompt().user(msg).tools(weatherTool).stream().content()
                    .doOnNext(chunk -> System.out.println("chunk: " + chunk));

    }
}
