package io.honeymon.springboot.t.bookstore.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.honeymon.springboot.t.bookstore.api.service.book.BookService;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/books")
@NoArgsConstructor
public class BookController {

	private BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.OPTIONS)
	public ResponseEntity<List<RequestMethod>> options() {
		return ResponseEntity.ok(Arrays.asList(RequestMethod.GET));
	}
}
