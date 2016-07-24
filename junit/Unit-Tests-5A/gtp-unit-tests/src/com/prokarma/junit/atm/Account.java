package com.prokarma.junit.atm;

public class Account {
	
	private int accountBalance;
	
	private String mailingPreference;	
	
	private MessageSender messageSender;	
	
    private EmailSender emailSender;
    private SmsSender smsSender;
    private DummySender dummySender;
    
	
	public EmailSender getEmailSender() {
		return emailSender;
	}


	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}


	public SmsSender getSmsSender() {
		return smsSender;
	}


	public void setSmsSender(SmsSender smsSender) {
		this.smsSender = smsSender;
	}


	public DummySender getDummySender() {
		return dummySender;
	}


	public void setDummySender(DummySender dummySender) {
		this.dummySender = dummySender;
	}


	public MessageSender getMessageSender() {
		if("Email".equals(this.getMailingPreference())){
			messageSender = emailSender;
		}else if("SMS".equals(this.getMailingPreference())){
			messageSender = smsSender;
		}else if("Dummy".equals(this.getMailingPreference())){
			messageSender = dummySender;
		}else{
			throw new IllegalArgumentException("Account mailing preference not valid");
		}
		return messageSender;
	}


	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}


	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getMailingPreference() {
		return mailingPreference;
	}

	public void setMailingPreference(String mailingPreference) {
		this.mailingPreference = mailingPreference;
	}
	
	public boolean isValidDebit(int requestedAmount){
		
		if(requestedAmount < getAccountBalance())
			return true;
		else
			return false;
		
	}
	
	public void updateAccountWithDebit(int requestedAmount){
		
		accountBalance = accountBalance - requestedAmount;
		return;
		
	}

}
