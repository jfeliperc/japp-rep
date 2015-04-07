package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orcamento database table.
 * 
 */
@Entity
@NamedQuery(name="Orcamento.findAll", query="SELECT o FROM Orcamento o")
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String dataalteracao;

	private String dataconclusao;

	private String datainclusao;

	private String datasolicitacao;

	private String datavalidade;

	private String descricao;

	private String garantia;

	private String numero;

	private String tipoorcamento;

	private String valormaoobra;

	private String valortotal;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	private Pessoa pessoa;

	//bi-directional many-to-many association to Produto
	@ManyToMany
	@JoinTable(
		name="orcamento_produto"
		, joinColumns={
			@JoinColumn(name="orcamento_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="produto_id")
			}
		)
	private List<Produto> produtos;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	private Servico servico;

	public Orcamento() {
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

	public String getDataconclusao() {
		return this.dataconclusao;
	}

	public void setDataconclusao(String dataconclusao) {
		this.dataconclusao = dataconclusao;
	}

	public String getDatainclusao() {
		return this.datainclusao;
	}

	public void setDatainclusao(String datainclusao) {
		this.datainclusao = datainclusao;
	}

	public String getDatasolicitacao() {
		return this.datasolicitacao;
	}

	public void setDatasolicitacao(String datasolicitacao) {
		this.datasolicitacao = datasolicitacao;
	}

	public String getDatavalidade() {
		return this.datavalidade;
	}

	public void setDatavalidade(String datavalidade) {
		this.datavalidade = datavalidade;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGarantia() {
		return this.garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoorcamento() {
		return this.tipoorcamento;
	}

	public void setTipoorcamento(String tipoorcamento) {
		this.tipoorcamento = tipoorcamento;
	}

	public String getValormaoobra() {
		return this.valormaoobra;
	}

	public void setValormaoobra(String valormaoobra) {
		this.valormaoobra = valormaoobra;
	}

	public String getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(String valortotal) {
		this.valortotal = valortotal;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}