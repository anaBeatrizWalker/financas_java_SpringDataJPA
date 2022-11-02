package br.fatec.financas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.fatec.financas.model.Conta;

@Repository
public interface ContaRepository extends PagingAndSortingRepository<Conta, Long>{
	List<Conta> findByAgencia(Integer agencia);
	
	List<Conta> findByAgenciaAndSaldoBetween(Integer agencia, Float from, Float to);
	
	@Query("select c from Conta c join Cliente cc on " + "cc.conta = c where cc.nome like ?1")
	List<Conta> listarPorNomeCliente(String nome);
}
