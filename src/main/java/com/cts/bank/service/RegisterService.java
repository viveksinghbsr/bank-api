package com.cts.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bank.dao.RegisterRepository;
import com.cts.bank.entity.User;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public void registerUser(User user) {
		registerRepository.save(user);
	}
	
	public int getId(String accountNumber) {
		return registerRepository.getId(accountNumber);
	}


}
