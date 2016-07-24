package com.prokarma.junit.atm;

public class SmsSender implements MessageSender {

	@Override
	public boolean send(String message) {
		
		//SMS sending code
		System.out.println(message+"\n");
		System.out.println("Sends real SMS to real persons\n");
		return true;

	}

}
