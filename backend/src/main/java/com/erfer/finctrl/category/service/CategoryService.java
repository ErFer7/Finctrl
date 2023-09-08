package com.erfer.finctrl.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erfer.finctrl.category.mapper.CategoryMapper;
import com.erfer.finctrl.category.model.CategoryDto;
import com.erfer.finctrl.category.repository.CategoryRepository;
import com.erfer.model.Category;

@Service
public class CategoryService {

	@Autowired private CategoryRepository categoryRepository;

	public CategoryDto loadCategoryById(Long id) {
		Category category = this.categoryRepository.getReferenceById(id);
		return CategoryMapper.toDto(category);
	}

	public void saveCategory(CategoryDto categoryDto) {
		Category category = CategoryMapper.toEntity(categoryDto);
		this.categoryRepository.save(category);
	}
}
