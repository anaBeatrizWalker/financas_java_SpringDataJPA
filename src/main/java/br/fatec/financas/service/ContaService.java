package br.fatec.financas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.fatec.financas.model.Conta;
import br.fatec.financas.repository.ContaRepository;

@Service
public class ContaService implements ServiceInterface<Conta> {
	@Autowired
	private ContaRepository repository;
	
	public ContaService() {}
	
	@Override //sobscreve o metodo de ServiceInterface
	public Conta create(Conta conta) {
		repository.save(conta);
		return conta;
	}
	
	@Override
	public Page<Conta> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	@Override
	public Conta findById(Long id) {
		Optional<Conta> conta = repository.findById(id);
		return conta.orElse(null);
	}
	
	public boolean update(Conta conta) {
		if(repository.existsById(conta.getId())) {
			repository.save(conta);
			return true;
		}
		return false;
	}
	
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	} 
	
	public Float depositar(Long id, Float valor) throws IllegalArgumentException {
		Optional<Conta> conta = repository.findById(id);
		if(conta.isPresent()) {
			//atualiza saldo
			Conta saldoAtual = conta.get();
			saldoAtual.setSaldo(saldoAtual.getSaldo() + valor);
			repository.save(saldoAtual);
			return saldoAtual.getSaldo();
		}
		throw new IllegalArgumentException("Conta não encontrada.");
		//throw instancia uma exception
	}
	
	public Float sacar(Long id, Float valor) throws IllegalArgumentException {
		Optional<Conta> conta = repository.findById(id);
		if(conta.isPresent()) {
			Conta saldoAtual = conta.get();
			if(saldoAtual.getSaldo() >= valor) {
				saldoAtual.setSaldo(saldoAtual.getSaldo() - valor);
				repository.save(saldoAtual);
				return saldoAtual.getSaldo();
			}
			else {
				throw new IllegalArgumentException("Saldo insuficiente.");
			}
		}
		else {
			throw new IllegalArgumentException("Conta não encontrada.");
		}
	}
	
	public List<Conta> listarPorAgencia(Integer agencia) { 
		return repository.findByAgencia(agencia); 
	}
	
	public List<Conta> listarPorAgenciaESaldo(Integer agencia, Float from, Float to) {
		return repository.findByAgenciaAndSaldoBetween(agencia, from, to);
	}

	public List<Conta> listarPorNomeCliente(String nome){
		return repository.listarPorNomeCliente('%' + nome + '%');
	}
}
