package com.cts.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bank.dao.LoginRepository;
import com.cts.bank.entity.User;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public User getUser(String email) {
		return loginRepository.getUser(email);
	}

	public String getEmail(String email) {
		return loginRepository.getEmail(email);
	}

	public String getPassword(String email) {
		return loginRepository.getPassword(email);
	}

}
