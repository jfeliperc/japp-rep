package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_pessoa database table.
 * 
 */
@Entity
@Table(name="tipo_pessoa")
@NamedQuery(name="TipoPessoa.findAll", query="SELECT t FROM TipoPessoa t")
public class TipoPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="tipoPessoaBean")
	private List<Pessoa> pessoas;

	public TipoPessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setTipoPessoaBean(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setTipoPessoaBean(null);

		return pessoa;
	}

}