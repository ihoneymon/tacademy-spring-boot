package io.honeymon.springboot.t.bookstore.api.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.honeymon.springboot.t.bookstore.core.domain.book.Book;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ObjectMapperTest2 {

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void test() throws JsonProcessingException {
		Book book = new Book("test-book", "test-isbn13", "test-isbn10");
        String strBook = objectMapper.writeValueAsString(book);
        System.out.println(strBook);
	}

}
