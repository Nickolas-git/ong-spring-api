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

import com.fiap.ongterraplanetaagua.model.Usuario;
import com.fiap.ongterraplanetaagua.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping()
	public ResponseEntity<Usuario> post(@RequestBody Usuario model) {

		Usuario usuario = usuarioRepository.save(model);

		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable String id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (!usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> put(@PathVariable String id, @RequestBody Usuario model) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (!usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Usuario usuarioSalvo = usuarioRepository.save(model);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.ACCEPTED);
	}
}