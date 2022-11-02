package br.fatec.financas.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
	ResponseEntity<Page<T>> getAll(Pageable pageable);
	ResponseEntity<?> get(Long id);
	ResponseEntity<T> post(T obj);
	ResponseEntity<?> put(T obj);
	ResponseEntity<?> delete(Long id);
}
