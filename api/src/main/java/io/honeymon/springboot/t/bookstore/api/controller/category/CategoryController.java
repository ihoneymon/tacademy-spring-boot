package io.honeymon.springboot.t.bookstore.api.controller.category;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.honeymon.springboot.t.bookstore.api.common.OffSetPageRequest;
import io.honeymon.springboot.t.bookstore.api.service.category.CategoryService;
import io.honeymon.springboot.t.bookstore.core.common.api.ApiResponse;
import io.honeymon.springboot.t.bookstore.core.domain.category.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	private final CategoryService service;

	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	 /**
     * API 지원메서드유형 반환
     *
     * @return HttpMethod types
     */
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<List<RequestMethod>> options() {
        return ResponseEntity.ok().allow(HttpMethod.OPTIONS, HttpMethod.HEAD, HttpMethod.GET).build();
    }
    
    @GetMapping
    public ApiResponse<List<Category>> getAll(@RequestParam OffSetPageRequest request) {
        List<Category> books = service.findAll(request);
        return ApiResponse.ok(books);
    }
}
