package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;


/**
 * The persistent class for the contato database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Contato.findAll", query="SELECT c FROM Contato c"),
	@NamedQuery(name="Contato.findByPessoaAll", query="SELECT c FROM Contato c WHERE c.pessoa.id = :idPessoa"),
	@NamedQuery(name="Contato.removeByPessoaAll", query="DELETE FROM Contato c WHERE c.pessoa.id = :idPessoa")})
public class Contato implements Serializable, IGenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descricao;

	private String tipo;

	@ManyToOne
	private Pessoa pessoa;

	public Contato() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}