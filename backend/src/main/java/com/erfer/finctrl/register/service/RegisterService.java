package com.erfer.finctrl.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erfer.finctrl.register.mapper.RegisterMapper;
import com.erfer.finctrl.register.model.RegisterDto;
import com.erfer.finctrl.register.repository.RegisterRepository;
import com.erfer.model.Register;

@Service
public class RegisterService {

	@Autowired private RegisterRepository registerRepository;

	public RegisterDto loadRegister(Long id) {
		Register register = this.registerRepository.getReferenceById(id);
		return RegisterMapper.toDto(register);
	}

	public void saveRegister(RegisterDto registerDto) {
		Register register = RegisterMapper.toEntity(registerDto);
		this.registerRepository.save(register);
	}
}
