package com.tamseo.ws.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tamseo.ws.model.Table;

public interface TableRepository extends MongoRepository<Table, String> {

  public Table findByTableId(String id);
  
  public List<Table> findBySiteId(String siteId);
  
}
