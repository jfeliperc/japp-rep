package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the atividade_servico database table.
 * 
 */
@Entity
@Table(name="cliente_servico")
@NamedQueries({
    @NamedQuery(name = "ClienteServico.findAll", query = "SELECT a FROM ClienteServico a"),
    @NamedQuery(name = "ClienteServico.findById", query = "SELECT a FROM ClienteServico a WHERE a.id = :id"),
    @NamedQuery(name = "ClienteServico.findByCliente", query = "SELECT a FROM ClienteServico a WHERE a.cliente.id = :id"),    
    @NamedQuery(name = "ClienteServico.findByServico", query = "SELECT a FROM ClienteServico a WHERE a.servico.id = :id")})

public class ClienteServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Servico servico;

	public ClienteServico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}