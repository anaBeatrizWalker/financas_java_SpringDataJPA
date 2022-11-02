package br.fatec.financas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.fatec.financas.model.PessoaFisica;

public interface PessoaFisicaRepository extends PagingAndSortingRepository<PessoaFisica, Long> {

}
