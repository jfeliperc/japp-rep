package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the receita database table.
 * 
 */
@Entity
@NamedQuery(name="Receita.findAll", query="SELECT r FROM Receita r")
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String dataalteracao;

	private String datainclusao;

	private String descricao;

	@Column(name="pessoa_id")
	private int pessoaId;

	private String resumo;

	@ManyToOne(fetch = FetchType.LAZY) 
	private Servico servico;

	@Column(name="tempo_medio")
	private String tempoMedio;

	@OneToMany(mappedBy="receita")
	private List<ReceitaProduto> receitaProdutos;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="tipo_receita_id")
	private TipoReceita tipoReceita;

	@Column(name="calorias")
	private Double calorias;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	public Receita() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataalteracao() {
		return this.dataalteracao;
	}

	public void setDataalteracao(String dataalteracao) {
		this.dataalteracao = dataalteracao;
	}

	public String getDatainclusao() {
		return this.datainclusao;
	}

	public void setDatainclusao(String datainclusao) {
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

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getTempoMedio() {
		return this.tempoMedio;
	}

	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public List<ReceitaProduto> getReceitaProdutos() {
		return this.receitaProdutos;
	}

	public void setReceitaProdutos(List<ReceitaProduto> receitaProdutos) {
		this.receitaProdutos = receitaProdutos;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	public ReceitaProduto addReceitaProduto(ReceitaProduto receitaProduto) {
		getReceitaProdutos().add(receitaProduto);
		receitaProduto.setReceita(this);

		return receitaProduto;
	}

	public ReceitaProduto removeReceitaProduto(ReceitaProduto receitaProduto) {
		getReceitaProdutos().remove(receitaProduto);
		receitaProduto.setReceita(null);

		return receitaProduto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}