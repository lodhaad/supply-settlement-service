package com.tradeai.supplysettlementsservice.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tradeai.supplysettlementsservice.controller.ContractServiceClient;
import com.tradeai.supplysettlementsservice.datamodel.SettlementRequestDO;
import com.tradeai.supplysettlementsservice.datamodel.SettlementResponseDO;
import com.tradeai.supplysettlementsservice.jms.MessagePublisher;
import com.tradeai.supplysettlementsservice.model.SettlementRequest;
import com.tradeai.supplysettlementsservice.repo.SettlementRequestRepo;

@Service
public class SettlementService {

	@Autowired
	private MessagePublisher publisher ; 
	
	@Autowired
	private SettlementRequestRepo requestRepo;

	@Autowired
	private SettlementResponseDO responseRepo;
	
	@Autowired
	private ContractServiceClient contractServiceClient;
	
	public boolean sendSettlementRequest(String settlementRequestMessage) {
		Gson gson = new Gson();
		SettlementRequest settlementRequest = gson.fromJson(settlementRequestMessage, SettlementRequest.class);

		
		UUID uuid = UUID.randomUUID();
		settlementRequest.setRef(uuid.toString());
		
		SettlementRequestDO settlementRequestDO = new SettlementRequestDO();
			
		
		settlementRequestDO.setReference(uuid.toString());
		settlementRequestDO.setCpty(settlementRequest.getCpty());
		settlementRequestDO.setDvpfop(settlementRequest.getDvpfop());
		settlementRequestDO.setMsgtype(settlementRequest.getMsgtype());
		settlementRequestDO.setSec(settlementRequest.getSec());
		settlementRequestDO.setQty(settlementRequest.getQty());
		settlementRequestDO.setValue(settlementRequest.getValue());
		settlementRequestDO.setPrice(settlementRequest.getPrice());
		
		settlementRequestDO.setTimestamp(Timestamp.from(Instant.now()));
		

		requestRepo.save(settlementRequestDO);
		
		
		String reqJson = gson.toJson(settlementRequest);
		
		publisher.sendMessageToSettlement(reqJson);
		
		return false;
		
	}
	
	
	public boolean processSettlementResponse(String settlemtResponseMessage) {
		
		return false;
		
	}
	
	
	
}
