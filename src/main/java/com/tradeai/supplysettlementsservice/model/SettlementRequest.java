package com.tradeai.supplysettlementsservice.model;

import lombok.Data;

@Data
public class SettlementRequest {

	String ref;
	Double value;
	Long qty;
	String sec;
	String vdte;
	Double price;
	String txntype;
	String msgtype;
	String dvpfop;
	String cpty;
	
}
