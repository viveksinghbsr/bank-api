package com.cts.bank.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bank.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO accounts(user_id,account_number,account_name,created_at) VALUES"+"(:user_id,:account_number,:name,:created_at)",nativeQuery=true)
	@Transactional
	void createAccount(@Param("user_id") int user_id, @Param("account_number") String account_number,@Param("name") String name,@Param("created_at") LocalDateTime created_at);
	
	@Query(value="SELECT balance FROM accounts where account_id=:account_id",nativeQuery=true)
	@Transactional
	double getCurrentBalance(@Param("account_id") int account_id);
	
	@Modifying
	@Query(value="UPDATE accounts SET balance=:new_balance WHERE account_id=:account_id",nativeQuery=true)
	@Transactional
	void updateBalance(@Param("new_balance") double newBalance,@Param("account_id") int account_id);
	
	@Query(value="SELECT * FROM accounts where user_id=:user_id",nativeQuery=true)
	@Transactional
	Account getAccount(@Param("user_id") int user_id);
}
