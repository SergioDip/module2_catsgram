package test.java.ru.yandex.practicum.catsgram;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.yandex.practicum.catsgram.controller.PostController;

@SpringBootTest
class CatsgramApplicationTests {

	@Test
	void contextLoads() {
	}

	@WebMvcTest(PostController.class)
	@AutoConfigureMockMvc
	class PostControllerTest {
		@Autowired
		MockMvc mockMvc;

		@Test
		void testFindAll() throws Exception {
			mockMvc.perform(get("/posts"))
				   .andExpect(status().isOk())
				   .andExpect(content().json("[]"));

		}
	}

}
