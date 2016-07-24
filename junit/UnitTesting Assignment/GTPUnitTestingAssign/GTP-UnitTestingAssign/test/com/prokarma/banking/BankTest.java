package com.prokarma.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.prokarma.banking.AccountDoesNotExistException;
import com.prokarma.banking.AccountExistsException;
import com.prokarma.banking.Bank;
import com.prokarma.banking.Currency;

public class BankTest {
	Currency INR, EURO, USD;
	Bank stateBankOfIndia, euroBank, usBank;
	
	@Before
	public void setUp() throws Exception {
		INR = new Currency("INR", 0.02);
		EURO = new Currency("EURO", 1.36);
		USD = new Currency("USD", 1.0 );
		stateBankOfIndia = new Bank("SBI", INR);
		euroBank = new Bank("SWI", EURO);
		usBank = new Bank("USB", USD);
		stateBankOfIndia.openAccount("Srini");
		euroBank.openAccount("Bob");
		usBank.openAccount("Bob");
		euroBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		fail("Write test case here");
	}

	@Test
	public void testGetCurrency() {
		fail("Write test case here");
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		fail("Write test case here");
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		fail("Write test case here");
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
	
	
}
