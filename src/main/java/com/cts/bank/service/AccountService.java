package com.cts.bank.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bank.dao.AccountRepository;
import com.cts.bank.entity.Account;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public void createAccount(int user_id,String account_number,String name,LocalDateTime created_at) {
		accountRepository.createAccount(user_id,account_number,name,created_at);
	}
	public double getCurrentBalance(int account_id) {
		return accountRepository.getCurrentBalance(account_id);
	}
	public void updateBalance(double new_balance,int account_id) {
		accountRepository.updateBalance(new_balance, account_id);
	}
	public Account getAccount(int user_id) {
		return accountRepository.getAccount(user_id);
	}

}
