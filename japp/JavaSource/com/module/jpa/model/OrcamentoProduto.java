package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orcamento_produto database table.
 * 
 */
@Entity
@Table(name="orcamento_produto")
@NamedQuery(name="OrcamentoProduto.findAll", query="SELECT o FROM OrcamentoProduto o")
public class OrcamentoProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrcamentoProdutoPK id;

	public OrcamentoProduto() {
	}

	public OrcamentoProdutoPK getId() {
		return this.id;
	}

	public void setId(OrcamentoProdutoPK id) {
		this.id = id;
	}

}