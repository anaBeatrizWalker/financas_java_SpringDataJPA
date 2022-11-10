package br.fatec.financas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
	
	@CPF
	private String cpf;
	
	@NotBlank
	@Size(min = 4, max = 20)
	private String profissao;
}
