package br.fatec.financas.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.financas.config.CategoriaMapper;
import br.fatec.financas.dto.CategoriaDTO;
import br.fatec.financas.model.Categoria;
import br.fatec.financas.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController implements ControllerInterface<CategoriaDTO> {
	@Autowired
	private CategoriaService service;
	
	@Autowired
	private CategoriaMapper mapper;

	@Override
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getAll() {
		return ResponseEntity.ok(mapper.toDTO(service.findAll()));
	}
	
	/*
	@GetMapping(value = "/page") 
	public ResponseEntity<Page<Categoria>> getAllPaginated(Pageable pageable){
		return ResponseEntity.ok(service.findAllPaginated(pageable));
	}
	
	Page<Categoria> entities = objectEntityRepository.findAll(pageable);
	Page<CategoriaDTO> dtoPage = entities.map(new Function<Categoria, CategoriaDTO>() {
		@Override
		public CategoriaDTO apply(Categoria entity) {
			return mapper.toDTO(entity);
		}
	});
	*/
	
	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> get(@PathVariable("id") Long id) {
		Categoria categoria = service.findById(id);
		if (categoria != null)
			return ResponseEntity.ok(mapper.toDTO(obj));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<CategoriaDTO> post(@Valid @RequestBody CategoriaDTO obj) {
		Categoria categoria = service.create(mapper.toEntity(obj));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(location).body(mapper.toDTO(categoria));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@Valid @RequestBody CategoriaDTO obj) {
		if (service.update(mapper.toEntity(obj))) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}