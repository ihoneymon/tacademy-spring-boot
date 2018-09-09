package io.honeymon.springboot.t.bookstore.core.domain.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author honeymon
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Query Creation</a>
 */
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByNameLike(String name);
	
}
