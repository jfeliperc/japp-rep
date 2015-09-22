package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atividade_servico database table.
 * 
 */
@Entity
@Table(name="atividade_servico")
@NamedQuery(name="AtividadeServico.findAll", query="SELECT a FROM AtividadeServico a")
public class AtividadeServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//bi-directional many-to-one association to Atividade
	@ManyToOne
	private Atividade atividade;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	private Servico servico;

	public AtividadeServico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}