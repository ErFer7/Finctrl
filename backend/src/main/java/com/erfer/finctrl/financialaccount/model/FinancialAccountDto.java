package com.erfer.finctrl.financialaccount.model;

import lombok.Builder;
import lombok.Data;

import com.erfer.model.Bank;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
public class FinancialAccountDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long Id;

	private String name;
	private Long value;  // Valor em centavos
	private Bank bankId;
}
