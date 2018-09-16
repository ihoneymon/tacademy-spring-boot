package io.honeymon.springboot.t.bookstore.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.honeymon.springboot.t.bookstore.core.domain.book.Book;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class ObjectMapperTest {

    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Book book = new Book("test-book", "test-isbn13", "test-isbn10");
        String strBook = objectMapper.writeValueAsString(book);
        System.out.println(strBook);
    }
}
