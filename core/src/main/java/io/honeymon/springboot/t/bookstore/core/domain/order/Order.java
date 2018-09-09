package io.honeymon.springboot.t.bookstore.core.domain.order;

import java.time.LocalDate;
import java.util.List;

import io.honeymon.springboot.t.bookstore.core.domain.customer.Customer;

public class Order {
	private Customer customer;
	private List<OrderItem> orderItems;
	private LocalDate created;
	private LocalDate confirmed;
	private LocalDate paid;
}
