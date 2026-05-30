package com.xy.spring_ai_demo;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringAiDemoApplicationTests {

	@Resource
	private ChatClient chatClient;

	@Test
	void contextLoads() {
	}

	@Test
	void zeroShotTest() {
		// 零样本：不提供任何示例，直接向模型提问
		String question = """
				判断以下评论的情感倾向，输出：正面 / 负面 / 中性
				
				评论：这款手机拍照效果一般，但续航还不错。
				""";

		String response = chatClient.prompt()
				.user(question)
				.call()
				.content();

		System.out.println("问题: " + question);
		System.out.println("回答: " + response);

		assertThat(response).isNotBlank();
	}

	@Test
	void fewShotTest() {
		String question = """
				判断评论的情感倾向，输出：正面 / 负面 / 中性
				
				评论：屏幕清晰度超出预期，非常满意！
				情感：正面
			
				评论：快递慢不说，包装还破损了。
				情感：负面
			
				评论：价格适中，质量一般。
				情感：中性
			
				评论：这款手机拍照效果一般，但续航还不错。
				情感：
				""";
		String response = chatClient.prompt()
				.user(question)
				.call()
				.content();

		System.out.println("答案：" + response);
	}

	@Test
	void chainOfThought(){
		String question = """
				一个班有35个人，3/5是女生，女生中1/4参加了合唱团。参加合唱团的女生有多少人？
				
				请一步一步思考，然后给出最终答案
				""";
		String response = chatClient.prompt()
				.user(question)
				.call()
				.content();
		System.out.println("答案：" + response);
	}

	@Test
	void structuredCot() {
		String question = """
				解答数学应用题，先逐步推理，再给出最终答案。
				
				问题：停车场有 50 辆车，1/5 是红色，红色车中一半是轿车。红色轿车有多少辆？
				推理：
				步骤1：红色车数量 = 50 × 1/5 = 10 辆
				步骤2：红色轿车 = 10 × 1/2 = 5 辆
				答案：5 辆
			
				问题：一个班有 35 人，其中 3/5 是女生，女生中有 1/4 参加了合唱团。参加合唱团的女生有多少人？
				推理：
				""";
		String response = chatClient.prompt()
				.user(question)
				.call()
				.content();
		System.out.println("答案：" + response);
	}

	@Test
	void structuredCot2() {
		String question = """
				问题：一个班有 35 人，其中 3/5 是女生，女生中有 1/4 参加了合唱团。参加合唱团的女生有多少人？
				
				请按以下格式回答：
				【分析过程】
				（逐步推理）
				【最终结论】
				（一句话结论）
				""";
		String response = chatClient.prompt()
				.user(question)
				.call()
				.content();
				System.out.println("答案：" + response);

	}

	@Test
	void zeroShotTest2() {
		String question = """
				一个班有35个人，3/5是女生，女生中1/4参加了合唱团。参加合唱团的女生有多少人？
				""";
		String response = chatClient.prompt()
				.user(question)
				.call()
				.content();
		System.out.println("答案：" + response);
	}

	@Test
	void systemPrompt() {
		String systemPrompt = """
				[角色]
					 你是一个讲笑话的艺人
				[任务]
					你得任务是讲笑话，逗观众开心
				[约束]
					不得讲笑话意外的事情
				[输出格式]
					笑话：
					笑点：
				""";
		String question = """
				讲个笑话
				""";
		String response = chatClient.prompt(systemPrompt).user(question).call().content();
		System.out.println(response);
	}



}
