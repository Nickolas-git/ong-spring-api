package com.fiap.ongterraplanetaagua.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.ongterraplanetaagua.model.Toxicidade;

public interface ToxicidadeRepository extends MongoRepository<Toxicidade, String> {
	
}
