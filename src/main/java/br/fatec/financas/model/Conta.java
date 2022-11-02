package br.fatec.financas.model;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Table(name="tb_conta")
@Entity
@NamedQueries({
	@NamedQuery(name="Conta.listarPorAgencia", query="select c from Conta c where c.agencia=?1"), 
	@NamedQuery(name="Conta.listarPorAgenciaESaldo", query="select c from Conta c where c.agencia=?1 and" + " c.saldo between ?2 and ?3"),
	@NamedQuery(name="Conta.listarPorNomeCliente", query="select c from Conta c join Cliente cc on" + " cc.conta = c where cc.nome like ?1")
}) 
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	//@Column(name="nr_agencia", nullable = false)
	private Integer agencia;
	
	//@Column(name="nr_numero", nullable = false)
	private String numero;
	
	//@Column(name="vl_saldo")
	private Float saldo;
	
	//Relacionamento bidirecional
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "conta") //Movimentacao é a dona do relacionamento e contém o atributo conta
	private List<Movimentacao> movimentacao;
	
	public Conta() { }
	
	// getters e setters
	//@JsonIgnore
	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}

	//@JsonProperty
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
