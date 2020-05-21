package com.tradeai.supplysettlementsservice.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendMessageToSettlement(String jsonMessage) {
		jmsTemplate.convertAndSend("settlement.to.exchange", jsonMessage);
	}
}
