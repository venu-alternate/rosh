package com.prokarma.junit.atm;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AtmMachineTestMock {
	
	@InjectMocks
	private AtmMachine atmMachine;
	
	@Mock
	private Account account;
	
		
	@Mock
	EmailSender emailSender;
	
	@Before
	public void setUp() {
		initMocks(this);		
		//atmMachine = new AtmMachine();	
		
		
	}
	

	@Test
	public void testWithdrawMoneyEnoughBalance() throws InsufficientBalanceException {
		when(account.getAccountBalance()).thenReturn(200);
		when(account.isValidDebit(any(int.class))).thenReturn(true);
		when(account.getMessageSender()).thenReturn(emailSender);		
		//atmMachine.setAccount(account);		
		atmMachine.withdrawMoney(50);
		            
		//fail("Not yet implemented");
		verify(account).isValidDebit(50);
		verify(account).updateAccountWithDebit(50);
		
	}
	
	@Test(expected=InsufficientBalanceException.class)
	public void testWithdrawMoneyNotEnoughBalance() throws InsufficientBalanceException {
		when(account.getAccountBalance()).thenReturn(200);
		when(account.isValidDebit(any(int.class))).thenReturn(false);
		when(account.getMessageSender()).thenReturn(emailSender);	
		atmMachine.withdrawMoney(250);		
		verify(account).isValidDebit(250);
		verify(account,never()).updateAccountWithDebit(250); // verifying the interaction with dependency method updateAccountWithDebit is never called because balance is not enough
		//fail("Not yet implemented");
	}

}
