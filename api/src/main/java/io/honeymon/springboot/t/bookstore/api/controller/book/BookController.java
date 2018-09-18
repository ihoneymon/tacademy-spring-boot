package io.honeymon.springboot.t.bookstore.api.controller.book;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.honeymon.springboot.t.bookstore.api.common.OffSetPageRequest;
import io.honeymon.springboot.t.bookstore.api.service.book.BookService;
import io.honeymon.springboot.t.bookstore.core.common.api.ApiResponse;
import io.honeymon.springboot.t.bookstore.core.common.exceptions.BookNotFoundException;
import io.honeymon.springboot.t.bookstore.core.domain.book.Book;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    /**
     * API 지원메서드유형 반환
     *
     * @return HttpMethod types
     */
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<List<RequestMethod>> options() {
        return ResponseEntity.ok().allow(HttpMethod.OPTIONS, HttpMethod.HEAD, HttpMethod.GET).build();
    }

    @GetMapping
    public ApiResponse<List<Book>> getAll(@RequestParam OffSetPageRequest request) {
        List<Book> books = service.findAll(request);
        return ApiResponse.ok(books);
    }

    /**
     * GET 호출을 하기에 앞서 동작하는 헤더인지 확인하려는 목적으로 사용
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<?> head(@PathVariable Long id) {
        return service.findById(id).map(exists -> ResponseEntity.noContent().build())
                .orElseThrow(() -> new BookNotFoundException(String.format("Book(%d) not found.", id)));
    }

    @GetMapping("/{id}")
    public ApiResponse<Book> get(@PathVariable Long id) {
        return this.service.findById(id).map(ApiResponse::ok)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book(%d) not found.", id)));
    }

}
