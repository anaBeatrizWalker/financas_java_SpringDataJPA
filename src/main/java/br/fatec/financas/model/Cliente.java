package br.fatec.financas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@NotBlank
	@Size(min = 4, max = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 5, max = 100)
	private String endereco;
	
	@ToString.Exclude
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(unique = true)
	private Conta conta;
}
