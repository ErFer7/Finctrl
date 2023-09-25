package com.erfer.finctrl.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erfer.finctrl.bank.mapper.BankMapper;
import com.erfer.finctrl.bank.model.BankDto;
import com.erfer.finctrl.bank.service.BankService;
import com.erfer.model.Bank;

@RestController
@RequestMapping("/api/bank")
@CrossOrigin(origins = "*")
public class BankController {

	@Autowired private BankService bankService;

	@GetMapping("/{bankId}")
	public ResponseEntity<BankDto> loadBank(@PathVariable Long bankId) {
		BankDto bankDto = this.bankService.loadBankById(bankId);
		return ResponseEntity.ok(bankDto);
	}

	@PostMapping("/save")
	public void saveBank(@RequestBody Bank bank) {
		BankDto bankDto = BankMapper.toDto(bank);
		this.bankService.saveBank(bankDto);
	}
}
