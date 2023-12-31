package com.erfer.finctrl.bank.model;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
public class BankDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	private String name;
}
