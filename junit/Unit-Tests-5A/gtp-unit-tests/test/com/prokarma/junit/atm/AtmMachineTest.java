package com.prokarma.junit.atm;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AtmMachineTest {
	
	private AtmMachine atmMachine;
	
	private Account account;	
	
	
	@Before
	public void setUp() {
		
		atmMachine = new AtmMachine();
		account = new Account();
		EmailSender emailSender = new EmailSender();
		SmsSender smsSender = new SmsSender();
		DummySender dummySender = new DummySender();
		account.setEmailSender(emailSender);
		account.setSmsSender(smsSender);
		account.setDummySender(dummySender);
		account.setAccountBalance(200);		
		atmMachine.setAccount(account);
	
	}
	

	@Test
	public void testwithdrawMoneySendsEmail() throws InsufficientBalanceException {
		
		account.setMailingPreference("Email");		
		atmMachine.withdrawMoney(50);		
		Assert.assertEquals(150, account.getAccountBalance());
		//fail("Not yet implemented");
		//Assert.assertEquals(1,dummySender.numberSent());
	}
	@Test
	public void testwithdrawMoneySendsSMS() throws InsufficientBalanceException {
		
		account.setMailingPreference("SMS");		
		atmMachine.withdrawMoney(50);		
		Assert.assertEquals(150, account.getAccountBalance());
		//fail("Not yet implemented");
		//Assert.assertEquals(1,dummySender.numberSent());
	}
	@Test
	public void testwithdrawMoneySendingMessageStubbed() throws InsufficientBalanceException {
		
		account.setMailingPreference("Dummy");		
		atmMachine.withdrawMoney(50);		
		Assert.assertEquals(150, account.getAccountBalance());
		
	}
	
	// Testing exceptions Junit's way: style-1
	
	@Test(expected=IllegalArgumentException.class)
	public void testwithdrawMoneyWithExpectedException() throws InsufficientBalanceException {
		
		account.setMailingPreference("InvalidMailingPreference");		
		atmMachine.withdrawMoney(50);
		
	}
	
	@Test(expected=InsufficientBalanceException.class)
	public void testwithdrawMoneyWithExpectedInsufficientBalanceException() throws InsufficientBalanceException {
		
		account.setMailingPreference("Email");		
		atmMachine.withdrawMoney(250);		// Trying to withdraw more money than remaining balance
		
		
	}
	// Testing exceptions Junit's way: style-2
	
	@Test
	public void testwithdrawMoneyIllegalArgumentExceptionUsingTryCatch() //old JUnit 3 way of testing exceptions
		{
		try{
		account.setMailingPreference("InvalidMailingPreference");		
		atmMachine.withdrawMoney(50);			
		}catch(Exception ex){
			Assert.assertEquals("Account mailing preference not valid",ex.getMessage());
		}
		
	}
	
	@Test
	public void testwithdrawMoneyInsufficientBalanceExceptionUsingTryCatch() //old JUnit 3 way of testing exceptions
		{
		try{
		account.setMailingPreference("Email");		
		atmMachine.withdrawMoney(250);  // Trying to withdraw more money than remaining balance			
		}catch(Exception ex){
			Assert.assertEquals("Balance not enough",ex.getMessage());
		}
		
	}
	// Testing exceptions Junit's way: style-3
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testWithdrawMoneyExceptionUsingRule() throws InsufficientBalanceException{ // JUnit 4 ExpectedException Rule
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Account mailing preference not valid");
		account.setMailingPreference("InvalidMailingPreference");		
		atmMachine.withdrawMoney(50);		
		
		//thrown.expectMessage("Account mailing preference not valid");
	}
	
	// Testing exceptions Junit's way: style-3
		@Rule
		public ExpectedException thrown1 = ExpectedException.none();
		@Test
		public void testWithdrawMoneyInsufficientBalanceExceptionUsingRule() throws InsufficientBalanceException{ // JUnit 4 ExpectedException Rule
			thrown1.expect(InsufficientBalanceException.class);
			thrown1.expectMessage("Balance not enough");
			account.setMailingPreference("Email");		
			atmMachine.withdrawMoney(250);		// Trying to withdraw more money than remaining balance
			
			//thrown.expectMessage("Account mailing preference not valid");
		}

}
