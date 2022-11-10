package br.fatec.financas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
	
	private String cnpj;
	private String ramoAtividade;
}
