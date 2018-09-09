package io.honeymon.springboot.t.bookstore.core.domain.customer;

import java.time.LocalDate;

import io.honeymon.springboot.t.bookstore.core.domain.Address;

public class CusomterAddressHistory {
	private Customer customer;
	private Address address;	
	private LocalDate created;
}
