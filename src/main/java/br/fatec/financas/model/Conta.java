package br.fatec.financas.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Table;

//@Table(name="tb_conta")
@Entity
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	//@Column(name="nr_agencia", nullable = false)
	private Integer agencia;
	
	//@Column(name="nr_numero", nullable = false)
	private String numero;
	
	//@Column(name="nm_titular", length = 100)
	private String titular;
	
	//@Column(name="vl_saldo")
	private Float saldo;
	
	public Conta() { }
	
	// getters e setters
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

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}	
}
