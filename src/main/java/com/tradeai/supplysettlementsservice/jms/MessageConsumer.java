package com.tradeai.supplysettlementsservice.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@JmsListener(destination = "exchange.to.settlement", containerFactory = "messageFactory")
	public void receiveMessage(String jSonMessage) {
		System.out.println("Received <" + jSonMessage + ">");
	}

}
