package com.erfer.finctrl.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erfer.finctrl.register.mapper.RegisterMapper;
import com.erfer.finctrl.register.model.RegisterDto;
import com.erfer.finctrl.register.service.RegisterService;
import com.erfer.model.Register;

@RestController
@RequestMapping("api/register")
@CrossOrigin(origins = "*")
public class RegisterController {

	@Autowired private RegisterService registerService;

	@GetMapping("/{register}")
	public ResponseEntity<RegisterDto> showRegister(Long registerId) {
		RegisterDto registerDto = this.registerService.loadRegisterById(registerId);
		return ResponseEntity.ok(registerDto);
	}

	@PostMapping("/save")
	public void saveRegister(@RequestBody Register register) {
		RegisterDto registerDto = RegisterMapper.toDto(register);
		this.registerService.saveRegister(registerDto);
	}
}
