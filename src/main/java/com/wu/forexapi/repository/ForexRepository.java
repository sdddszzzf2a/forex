package com.wu.forexapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wu.forexapi.model.Forex;

@Repository
public interface ForexRepository extends MongoRepository<Forex, String>{

}
