package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipo_receita database table.
 * 
 */
@Entity
@Table(name="tipo_receita")
@NamedQuery(name="TipoReceita.findAll", query="SELECT t FROM TipoReceita t")
public class TipoReceita implements Serializable, IGenericModel {
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

	//bi-directional many-to-one association to Receita
	@OneToMany(mappedBy="tipoReceita")
	private List<Receita> receitas;

	public TipoReceita() {
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

	public List<Receita> getReceitas() {
		return this.receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public Receita addReceita(Receita receita) {
		getReceitas().add(receita);
		receita.setTipoReceita(this);

		return receita;
	}

	public Receita removeReceita(Receita receita) {
		getReceitas().remove(receita);
		receita.setTipoReceita(null);

		return receita;
	}

}