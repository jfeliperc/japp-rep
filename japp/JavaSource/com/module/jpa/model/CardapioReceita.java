package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cardapio_receita database table.
 * 
 */
@Entity
@Table(name="cardapio_receita")
@NamedQuery(name="CardapioReceita.findAll", query="SELECT c FROM CardapioReceita c")
public class CardapioReceita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String observacao;

	private short quantidade;

	@Column(name="receita_id")
	private int receitaId;

	//bi-directional many-to-one association to Cardapio
	@ManyToOne
	private Cardapio cardapio;

	public CardapioReceita() {
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

	public Cardapio getCardapio() {
		return this.cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

}