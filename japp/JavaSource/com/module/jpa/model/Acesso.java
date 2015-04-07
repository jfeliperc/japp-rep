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

	@Column(name="rotina_master")
	private int rotinaMaster;

	@Column(name="rotina_slave")
	private int rotinaSlave;

	private int status;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	private Pessoa pessoa;

	public Acesso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRotinaMaster() {
		return this.rotinaMaster;
	}

	public void setRotinaMaster(int rotinaMaster) {
		this.rotinaMaster = rotinaMaster;
	}

	public int getRotinaSlave() {
		return this.rotinaSlave;
	}

	public void setRotinaSlave(int rotinaSlave) {
		this.rotinaSlave = rotinaSlave;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}