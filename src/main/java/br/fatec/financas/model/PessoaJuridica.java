package br.fatec.financas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Pessoa Jurídica")
@Getter
@Setter
@NoArgsConstructor
public class PessoaJuridica extends Cliente {
	private static final long serialVersionUID = 1L;
	
	@CNPJ
	private String cnpj;
	
	@NotBlank
	@Size(min = 4, max = 20)
	private String ramoAtividade;
}
