package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the atividade database table.
 * 
 */
@Entity
@NamedQuery(name="Atividade.findAll", query="SELECT a FROM Atividade a")
public class Atividade implements Serializable {
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

	@ManyToOne
	@JoinColumn(name="tipo_atividade_id")
	private TipoAtividade tipoAtividade;

	@OneToMany(mappedBy="atividade")
	private List<AtividadeServico> atividadeServicos;

	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	public Atividade() {
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

	public TipoAtividade getTipoAtividade() {
		return this.tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<AtividadeServico> getAtividadeServicos() {
		return this.atividadeServicos;
	}

	public void setAtividadeServicos(List<AtividadeServico> atividadeServicos) {
		this.atividadeServicos = atividadeServicos;
	}

	public AtividadeServico addAtividadeServico(AtividadeServico atividadeServico) {
		getAtividadeServicos().add(atividadeServico);
		atividadeServico.setAtividade(this);

		return atividadeServico;
	}

	public AtividadeServico removeAtividadeServico(AtividadeServico atividadeServico) {
		getAtividadeServicos().remove(atividadeServico);
		atividadeServico.setAtividade(null);

		return atividadeServico;
	}

}