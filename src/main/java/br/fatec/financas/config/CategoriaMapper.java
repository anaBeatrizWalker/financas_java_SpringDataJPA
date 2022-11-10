package br.fatec.financas.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.fatec.financas.dto.CategoriaDTO;
import br.fatec.financas.model.Categoria;
import lombok.NoArgsConstructor;

@Component 
@NoArgsConstructor 
public class CategoriaMapper { 
	public Categoria toEntity(CategoriaDTO categoriaDTO) { 
		Categoria categoria = new Categoria(); 
		categoria.setId(categoriaDTO.getId()); 
		categoria.setNome(categoriaDTO.getNome()); 
		return categoria; 
	}
	
	public CategoriaDTO toDTO(Categoria categoria) { 
		CategoriaDTO categoriaDTO = new CategoriaDTO(); 
		categoriaDTO.setId(categoria.getId()); 
		categoriaDTO.setNome(categoria.getNome()); 
		return categoriaDTO; 
	} 
	
	public List<CategoriaDTO> toDTO(List<Categoria> categorias) { 
		return categorias.stream().map(this::toDTO).collect(Collectors.toList()); 
	} 
	
	public List<Categoria> toEntity(List<CategoriaDTO> categoriasDTO){ 
		return categoriasDTO.stream().map(this::toEntity).collect(Collectors.toList()); 
	} 
}