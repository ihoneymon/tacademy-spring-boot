package io.honeymon.springboot.t.bookstore.core.domain.book;

import io.honeymon.springboot.t.bookstore.core.domain.admin.Admin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Book extends AbstractAuditable<Admin, Long>{
	/**
	 * @see <a href="http://bit.ly/2CC85aK">ISBN: International Standard Book Number</a>
	 */
	@Column(length=20)
	private String isbn;
	
	private String name;
//	private Author author;
//	private Publisher publiser;
//	private List<Review> reviews;
//	private LocalDate published;


	public Book(String isbn, String name) {
		this.isbn = isbn;
		this.name = name;
	}
}
