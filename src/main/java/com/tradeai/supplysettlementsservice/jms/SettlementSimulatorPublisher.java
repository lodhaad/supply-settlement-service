package com.tradeai.supplysettlementsservice.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component

public class SettlementSimulatorPublisher {

	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendMessageToSettlement(String jsonMessage) {
		jmsTemplate.convertAndSend("exchange.to.settlement", jsonMessage);
	}
	
}
