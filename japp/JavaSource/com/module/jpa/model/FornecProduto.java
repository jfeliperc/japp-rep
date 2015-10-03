package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fornec_produto database table.
 * 
 */
@Entity
@Table(name="fornec_produto")
@NamedQuery(name="FornecProduto.findAll", query="SELECT f FROM FornecProduto f")
public class FornecProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	@ManyToOne
	private Produto produto;

	public FornecProduto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}