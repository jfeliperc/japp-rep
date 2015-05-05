package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipo_produto database table.
 * 
 */
@Entity
@Table(name="tipo_produto")
@NamedQuery(name="TipoProduto.findAll", query="SELECT t FROM TipoProduto t")
public class TipoProduto implements Serializable, IGenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="tipoProduto")
	private List<Produto> produtos;

	public TipoProduto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setTipoProduto(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setTipoProduto(null);

		return produto;
	}

}