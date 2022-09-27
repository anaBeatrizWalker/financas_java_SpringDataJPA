package br.fatec.financas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String endereco;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(unique = true) //um cliente associado a somente uma conta
	private Conta conta;
	
	public Cliente() { }

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
