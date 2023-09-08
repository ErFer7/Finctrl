package com.erfer.finctrl.financialaccount.mapper;

import com.erfer.finctrl.financialaccount.model.FinancialAccountDto;
import com.erfer.model.FinancialAccount;

public class FinancialAccountMapper {

	public static FinancialAccountDto toDto(FinancialAccount financialAccount) {
		return FinancialAccountDto.builder()
				.Id(financialAccount.getId())
				.name(financialAccount.getName())
				.value(financialAccount.getValue())
				.bankId(financialAccount.getBankId())
				.build();
	}

	public static FinancialAccount toEntity(FinancialAccountDto financialAccountDto) {
		return FinancialAccount.builder()
				.id(financialAccountDto.getId())
				.name(financialAccountDto.getName())
				.value(financialAccountDto.getValue())
				.bankId(financialAccountDto.getBankId())
				.build();
	}
}
