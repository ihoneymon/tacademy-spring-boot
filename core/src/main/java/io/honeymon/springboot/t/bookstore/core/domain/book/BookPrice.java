package io.honeymon.springboot.t.bookstore.core.domain.book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookPrice {
	private Long id;
	private Book book;
	private BigDecimal amount;
}
