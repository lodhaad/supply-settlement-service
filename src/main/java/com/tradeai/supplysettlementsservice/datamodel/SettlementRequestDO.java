package com.tradeai.supplysettlementsservice.datamodel;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity

@Table (name = "settlement_reqeust", schema = "supply")

public class SettlementRequestDO {

	@Id
	@Column (name = "reference")
	String reference;
	
	@Column (name = "value")
	Double value;
	
	@Column (name = "quantity")
	Long qty;
	
	@Column (name = "security")
	String sec;
	
	@Column (name = "value_date")
	String vdte;
	
	@Column (name = "price")
	Double price;
	
	@Column (name = "txn_type")
	String txntype;
	
	@Column (name = "message_type")
	String msgtype;
	
	@Column (name = "dvp_fop")
	String dvpfop;
	
	@Column (name = "counter_party")
	String cpty;
	
	@Column (name = "time_stamp")
	Timestamp timestamp;
	
	
}
