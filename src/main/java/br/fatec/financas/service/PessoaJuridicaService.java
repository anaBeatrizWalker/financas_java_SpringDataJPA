package br.fatec.financas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.fatec.financas.model.PessoaJuridica;
import br.fatec.financas.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService implements ServiceInterface<PessoaJuridica> {
		@Autowired
		private PessoaJuridicaRepository repository;
		
		public PessoaJuridicaService() {}
		
		@Override
		public PessoaJuridica create(PessoaJuridica pessoa_juridica) {
			repository.save(pessoa_juridica);
			return pessoa_juridica;
		}
		
		@Override
		public List<PessoaJuridica> findAll(){
			return (List<PessoaJuridica>) repository.findAll();
		}
		
		@Override
		public Page<PessoaJuridica> findAllPaginated(Pageable pageable){
			return repository.findAll(pageable);
		}
		
		@Override
		public PessoaJuridica findById(Long id) {
			Optional<PessoaJuridica> pessoa_juridica = repository.findById(id);
			return pessoa_juridica.orElse(null);
		}
		
		public boolean update(PessoaJuridica pessoa_juridica) {
			if(repository.existsById(pessoa_juridica.getId())) {
				repository.save(pessoa_juridica);
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