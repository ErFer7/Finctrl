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
		return Register.builder()
				.id(registerDto.getId())
				.name(registerDto.getName())
				.date(registerDto.getDate())
				.financialAccountId(registerDto.getFinancialAccountId())
				.categoryId(registerDto.getCategoryId())
				.value(registerDto.getValue())
				.build();
	}
}
