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

import br.fatec.financas.model.PessoaJuridica;
import br.fatec.financas.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pessoas_juridicas")
public class PessoaJuridicaController implements ControllerInterface<PessoaJuridica> {
	
	@Autowired
	private PessoaJuridicaService service;
	
	@Override
	@GetMapping 
	public ResponseEntity<List<PessoaJuridica>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id){
		PessoaJuridica pessoa_juridica = service.findById(id);
		if(pessoa_juridica != null) {
			return ResponseEntity.ok(pessoa_juridica);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@PostMapping
	public ResponseEntity<PessoaJuridica> post(@RequestBody PessoaJuridica pessoa_juridica){
		service.create(pessoa_juridica);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa_juridica.getId()).toUri();
		return ResponseEntity.created(location).body(pessoa_juridica);
	}
	
	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody PessoaJuridica pessoa_juridica){
		if(service.update(pessoa_juridica)) { 
			return ResponseEntity.ok(pessoa_juridica);
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
