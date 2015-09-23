package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the receita_produto database table.
 * 
 */
@Entity
@Table(name="receita_produto")
@NamedQuery(name="ReceitaProduto.findAll", query="SELECT r FROM ReceitaProduto r")
public class ReceitaProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String observacao;

	@ManyToOne
	private Receita receita;
	
	@Column(name="produto_id")
	private Integer produtoId;
	
	@Transient
	private Produto produto;
	
	private short quantidade;
	
	private Double comensal;
	
	private Double percapta;
	
	private Double total;
	
	private Double custo;
	
	private Double calorias;
	
	public ReceitaProduto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public short getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(short quantidade) {
		this.quantidade = quantidade;
	}

	public Receita getReceita() {
		return this.receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getComensal() {
		return comensal;
	}

	public void setComensal(Double comensal) {
		this.comensal = comensal;
	}

	public Double getPercapta() {
		return percapta;
	}

	public void setPercapta(Double percapta) {
		this.percapta = percapta;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

}