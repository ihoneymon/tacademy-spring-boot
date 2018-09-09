package io.honeymon.springboot.t.bookstore.core.domain.book;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.AbstractAuditable;

import io.honeymon.springboot.t.bookstore.core.domain.admin.Admin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Book extends AbstractAuditable<Admin, Long>{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
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
	
	
}
