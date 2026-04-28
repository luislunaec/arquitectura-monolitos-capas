package com.uce.arquitectura.proyecto_spaghetti;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ProyectoSpaghettiApplicationTests {

	@MockBean
	ChatLanguageModel chatLanguageModel;

	@Test
	void contextLoads() {
	}
}