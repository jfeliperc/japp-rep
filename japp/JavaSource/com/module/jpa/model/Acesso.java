package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the acesso database table.
 * 
 */
@Entity
@NamedQuery(name="Acesso.findAll", query="SELECT a FROM Acesso a")
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	private Pessoa pessoa;

	private int status;

	//bi-directional many-to-one association to Rotina
	@ManyToOne
	@JoinColumn(name="rotina_master")
	private Rotina rotina1;

	//bi-directional many-to-one association to Rotina
	@ManyToOne
	@JoinColumn(name="rotina_slave")
	private Rotina rotina2;

	public Acesso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Rotina getRotina1() {
		return this.rotina1;
	}

	public void setRotina1(Rotina rotina1) {
		this.rotina1 = rotina1;
	}

	public Rotina getRotina2() {
		return this.rotina2;
	}

	public void setRotina2(Rotina rotina2) {
		this.rotina2 = rotina2;
	}

}