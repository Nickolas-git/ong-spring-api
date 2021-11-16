package com.fiap.ongterraplanetaagua.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.ongterraplanetaagua.model.Toxicidade;
import com.fiap.ongterraplanetaagua.repository.ToxicidadeRepository;

@RestController
@RequestMapping("/toxicidade")
public class ToxicidadeController {
	
	@Autowired
	private ToxicidadeRepository toxicidaderepository;
	
	@PostMapping()
	public ResponseEntity<Toxicidade> post(@RequestBody Toxicidade model) {

		Toxicidade toxicidade = toxicidaderepository.save(model);

		return new ResponseEntity<>(toxicidade, HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Toxicidade> getAll() {
		return toxicidaderepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Toxicidade> getById(@PathVariable String id) {

		Optional<Toxicidade> toxicidade = toxicidaderepository.findById(id);

		if (!toxicidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Toxicidade>(toxicidade.get(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Toxicidade> put(@PathVariable String id, @RequestBody Toxicidade model) {

		Optional<Toxicidade> toxicidade = toxicidaderepository.findById(id);

		if (!toxicidade.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Toxicidade toxicidadeSalvo = toxicidaderepository.save(model);
		return new ResponseEntity<Toxicidade>(toxicidadeSalvo, HttpStatus.ACCEPTED);
	}
	
}
