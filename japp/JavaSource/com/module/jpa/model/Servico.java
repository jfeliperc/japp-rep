package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servico database table.
 * 
 */
@Entity
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to AtividadeServico
	@OneToMany(mappedBy="servico")
	private List<AtividadeServico> atividadeServicos;

	//bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy="servico")
	private List<Orcamento> orcamentos;

	public Servico() {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AtividadeServico> getAtividadeServicos() {
		return this.atividadeServicos;
	}

	public void setAtividadeServicos(List<AtividadeServico> atividadeServicos) {
		this.atividadeServicos = atividadeServicos;
	}

	public AtividadeServico addAtividadeServico(AtividadeServico atividadeServico) {
		getAtividadeServicos().add(atividadeServico);
		atividadeServico.setServico(this);

		return atividadeServico;
	}

	public AtividadeServico removeAtividadeServico(AtividadeServico atividadeServico) {
		getAtividadeServicos().remove(atividadeServico);
		atividadeServico.setServico(null);

		return atividadeServico;
	}

	public List<Orcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Orcamento addOrcamento(Orcamento orcamento) {
		getOrcamentos().add(orcamento);
		orcamento.setServico(this);

		return orcamento;
	}

	public Orcamento removeOrcamento(Orcamento orcamento) {
		getOrcamentos().remove(orcamento);
		orcamento.setServico(null);

		return orcamento;
	}

}