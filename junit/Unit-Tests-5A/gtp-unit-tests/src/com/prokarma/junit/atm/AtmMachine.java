package com.prokarma.junit.atm;

public class AtmMachine {
	
	private Account account;
	
	public Account withdrawMoney(int requestedAmount) throws InsufficientBalanceException{
		
		if(account.isValidDebit(requestedAmount)){			
			account.updateAccountWithDebit(requestedAmount);
			account.getMessageSender().send("Sending Message");
		} else {
			System.out.println("Requested amount is greater than available balance");
			throw new InsufficientBalanceException("Balance not enough");			
		}
				
		return account;
		
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

		
	

}
