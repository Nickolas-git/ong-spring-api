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

import com.fiap.ongterraplanetaagua.model.Ano;
import com.fiap.ongterraplanetaagua.repository.AnoRepository;

@RestController
@RequestMapping("/ano")
public class AnoController {

	@Autowired
	private AnoRepository anorepository;
	
	@PostMapping()
	public ResponseEntity<Ano> post(@RequestBody Ano model) {

		Ano ano = anorepository.save(model);

		return new ResponseEntity<>(ano, HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Ano> getAll() {
		return anorepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ano> getById(@PathVariable String id) {

		Optional<Ano> ano = anorepository.findById(id);

		if (!ano.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Ano>(ano.get(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ano> put(@PathVariable String id, @RequestBody Ano model) {

		Optional<Ano> ano = anorepository.findById(id);

		if (!ano.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Ano anoSalvo = anorepository.save(model);
		return new ResponseEntity<Ano>(anoSalvo, HttpStatus.ACCEPTED);
	}
	
}
