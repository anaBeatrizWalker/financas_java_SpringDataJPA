package br.fatec.financas.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T> {
	T create(T obj);
	T findById(Long id);
	List<T> findAll();
	Page<T> findAllPaginated(Pageable pageable);
	boolean update(T obj);
	boolean delete(Long id);
}
