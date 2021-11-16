package com.fiap.ongterraplanetaagua.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "toxicidade")
public class Toxicidade {
	
	@Id
	private String id;
	private String ano_key;
	private String toxicity_lvl;
	
}
