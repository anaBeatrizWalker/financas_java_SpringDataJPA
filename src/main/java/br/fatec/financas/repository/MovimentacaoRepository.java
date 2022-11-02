package br.fatec.financas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.fatec.financas.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends PagingAndSortingRepository<Movimentacao, Long> {

}
