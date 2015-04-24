package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the receita_cardapio_his database table.
 * 
 */
@Entity
@Table(name="receita_cardapio_his")
@NamedQuery(name="ReceitaCardapioHi.findAll", query="SELECT r FROM ReceitaCardapioHi r")
public class ReceitaCardapioHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	private String descricao;

	@Column(name="pessoa_id")
	private int pessoaId;

	@Column(name="receita_origem")
	private int receitaOrigem;

	private String resumo;

	@Column(name="servico_id")
	private int servicoId;

	@Column(name="tempo_medio")
	private String tempoMedio;

	@Column(name="tipo_receita")
	private int tipoReceita;

	//bi-directional many-to-one association to Cardapio
	@ManyToOne
	private Cardapio cardapio;

	public ReceitaCardapioHi() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataalteracao() {
		return this.dataalteracao;
	}

	public void setDataalteracao(Date dataalteracao) {
		this.dataalteracao = dataalteracao;
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

	public int getReceitaOrigem() {
		return this.receitaOrigem;
	}

	public void setReceitaOrigem(int receitaOrigem) {
		this.receitaOrigem = receitaOrigem;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
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

	public int getTipoReceita() {
		return this.tipoReceita;
	}

	public void setTipoReceita(int tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Cardapio getCardapio() {
		return this.cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

}