package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the valor_produto database table.
 * 
 */
@Entity
@Table(name="valor_produto")
@NamedQuery(name="ValorProduto.findAll", query="SELECT v FROM ValorProduto v")
public class ValorProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_referencia")
	private Date dataReferencia;

	@Column(name="valor_compra")
	private double valorCompra;

	@Column(name="valor_venda")
	private double valorVenda;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	private Produto produto;

	public ValorProduto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataReferencia() {
		return this.dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}

	public double getValorCompra() {
		return this.valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorVenda() {
		return this.valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}