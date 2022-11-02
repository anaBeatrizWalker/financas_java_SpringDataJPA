package br.fatec.financas.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.fatec.financas.model.PessoaFisica;
import br.fatec.financas.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService implements ServiceInterface<PessoaFisica> {
		@Autowired
		private PessoaFisicaRepository repository;
		
		public PessoaFisicaService() {}
		
		@Override
		public PessoaFisica create(PessoaFisica pessoa_fisica) {
			repository.save(pessoa_fisica);
			return pessoa_fisica;
		}
		
		@Override
		public List<PessoaFisica> findAll(){
			return (List<PessoaFisica>) repository.findAll();
		}
		
		@Override
		public Page<PessoaFisica> findAllPaginated(Pageable pageable){
			return repository.findAll(pageable);
		}
		
		@Override
		public PessoaFisica findById(Long id) {
			Optional<PessoaFisica> pessoa_fisica = repository.findById(id);
			return pessoa_fisica.orElse(null);
		}
		
		public boolean update(PessoaFisica pessoa_fisica) {
			if(repository.existsById(pessoa_fisica.getId())) {
				repository.save(pessoa_fisica);
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
}