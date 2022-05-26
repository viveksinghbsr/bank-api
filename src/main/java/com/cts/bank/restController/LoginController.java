package com.cts.bank.restController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bank.entity.Account;
import com.cts.bank.service.AccountService;
import com.cts.bank.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private AccountService accountService;

	@PostMapping("/login")
	public Object loginUser(@RequestBody Map<String, Object> map) {
		String email = (String) map.get("email");
		String password = (String) map.get("password");
		String dbEmail = loginService.getEmail(email);
		String dbPassword = loginService.getPassword(email);

		if (dbEmail == null) {
			throw new RuntimeException("Invalid Username or Password");
		}
		if (dbEmail.equals(email) && dbPassword.equals(password)) {
			return loginService.getUser(dbEmail);
		} else {
			throw new RuntimeException("Invalid Username or Password");
		}
	}

	@GetMapping("/user/account/{user_id}")
	public Account getAccount(@PathVariable int user_id) {
		return accountService.getAccount(user_id);
	}

}
