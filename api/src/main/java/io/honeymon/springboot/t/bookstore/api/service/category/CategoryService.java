package io.honeymon.springboot.t.bookstore.api.service.category;

import java.util.List;
import java.util.Optional;

import io.honeymon.springboot.t.bookstore.api.common.OffSetPageRequest;
import io.honeymon.springboot.t.bookstore.core.domain.category.Category;

public interface CategoryService {

	Optional<Category> findById(Long id);
	
	List<Category> findAll(OffSetPageRequest pageRequest);
}
