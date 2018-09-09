package io.honeymon.springboot.t.bookstore.core.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractAuditable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends AbstractAuditable<Admin, Long> {
	@Column(length=100, nullable=false)
	private String email;
	@Column(length=100, nullable=false)
	private String password;
}
