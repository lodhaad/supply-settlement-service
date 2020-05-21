package com.tradeai.supplysettlementsservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.supplysettlementsservice.datamodel.SettlementResponseDO;

public interface SettlementResponseRepo extends CrudRepository<SettlementResponseDO, String> {

}
