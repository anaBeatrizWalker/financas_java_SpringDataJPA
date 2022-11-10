package br.fatec.financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categoria extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	//Validação do banco de dados
	@Column(length = 50, nullable=false)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}