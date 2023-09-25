package com.erfer.finctrl.register.mapper;

import com.erfer.finctrl.register.model.RegisterDto;
import com.erfer.model.Register;

public class RegisterMapper {

	public static RegisterDto toDto(Register register) {
		return RegisterDto.builder()
				.Id(register.getId())
				.name(register.getName())
				.date(register.getDate())
				.financialAccountId(register.getFinancialAccountId())
				.categoryId(register.getCategoryId())
				.value(register.getValue())
				.build();
	}

	public static Register toEntity(RegisterDto registerDto) {
		Register register = new Register();

		register.setId(registerDto.getId());
		register.setName(registerDto.getName());
		register.setDate(registerDto.getDate());
		register.setFinancialAccountId(registerDto.getFinancialAccountId());
		register.setCategoryId(registerDto.getCategoryId());
		register.setValue(registerDto.getValue());

		return register;
	}
}
