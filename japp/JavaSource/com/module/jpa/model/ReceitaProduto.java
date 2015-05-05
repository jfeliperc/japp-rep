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
	private int id;

	private String observacao;

	@Column(name="produto_id")
	private int produtoId;

	private short quantidade;

	//bi-directional many-to-one association to Receita
	@ManyToOne
	private Receita receita;

	public ReceitaProduto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
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

}