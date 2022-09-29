package br.fatec.financas.model;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
//import javax.persistence.Table;

//@Table(name="tb_conta")
@Entity
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	//@Column(name="nr_agencia", nullable = false)
	private Integer agencia;
	
	//@Column(name="nr_numero", nullable = false)
	private String numero;
	
	//@Column(name="vl_saldo")
	private Float saldo;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "conta_id") //relacionamento unidirecional (sem tabela extra)
	private List<Movimentacao> movimentacao;
	
	public Conta() { }
	
	// getters e setters
	@JsonIgnore
	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}

	@JsonProperty
	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}	
}
