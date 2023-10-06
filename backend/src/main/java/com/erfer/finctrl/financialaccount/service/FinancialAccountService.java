package com.erfer.finctrl.financialaccount.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erfer.finctrl.financialaccount.mapper.FinancialAccountMapper;
import com.erfer.finctrl.financialaccount.model.FinancialAccountDto;
import com.erfer.finctrl.financialaccount.repository.FinancialAccountRepository;
import com.erfer.model.FinancialAccount;

@Service
public class FinancialAccountService {

	@Autowired private FinancialAccountRepository financialAccountRepository;

	public FinancialAccountDto loadFinancialAccount(Long id) {
		FinancialAccount financialAccount = this.financialAccountRepository.getReferenceById(id);
		return FinancialAccountMapper.toDto(financialAccount);
	}

	public List<FinancialAccountDto> loadAllFinancialAccounts() {
		List<FinancialAccount> financialAccounts = this.financialAccountRepository.findAll();
		return financialAccounts.stream().map(FinancialAccountMapper::toDto).collect(Collectors.toList());
	}

	public void saveFinancialAccount(FinancialAccountDto financialAccountDto) {
		FinancialAccount financialAccount = FinancialAccountMapper.toEntity(financialAccountDto);
		this.financialAccountRepository.save(financialAccount);
	}

	public void deleteFinancialAccount(Long id) {
		this.financialAccountRepository.deleteById(id);
	}
}
