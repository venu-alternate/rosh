package com.prokarma.junit.atm;

public class EmailSender implements MessageSender {

	@Override
	public boolean send(String message) {
		
		//Email sending code
		System.out.println(message+"\n");
		System.out.println("Sends Real mail to Real persons\n");
		return true;

	}

}
