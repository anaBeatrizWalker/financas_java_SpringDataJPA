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

	@Column(length = 50)
	private String nome;
}