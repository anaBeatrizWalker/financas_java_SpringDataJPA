package br.fatec.financas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T> {
	T create(T obj);
	T findById(Long id);
	Page<T> findAll(Pageable pageable);
	boolean update(T obj);
	boolean delete(Long id);
}
