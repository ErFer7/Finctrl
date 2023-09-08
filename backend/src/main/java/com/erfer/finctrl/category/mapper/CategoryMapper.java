package com.erfer.finctrl.category.mapper;

import com.erfer.finctrl.category.model.CategoryDto;
import com.erfer.model.Category;

public class CategoryMapper {

	public static CategoryDto toDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.name(category.getName())
				.build();
	}

	public static Category toEntity(CategoryDto categoryDto) {
		return Category.builder()
				.id(categoryDto.getId())
				.name(categoryDto.getName())
				.build();
	}
}
