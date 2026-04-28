package com.uce.arquitectura.proyecto_lasagna;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoLasagnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoLasagnaApplication.class, args);
	}

	@Bean
	public ChatLanguageModel chatLanguageModel(@Value("${langchain4j.google-ai-gemini.api-key}") String apiKey) {
		return GoogleAiGeminiChatModel.builder()
				.apiKey(apiKey)
				.modelName("gemini-2.5-flash")
				.build();
	}
}