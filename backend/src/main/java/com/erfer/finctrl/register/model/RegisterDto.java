package com.erfer.finctrl.register.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

import com.erfer.model.Category;
import com.erfer.model.FinancialAccount;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
public class RegisterDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long Id;

	private Date date;
	private String name;
	private FinancialAccount financialAccountId;
	private Category categoryId;
	private Long value;  // Valor em centavos
}
