package br.fatec.financas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.financas.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	List<Conta> listarPorAgencia(Integer agencia);
	List<Conta> listarPorAgenciaESaldo(Integer agencia, Float from, Float to);
	List<Conta> listarPorNomeCliente(String nome);
}
