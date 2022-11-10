package br.fatec.financas.model;

import java.util.Calendar; 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Movimentacao extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@ToString.Exclude
	private Float valor;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	
	private String descricao;
	
	@ToString.Exclude
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Calendar data;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	private Conta conta;
	
	@ToString.Exclude
	@ManyToMany
	@JoinTable(name = "tb_movimentacao_categoria",
				joinColumns=@JoinColumn(name = "FK_movimentacao_id"),
				inverseJoinColumns=@JoinColumn(name = "FK_categoria_id"))
	private List<Categoria> categoria;
}
