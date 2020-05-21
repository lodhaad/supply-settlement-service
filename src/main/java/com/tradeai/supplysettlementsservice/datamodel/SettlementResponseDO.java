package com.tradeai.supplysettlementsservice.datamodel;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity

@Table (name = "settlement_response", schema = "supply")
public class SettlementResponseDO {

	@Column (name = "response_type")
	String responseType;
	
	@Id
	@Column (name = "reference")
	String reference;
	

	@Column (name = "time_stamp")
	Timestamp timestamp;
}
