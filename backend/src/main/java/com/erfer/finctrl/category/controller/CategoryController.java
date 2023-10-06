package com.erfer.finctrl.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erfer.finctrl.category.mapper.CategoryMapper;
import com.erfer.finctrl.category.model.CategoryDto;
import com.erfer.finctrl.category.service.CategoryService;
import com.erfer.model.Category;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*")
public class CategoryController {

	@Autowired private CategoryService categoryService;

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> loadCategory(Long categoryId) {
		CategoryDto categoryDto = this.categoryService.loadCategory(categoryId);
		return ResponseEntity.ok(categoryDto);
	}

	@PostMapping("/save")
	public void saveCategory(@RequestBody Category category) {
		CategoryDto categoryDto = CategoryMapper.toDto(category);
		this.categoryService.saveCategory(categoryDto);
	}

}
