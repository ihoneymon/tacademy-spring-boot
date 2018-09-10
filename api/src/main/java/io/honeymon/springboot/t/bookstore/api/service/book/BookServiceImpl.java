package io.honeymon.springboot.t.bookstore.api.service.book;

import java.util.List;
import java.util.Optional;

import io.honeymon.springboot.t.bookstore.api.common.OffSetPageRequest;
import org.springframework.stereotype.Service;

import io.honeymon.springboot.t.bookstore.core.domain.book.Book;
import io.honeymon.springboot.t.bookstore.core.domain.book.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private final BookRepository repository;

	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Book> findAll(OffSetPageRequest request) {
		return repository.findAll(request.getPageRequest()).getContent();
	}
}
