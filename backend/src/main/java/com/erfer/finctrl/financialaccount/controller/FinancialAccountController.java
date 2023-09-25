package com.erfer.finctrl.financialaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erfer.finctrl.financialaccount.mapper.FinancialAccountMapper;
import com.erfer.finctrl.financialaccount.model.FinancialAccountDto;
import com.erfer.finctrl.financialaccount.service.FinancialAccountService;
import com.erfer.model.FinancialAccount;

@RestController
@RequestMapping("/api/financialaccount")
@CrossOrigin(origins = "*")
public class FinancialAccountController {

	@Autowired private FinancialAccountService financialAccountService;

	@GetMapping("/{financialAccountId}")
	public ResponseEntity<FinancialAccountDto> loadFinancialAccount(Long financialAccountId) {
		FinancialAccountDto financialAccountDto = this.financialAccountService.loadFinancialAccountById(financialAccountId);
		return ResponseEntity.ok(financialAccountDto);
	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<FinancialAccountDto>> loadAllFinancialAccounts() {
		Iterable<FinancialAccountDto> financialAccountDtos = this.financialAccountService.loadAllFinancialAccounts();
		return ResponseEntity.ok(financialAccountDtos);
	}

	@PostMapping("/save")
	public void saveFinancialAccount(@RequestBody FinancialAccount financialAccount) {
		FinancialAccountDto financialAccountDto = FinancialAccountMapper.toDto(financialAccount);
		this.financialAccountService.saveFinancialAccount(financialAccountDto);
	}
}
