package br.fatec.financas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pessoa Jurídica")
public class PessoaJuridica extends Cliente {
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	private String ramoAtividade;
	
	public PessoaJuridica() { }

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
