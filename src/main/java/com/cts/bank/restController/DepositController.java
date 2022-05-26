package com.cts.bank.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bank.service.AccountService;

@RestController
public class DepositController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/{account_id}/deposit/{deposit_amount}")
	public void depositAmount(@PathVariable double deposit_amount, @PathVariable int account_id) {
        
        double current_balance=accountService.getCurrentBalance(account_id);
        
        double new_balance=current_balance+deposit_amount;
        
        //update balance in database
        accountService.updateBalance(new_balance, account_id);
        
	}
}


