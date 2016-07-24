package com.prokarma.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.prokarma.banking.Currency;

public class CurrencyTest {
	Currency  INR, EURO, USD;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		INR = new Currency("INR", 0.02);
		EURO = new Currency("EURO", 1.36);
		USD = new Currency("USD", 1.0 );
	}

	@Test
	public void testGetName() {
		fail("Write test case here");
	}
	
	@Test
	public void testGetRate() {
		fail("Write test case here");
	}
	
	@Test
	public void testSetRate() {
		fail("Write test case here");
	}
	
	@Test
	public void testGlobalValue() {
		fail("Write test case here");
	}
	
	@Test
	public void testValueInThisCurrency() {
		fail("Write test case here");
	}

}
