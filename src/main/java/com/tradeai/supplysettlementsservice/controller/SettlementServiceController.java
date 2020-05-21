package com.tradeai.supplysettlementsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.supplysettlementsservice.jms.MessagePublisher;
import com.tradeai.supplysettlementsservice.service.SettlementService;

@RestController
@RequestMapping("/settlement")
public class SettlementServiceController {
	
	@Autowired
	SettlementService settlementService; 
	

	@PostMapping
	public ResponseEntity<Boolean> publishMessage(@RequestBody String contractRequest) throws Exception { 
		
		settlementService.sendSettlementRequest(contractRequest);
		
		return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
		
	}
}
