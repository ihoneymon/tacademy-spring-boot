package io.honeymon.springboot.t.bookstore.core.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
	@Column(length = 100)
	private String addr;
	@Column(length = 100)
	private String additionalAddr;
	@Column(length = 50)
	private String area;
	@Column(length = 50)
	private String province;
	@Column(length = 10)
	private String postCode;
}
