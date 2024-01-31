package com.wu.forexapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wu.forexapi.model.Forex;

@Repository
public interface ForexRepository extends MongoRepository<Forex, String>{

	@Query("{_id: {$gte: ?0, $lte: ?1}}")
	public Forex[] findByDate(String startDate, String endDate);

}
