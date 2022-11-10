package br.fatec.financas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@Getter
@Setter
@NoArgsConstructor
public abstract class Cliente extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String endereco;
	
	@ToString.Exclude
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(unique = true)
	private Conta conta;
}
