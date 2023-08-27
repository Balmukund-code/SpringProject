package com.example.springAPI.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springAPI.models.CreateData;

public interface CreateDataRepo extends MongoRepository<CreateData, Integer> {

	
}
