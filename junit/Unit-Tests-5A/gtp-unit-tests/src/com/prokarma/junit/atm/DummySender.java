package com.prokarma.junit.atm;

import java.util.ArrayList;
import java.util.List;

public class DummySender implements MessageSender {
	
	private List<String> messages = new ArrayList<String>();


	@Override
	public boolean send(String message) {
		// TODO Auto-generated method stub
		 messages.add(message);
		System.out.println("Sending message is stubbed out");
		return true;

	}
	public int numberSent() {
	    return messages.size();
	  }


}
