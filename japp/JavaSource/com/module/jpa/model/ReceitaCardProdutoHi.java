package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the receita_card_produto_his database table.
 * 
 */
@Entity
@Table(name="receita_card_produto_his")
@NamedQuery(name="ReceitaCardProdutoHi.findAll", query="SELECT r FROM ReceitaCardProdutoHi r")
public class ReceitaCardProdutoHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String observacao;

	@Column(name="produto_id")
	private int produtoId;

	private short quantidade;

	@Column(name="receita_id")
	private int receitaId;

	public ReceitaCardProdutoHi() {
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

	public int getReceitaId() {
		return this.receitaId;
	}

	public void setReceitaId(int receitaId) {
		this.receitaId = receitaId;
	}

}