package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estoque database table.
 * 
 */
@Entity
@NamedQuery(name="Estoque.findAll", query="SELECT e FROM Estoque e")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String datacontagem;

	private String dataultimofechamento;

	@Column(name="pessoa_id")
	private int pessoaId;

	private String quantidade;
	
	@Column(name="custo_medio")
	private Double custoMedio;

	private String status;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	private Produto produto;

	public Estoque() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatacontagem() {
		return this.datacontagem;
	}

	public void setDatacontagem(String datacontagem) {
		this.datacontagem = datacontagem;
	}

	public String getDataultimofechamento() {
		return this.dataultimofechamento;
	}

	public void setDataultimofechamento(String dataultimofechamento) {
		this.dataultimofechamento = dataultimofechamento;
	}

	public int getPessoaId() {
		return this.pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getCustoMedio() {
		return custoMedio;
	}

	public void setCustoMedio(Double custoMedio) {
		this.custoMedio = custoMedio;
	}

}