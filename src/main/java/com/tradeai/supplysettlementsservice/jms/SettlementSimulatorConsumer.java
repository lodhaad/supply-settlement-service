package com.tradeai.supplysettlementsservice.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tradeai.supplysettlementsservice.model.SettlementRequest;
import com.tradeai.supplysettlementsservice.model.SettlementResponse;

@Component
public class SettlementSimulatorConsumer {

	@Autowired
	SettlementSimulatorPublisher settlementSimulatorPublisher;
	
	@JmsListener(destination = "settlement.to.exchange", containerFactory = "messageFactory")
	public void receiveMessage(String jSonMessage) {
		System.out.println("Received <" + jSonMessage + ">");
		
		Gson gson = new Gson();
		SettlementRequest settlementRequest = gson.fromJson(jSonMessage, SettlementRequest.class);
		
		
		SettlementResponse settlementResponse = new SettlementResponse();
		settlementResponse.setResponseType("OI");
		settlementResponse.setTransactionReference(settlementRequest.getRef());
		
		String responseJson = gson.toJson(settlementResponse);
		
		settlementSimulatorPublisher.sendMessageToSettlement(responseJson);
		
		try {
			Thread.sleep(10000);;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		settlementResponse.setResponseType("SETT");
		responseJson = gson.toJson(settlementResponse);
		
		settlementSimulatorPublisher.sendMessageToSettlement(responseJson);		
		
	}
}
