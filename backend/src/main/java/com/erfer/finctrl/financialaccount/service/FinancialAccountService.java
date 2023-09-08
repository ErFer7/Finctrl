package com.erfer.finctrl.financialaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erfer.finctrl.financialaccount.mapper.FinancialAccountMapper;
import com.erfer.finctrl.financialaccount.model.FinancialAccountDto;
import com.erfer.finctrl.financialaccount.repository.FinancialAccountRepository;
import com.erfer.model.FinancialAccount;

@Service
public class FinancialAccountService {

	@Autowired private FinancialAccountRepository financialAccountRepository;

	public FinancialAccountDto loadFinancialAccountById(Long id) {
		FinancialAccount financialAccount = this.financialAccountRepository.getReferenceById(id);
		return FinancialAccountMapper.toDto(financialAccount);
	}

	public void saveFinancialAccount(FinancialAccountDto financialAccountDto) {
		FinancialAccount financialAccount = FinancialAccountMapper.toEntity(financialAccountDto);
		this.financialAccountRepository.save(financialAccount);
	}
}
