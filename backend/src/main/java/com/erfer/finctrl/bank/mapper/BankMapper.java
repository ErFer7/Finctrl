package com.erfer.finctrl.bank.mapper;

import com.erfer.finctrl.bank.model.BankDto;
import com.erfer.model.Bank;

public class BankMapper {

	public static BankDto toDto(Bank bank) {
		BankDto bankDto = new BankDto();
		bankDto.setId(bank.getId());
		bankDto.setName(bank.getName());
		return bankDto;
	}

	public static Bank toEntity(BankDto bankDto) {
		Bank bank = new Bank();
		bank.setId(bankDto.getId());
		bank.setName(bankDto.getName());
		return bank;
	}
}
