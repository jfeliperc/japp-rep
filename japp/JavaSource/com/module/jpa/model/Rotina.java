package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;

import java.util.List;


/**
 * The persistent class for the rotina database table.
 * 
 */
@Entity
@Table(name="rotina")
@NamedQuery(name="Rotina.findAll", query="SELECT r FROM Rotina r")
public class Rotina implements Serializable, IGenericModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descricao;

	private String rotina;

	@Column(name="rotina_pai")
	private Integer rotinaPai;

	private int status;

	//bi-directional many-to-one association to Acesso
	@OneToMany(mappedBy="rotina1")
	private List<Acesso> acessos1;

	//bi-directional many-to-one association to Acesso
	@OneToMany(mappedBy="rotina2")
	private List<Acesso> acessos2;

	public Rotina() {
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

	public String getRotina() {
		return this.rotina;
	}

	public void setRotina(String rotina) {
		this.rotina = rotina;
	}

	public Integer getRotinaPai() {
		return this.rotinaPai;
	}

	public void setRotinaPai(Integer rotinaPai) {
		this.rotinaPai = rotinaPai;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Acesso> getAcessos1() {
		return this.acessos1;
	}

	public void setAcessos1(List<Acesso> acessos1) {
		this.acessos1 = acessos1;
	}

	public Acesso addAcessos1(Acesso acessos1) {
		getAcessos1().add(acessos1);
		acessos1.setRotina1(this);

		return acessos1;
	}

	public Acesso removeAcessos1(Acesso acessos1) {
		getAcessos1().remove(acessos1);
		acessos1.setRotina1(null);

		return acessos1;
	}

	public List<Acesso> getAcessos2() {
		return this.acessos2;
	}

	public void setAcessos2(List<Acesso> acessos2) {
		this.acessos2 = acessos2;
	}

	public Acesso addAcessos2(Acesso acessos2) {
		getAcessos2().add(acessos2);
		acessos2.setRotina2(this);

		return acessos2;
	}

	public Acesso removeAcessos2(Acesso acessos2) {
		getAcessos2().remove(acessos2);
		acessos2.setRotina2(null);

		return acessos2;
	}

}