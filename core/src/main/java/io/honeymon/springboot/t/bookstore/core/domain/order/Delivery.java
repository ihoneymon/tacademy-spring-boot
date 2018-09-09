package io.honeymon.springboot.t.bookstore.core.domain.order;

import java.time.LocalDate;
import java.util.List;

import io.honeymon.springboot.t.bookstore.core.domain.Address;

public class Delivery {
	private Address addr;
	private List<OrderItem> orderItems;
	private LocalDate started;
	private LocalDate finished;
}
