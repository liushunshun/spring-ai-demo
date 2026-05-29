package com.xy.spring_ai_demo.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WeatherTool {


    @Tool(description = "查询指定城市的实时天气信息")
    public String getWeather(String city){
        log.info("getWeather 入参: city={}", city);
        String result = String.format("{\"city\":\"%s\",\"temp\":\"25°C\",\"desc\":\"晴\"}", city);
        log.info("getWeather 返回: {}", result);
        return result;
    }
}
