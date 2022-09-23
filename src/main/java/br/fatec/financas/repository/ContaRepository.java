package br.fatec.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.financas.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	
}
