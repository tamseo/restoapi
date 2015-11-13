package com.tamseo.ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tamseo.ws.model.Table;

public interface TableRepository extends MongoRepository<Table, String> {

}
