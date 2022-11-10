package br.fatec.financas.model;

import java.util.List; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Integer agencia;
	
	@Getter @Setter
	private String numero;
	
	@ToString.Exclude
	private Float saldo;
	
	@Getter @Setter
	@ToString.Exclude
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "conta") //Movimentacao é a dona do relacionamento e contém o atributo conta
	private List<Movimentacao> movimentacao;
	
	//Getter e setter de saldo
	public Float getSaldo() {
		return saldo;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
}
