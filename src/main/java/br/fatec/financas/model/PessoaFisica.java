package br.fatec.financas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("Pessoa Física")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class PessoaFisica extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String profissao;
}
