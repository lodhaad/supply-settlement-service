package com.tradeai.supplysettlementsservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.supplysettlementsservice.datamodel.SettlementRequestDO;

public interface SettlementRequestRepo  extends CrudRepository<SettlementRequestDO, String>{

}
