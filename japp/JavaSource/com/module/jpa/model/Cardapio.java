package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cardapio database table.
 * 
 */
@Entity
@NamedQuery(name="Cardapio.findAll", query="SELECT c FROM Cardapio c")
public class Cardapio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="cardapio_origem")
	private int cardapioOrigem;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataexecucao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	private String descricao;

	@Column(name="pessoa_id")
	private int pessoaId;

	@Column(name="servico_id")
	private int servicoId;

	@Column(name="tempo_medio")
	private String tempoMedio;

	@Column(name="tipo_cardapio")
	private int tipoCardapio;

	//bi-directional many-to-one association to CardapioReceita
	@OneToMany(mappedBy="cardapio")
	private List<CardapioReceita> cardapioReceitas;

	//bi-directional many-to-one association to ReceitaCardapioHi
	@OneToMany(mappedBy="cardapio")
	private List<ReceitaCardapioHi> receitaCardapioHis;

	public Cardapio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCardapioOrigem() {
		return this.cardapioOrigem;
	}

	public void setCardapioOrigem(int cardapioOrigem) {
		this.cardapioOrigem = cardapioOrigem;
	}

	public Date getDataalteracao() {
		return this.dataalteracao;
	}

	public void setDataalteracao(Date dataalteracao) {
		this.dataalteracao = dataalteracao;
	}

	public Date getDataexecucao() {
		return this.dataexecucao;
	}

	public void setDataexecucao(Date dataexecucao) {
		this.dataexecucao = dataexecucao;
	}

	public Date getDatainclusao() {
		return this.datainclusao;
	}

	public void setDatainclusao(Date datainclusao) {
		this.datainclusao = datainclusao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPessoaId() {
		return this.pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public int getServicoId() {
		return this.servicoId;
	}

	public void setServicoId(int servicoId) {
		this.servicoId = servicoId;
	}

	public String getTempoMedio() {
		return this.tempoMedio;
	}

	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public int getTipoCardapio() {
		return this.tipoCardapio;
	}

	public void setTipoCardapio(int tipoCardapio) {
		this.tipoCardapio = tipoCardapio;
	}

	public List<CardapioReceita> getCardapioReceitas() {
		return this.cardapioReceitas;
	}

	public void setCardapioReceitas(List<CardapioReceita> cardapioReceitas) {
		this.cardapioReceitas = cardapioReceitas;
	}

	public CardapioReceita addCardapioReceita(CardapioReceita cardapioReceita) {
		getCardapioReceitas().add(cardapioReceita);
		cardapioReceita.setCardapio(this);

		return cardapioReceita;
	}

	public CardapioReceita removeCardapioReceita(CardapioReceita cardapioReceita) {
		getCardapioReceitas().remove(cardapioReceita);
		cardapioReceita.setCardapio(null);

		return cardapioReceita;
	}

	public List<ReceitaCardapioHi> getReceitaCardapioHis() {
		return this.receitaCardapioHis;
	}

	public void setReceitaCardapioHis(List<ReceitaCardapioHi> receitaCardapioHis) {
		this.receitaCardapioHis = receitaCardapioHis;
	}

	public ReceitaCardapioHi addReceitaCardapioHi(ReceitaCardapioHi receitaCardapioHi) {
		getReceitaCardapioHis().add(receitaCardapioHi);
		receitaCardapioHi.setCardapio(this);

		return receitaCardapioHi;
	}

	public ReceitaCardapioHi removeReceitaCardapioHi(ReceitaCardapioHi receitaCardapioHi) {
		getReceitaCardapioHis().remove(receitaCardapioHi);
		receitaCardapioHi.setCardapio(null);

		return receitaCardapioHi;
	}

}