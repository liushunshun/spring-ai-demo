# Spring AI Demo

基于 Spring AI + 通义千问（DashScope）的 LLM 学习项目，8 周系统学习计划的实践仓库。

## 学习目标

8 周冲刺，目标中大厂 AI 方向 Offer，核心技能矩阵：

| 方向 | 内容 |
|------|------|
| LLM 基础 | Prompt Engineering、RAG 原理、Function Calling、向量数据库 |
| Agent 框架 | LangChain4j、Spring AI、Tool Use、Multi-Agent |
| 工程落地 | 流式输出 SSE、MCP 协议、Token 成本控制、可观测性 |
| 存储与检索 | Milvus/Weaviate、Embedding 模型、混合检索 |
| Java 提升 | Spring Boot 3.x、WebFlux 响应式、虚拟线程、GraalVM |

## 技术栈

- **Java 18** + **Spring Boot 4.0.6**
- **Spring AI 2.0.0-M8**
- **通义千问 qwen-plus**（DashScope OpenAI 兼容模式）
- Lombok

## 项目结构

```
src/main/java/com/xy/spring_ai_demo/
├── config/
│   └── ChatConfig.java          # ChatClient Bean 配置
├── controller/
│   └── StreamChatController.java # SSE 流式对话接口
└── tools/
    └── WeatherTool.java          # Function Calling 示例：天气查询

src/main/resources/static/
└── sse-chat-test.html            # 前端测试页面
```

## 快速启动

**1. 配置 API Key**

复制示例配置文件并填入你的 API Key：

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

编辑 `application.properties`：

```properties
spring.ai.openai.api-key=YOUR_DASHSCOPE_API_KEY
spring.ai.openai.base-url=https://dashscope.aliyuncs.com/compatible-mode/v1
spring.ai.openai.chat.options.model=qwen-plus
```

> DashScope API Key 申请：https://dashscope.aliyun.com

**2. 启动**

```bash
./mvnw spring-boot:run
```

**3. 测试**

浏览器访问 http://localhost:8080/sse-chat-test.html，在页面中发送消息即可。

## 已实现功能

- [x] SSE 流式对话（`/chat/stream`）
- [x] Function Calling —— 天气查询工具（`WeatherTool`）
- [x] 前端 SSE 测试页面

## 接口说明

### 流式对话

```
GET /chat/stream?msg={消息内容}
Content-Type: text/event-stream
```

示例：
```bash
curl "http://localhost:8080/chat/stream?msg=今天北京天气怎么样"
```

## 8 周学习计划

### 第一阶段（Week 1-3）：LLM & Agent 基础夯实

- **Week 1**：LLM 核心概念，Prompt Engineering 5 种范式，OpenAI Function Calling 机制
- **Week 2**：RAG 核心链路，Embedding 原理，Milvus/Qdrant 向量检索，Rerank 策略
- **Week 3**：Agent 框架入门（LangChain4j vs Spring AI），ReAct Agent，SSE 流式输出

### 第二阶段（Week 4-6）：工程化实战 & 项目沉淀

- **Week 4**：生产级 RAG 优化，HyDE、Self-RAG，Agentic RAG，Guardrails
- **Week 5**：Multi-Agent 架构（Orchestrator + Specialist），MCP 协议，长时记忆方案
- **Week 6**：可观测性（LangFuse/Phoenix），Token 用量监控，Prompt 版本管理

### 第三阶段（Week 7-8）：面试冲刺 & 投递

- **Week 7**：AI 系统设计，Java 高频面题，整理《AI Agent 面试手册》50 题
- **Week 8**：广投简历，JD 分析补强，持续更新项目

## 参考资料

- [Spring AI 官方文档](https://docs.spring.io/spring-ai/reference/)
- [DashScope OpenAI 兼容模式文档](https://help.aliyun.com/zh/dashscope/developer-reference/compatibility-of-openai-with-dashscope)
