package com.prokarma.banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.prokarma.banking.Currency;
import com.prokarma.banking.Money;

public class MoneyTest {
	Currency  INR, EURO, USD;
	Money INR100, EURO10, EURO20, USD0, USDn10;
	
	@Before
	public void setUp() throws Exception {
		INR = new Currency("INR", 0.02);
		EURO = new Currency("EURO", 1.36);
		USD = new Currency("USD", 1.0 );
		INR100 = new Money(10000, INR);
		EURO10 = new Money(1000, EURO);
		EURO20 = new Money(2000, EURO);
		USD0 = new Money(0, USD);		
		USDn10 = new Money(-1000, USD);
	}

	@Test
	public void testGetAmount() {
		fail("Write test case here");
	}

	@Test
	public void testGetCurrency() {
		fail("Write test case here");
	}

	@Test
	public void testToString() {
		fail("Write test case here");
	}

	@Test
	public void testGlobalValue() {
		fail("Write test case here");
	}

	@Test
	public void testEqualsMoney() {
		fail("Write test case here");
	}

	@Test
	public void testAdd() {
		fail("Write test case here");
	}

	@Test
	public void testSub() {
		fail("Write test case here");
	}

	@Test
	public void testIsZero() {
		fail("Write test case here");
	}

	@Test
	public void testNegate() {
		fail("Write test case here");
	}

	@Test
	public void testCompareTo() {
		fail("Write test case here");
	}
}
