package com.erfer.finctrl.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erfer.finctrl.bank.mapper.BankMapper;
import com.erfer.finctrl.bank.model.BankDto;
import com.erfer.finctrl.bank.repository.BankRepository;
import com.erfer.model.Bank;

@Service
public class BankService {

	@Autowired private BankRepository bankRepository;

	public BankDto loadBankById(Long id) {
		Bank bank = this.bankRepository.getReferenceById(id);
		return BankMapper.toDto(bank);
	}

	public void saveBank(BankDto bankDto) {
		Bank bank = BankMapper.toEntity(bankDto);
		this.bankRepository.save(bank);
	}
}
