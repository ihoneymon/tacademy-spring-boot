package io.honeymon.springboot.t.bookstore.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(BookController.class).alwaysDo(print()).build();
	}

	@Test
	public void testBookControllerOptions() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.options("/books").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.log())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
