package com.xy.spring_ai_demo;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.EncodingType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
public class SpringAiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiDemoApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner runner(ChatClient.Builder builder) {
		return args -> {
			EncodingRegistry registry = Encodings.newLazyEncodingRegistry();
			// cl100k_base is used by gpt-4, gpt-3.5-turbo, text-embedding-ada-002
			Encoding encoding = registry.getEncoding(EncodingType.CL100K_BASE);

			String prompt = "Tell me a joke";
			int promptTokens = encoding.countTokens(prompt);

//			builder.defaultOptions(OpenAiChatOptions.builder().temperature(0.7))
			ChatClient chatClient = builder.build();
			var chatResponse = Objects.requireNonNull(chatClient.prompt(prompt).call().chatResponse());
			String response = chatResponse.getResult().getOutput().getText();

			System.out.println("Response usage : " + chatResponse.getMetadata().getUsage());

			int responseTokens = encoding.countTokens(response);

			System.out.println(response);
			System.out.println("---");
			System.out.printf("Prompt tokens : %d%n", promptTokens);
			System.out.printf("Response tokens: %d%n", responseTokens);
			System.out.printf("Total tokens   : %d%n", promptTokens + responseTokens);
		};
	}*/
}
