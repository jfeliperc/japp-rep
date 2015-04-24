package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orcamento_produto database table.
 * 
 */
@Embeddable
public class OrcamentoProdutoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="orcamento_id", insertable=false, updatable=false)
	private int orcamentoId;

	@Column(name="produto_id", insertable=false, updatable=false)
	private int produtoId;

	public OrcamentoProdutoPK() {
	}
	public int getOrcamentoId() {
		return this.orcamentoId;
	}
	public void setOrcamentoId(int orcamentoId) {
		this.orcamentoId = orcamentoId;
	}
	public int getProdutoId() {
		return this.produtoId;
	}
	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrcamentoProdutoPK)) {
			return false;
		}
		OrcamentoProdutoPK castOther = (OrcamentoProdutoPK)other;
		return 
			(this.orcamentoId == castOther.orcamentoId)
			&& (this.produtoId == castOther.produtoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orcamentoId;
		hash = hash * prime + this.produtoId;
		
		return hash;
	}
}