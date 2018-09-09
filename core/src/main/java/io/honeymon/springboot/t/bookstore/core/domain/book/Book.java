package io.honeymon.springboot.t.bookstore.core.domain.book;

import java.time.LocalDate;
import java.util.List;

public class Book {
	private String isbn;
	private String name;
	private Author author;
	private Publisher publiser;
	private List<Review> reviews;
	private LocalDate published;
}
