package com.prokarma.banking;

import java.util.Hashtable;

public class Account {
	private Money content;
	
	Account(String name, Currency currency) {
		this.content = new Money(0, currency);
	}

	
	
	
	
	/**
	 * Deposit money to the account
	 * @param money Money to deposit.
	 */
	public void deposit(Money money) {
		content = content.add(money);
	}
	
	/**
	 * Withdraw money from the account
	 * @param money Money to withdraw.
	 */
	public void withdraw(Money money) {
		content = content.sub(money);
	}

	/**
	 * Get balance of account
	 * @return Amount of Money currently on account
	 */
	public Money getBalance() {
		return content;
	}
	

}
