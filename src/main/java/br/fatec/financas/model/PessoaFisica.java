package br.fatec.financas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pessoa Física")
public class PessoaFisica extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String profissao;
	
	public PessoaFisica() { }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
