package com.cts.bank.restController;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bank.entity.User;
import com.cts.bank.helpers.GenAccountNumber;
import com.cts.bank.service.AccountService;
import com.cts.bank.service.RegisterService;

@RestController
public class RegisterController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private RegisterService registerService;

	@PostMapping("/user")
	public void registerUser(@RequestBody User user) {
		int setAccountNumber = GenAccountNumber.generateAccountNumber();
		String bankAccountNumber = Integer.toString(setAccountNumber);
		user.setAccount_number(bankAccountNumber);
		user.setCreated_at(LocalDateTime.now());
		
		registerService.registerUser(user);
		int user_id=registerService.getId(bankAccountNumber);
		accountService.createAccount(user_id,user.getAccount_number(),user.getName(),user.getCreated_at());
		

	}

}
