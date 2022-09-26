package br.fatec.financas.controller;

import java.net.URI; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.financas.model.PessoaFisica;
import br.fatec.financas.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoas_fisicas")
public class PessoaFisicaController implements ControllerInterface<PessoaFisica> {
	
	@Autowired
	private PessoaFisicaService service;
	
	@Override
	@GetMapping 
	public ResponseEntity<List<PessoaFisica>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id){
		PessoaFisica pessoa_fisica = service.findById(id);
		if(pessoa_fisica != null) {
			return ResponseEntity.ok(pessoa_fisica);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@PostMapping
	public ResponseEntity<PessoaFisica> post(@RequestBody PessoaFisica pessoa_fisica){
		service.create(pessoa_fisica);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa_fisica.getId()).toUri();
		return ResponseEntity.created(location).body(pessoa_fisica);
	}
	
	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody PessoaFisica pessoa_fisica){
		if(service.update(pessoa_fisica)) { 
			return ResponseEntity.ok(pessoa_fisica);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		if(service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
