package io.honeymon.springboot.t.bookstore.api.service.book;

import java.util.List;
import java.util.Optional;

import io.honeymon.springboot.t.bookstore.api.common.OffSetPageRequest;
import io.honeymon.springboot.t.bookstore.core.domain.book.Book;

public interface BookService {

	Optional<Book> findById(Long id);

    List<Book> findAll(OffSetPageRequest request);
}
