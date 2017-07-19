package com.revature.dao;

import com.revature.model.BankUser;

public interface BankUserDao {
	/*
	 * CRUD ops ONLY
	 * CREATE
	 * READ
	 * UPDATE
	 * DELETE
	 * 
	 */

	public BankUser getBankUserByUsername(BankUser user);

}
