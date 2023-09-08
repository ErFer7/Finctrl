package com.erfer.finctrl.category.model;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
public class CategoryDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	private String name;
}
