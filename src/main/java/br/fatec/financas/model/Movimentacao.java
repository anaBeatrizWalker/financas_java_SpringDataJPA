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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Movimentacao extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	private Float valor;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Calendar data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Conta conta;
	
	@ManyToMany
	@JoinTable(name = "tb_movimentacao_categoria",
				joinColumns=@JoinColumn(name = "FK_movimentacao_id"),
				inverseJoinColumns=@JoinColumn(name = "FK_categoria_id"))
	private List<Categoria> categoria;
	
	public Movimentacao() {}

	@JsonIgnore
	public Conta getConta() {
		return conta;
	}
	
	@JsonProperty
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	@JsonIgnore
	public List<Categoria> getCategoria() {
		return categoria;
	}
	
	@JsonProperty
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
