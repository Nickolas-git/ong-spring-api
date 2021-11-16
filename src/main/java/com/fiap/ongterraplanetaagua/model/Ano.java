package com.fiap.ongterraplanetaagua.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "ano")
public class Ano {
	
	@Id
	private String id;
	private String ano_key;
	private String ano_desc;
}
