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

import br.fatec.financas.model.Conta;
import br.fatec.financas.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController implements ControllerInterface<Conta> {
	
	@Autowired
	private ContaService service;
	
	//Lista todas as contas
	@Override
	@GetMapping 
	public ResponseEntity<List<Conta>> getAll(){
		return ResponseEntity.ok(service.findAll());
		//resposta: lista de objetos da classe Conta
	}
	
	//Lista uma conta por id
	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id){
		Conta _conta = service.findById(id);
		if(_conta != null) {
			return ResponseEntity.ok(_conta);
			//devolve o objeto conta
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		//devolve not found
		//build constrói a resposta. sempre tem que ter no final
	}
	
	//Cria conta
	@Override
	@PostMapping
	public ResponseEntity<Conta> post(@RequestBody Conta conta){
		service.create(conta);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
		//cria a uri passando o id como parametro
		return ResponseEntity.created(location).body(conta);
		//retorna no corpo  da requisição o objeto que foi criado (padrão é devolver a url do objeto criado)
	}
	
	//Atualiza
	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Conta conta){
		//retorna a conta atualizada
		if(service.update(conta)) { 
			return ResponseEntity.ok(conta);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//Remove
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		if(service.delete(id)) {
			return ResponseEntity.ok().build();
			//devolve somente um ok se o objeto foi deletado
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//Depositar
	@PostMapping("/deposito/{id}/{valor}")
	public ResponseEntity<?> depositar(@PathVariable("id") Long id, @PathVariable("valor") Float valor){
		try {
			return ResponseEntity.ok(service.depositar(id, valor));
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			//ou ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Sacar
	@PostMapping("/saque/{id}/{valor}")
	public ResponseEntity<?> sacar(@PathVariable("id") Long id, @PathVariable("valor") Float valor){
		try {
			return ResponseEntity.ok(service.sacar(id, valor));
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}
	
	@GetMapping(value = "/agencia/{agencia}") 
	public ResponseEntity<List<Conta>> getByAgencia(@PathVariable("agencia") Integer agencia){
		return ResponseEntity.ok(service.listarPorAgencia(agencia));
	}
	
	@GetMapping(value = "/agencia/{agencia}/{from}/{to}") 
	public ResponseEntity<List<Conta>>getByAgenciaESaldo(@PathVariable("agencia") Integer agencia, @PathVariable("from") Float from, @PathVariable("to") Float to) {
		return ResponseEntity.ok(service.listarPorAgenciaESaldo(agencia, from, to));
	}
	
	@GetMapping(value = "/cliente/{nome}")
	public ResponseEntity<List<Conta>>getByNomeCliente(@PathVariable("nome") String nome){
		return ResponseEntity.ok(service.listarPorNomeCliente(nome));
	}
}
