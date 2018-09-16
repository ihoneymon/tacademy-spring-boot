package io.honeymon.springboot.t.bookstore.core.domain.book;

import io.honeymon.springboot.t.bookstore.core.domain.admin.Admin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Getter
@Setter
@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Book extends AbstractAuditable<Admin, Long>{
	/**
	 * @see <a href="http://bit.ly/2CC85aK">ISBN: International Standard Book Number</a>
	 */
	@Column(length=13)
	private String isbn13;
	@Column(length=10)
	private String isbn10;
	
	private String name;
//	private Author author;
//	private Publisher publisher;
//	private List<Review> reviews;
//	private LocalDate published;


	public Book(String name, String isbn13, String isbn10) {
		this.name = name;
		this.isbn13 = isbn13;
		this.isbn10 = isbn10;
	}
}
