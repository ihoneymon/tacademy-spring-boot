package io.honeymon.springboot.t.bookstore.api.service.category;

import io.honeymon.springboot.t.bookstore.api.common.OffSetPageRequest;
import io.honeymon.springboot.t.bookstore.core.domain.category.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll(OffSetPageRequest pageRequest) {
        return null;
    }
}
