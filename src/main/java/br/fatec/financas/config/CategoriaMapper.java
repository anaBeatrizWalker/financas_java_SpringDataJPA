package br.fatec.financas.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.fatec.financas.dto.CategoriaDTO;
import br.fatec.financas.model.Categoria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CategoriaMapper {
	private ModelMapper modelMapper;
	
	public Categoria toEntity(CategoriaDTO categoriaDTO) {
		return modelMapper.map(categoriaDTO, Categoria.class);
	}
	
	public CategoriaDTO toDTO(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaDTO.class);
	}
	
	public List<CategoriaDTO> toDTO(List<Categoria> categorias) { 
		return categorias.stream().map(this::toDTO).collect(Collectors.toList()); 
	} 
	
	public List<Categoria> toEntity(List<CategoriaDTO> categoriasDTO){ 
		return categoriasDTO.stream().map(this::toEntity).collect(Collectors.toList()); 
	} 
}