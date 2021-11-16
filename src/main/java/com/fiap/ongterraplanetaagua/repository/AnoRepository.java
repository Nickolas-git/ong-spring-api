package com.fiap.ongterraplanetaagua.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.ongterraplanetaagua.model.Ano;

public interface AnoRepository extends MongoRepository<Ano, String> {

}
