package com.prokarma.banking;

import org.junit.Before;
import org.junit.Test;

import com.prokarma.banking.Account;
import com.prokarma.banking.AccountDoesNotExistException;
import com.prokarma.banking.Bank;
import com.prokarma.banking.Currency;
import com.prokarma.banking.Money;

import static org.junit.Assert.*;

public class AccountTest {
	Currency INR, EURO, USD;
	Bank stateBankOfIndia;
	Bank euroBank;
	Bank usBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		INR = new Currency("INR", 0.02);
		stateBankOfIndia = new Bank("SBI", INR);
		stateBankOfIndia.openAccount("Venkat");
		testAccount = new Account("Sridhar", INR);
		testAccount.deposit(new Money(10000000, INR));

		stateBankOfIndia.deposit("Sridhar", new Money(1000000, INR));
	}
	
	@Test
	public void testDeposit() {
		fail("Write test case here");
	}
	
	@Test
	public void testAddWithdraw() {
		fail("Write test case here");
	}
	
	@Test
	public void testGetBalance() {
		fail("Write test case here");
	}
}
