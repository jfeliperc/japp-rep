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
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT a FROM Servico a"),
    @NamedQuery(name = "Servico.findById", query = "SELECT a FROM Servico a WHERE a.id = :id"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT a FROM Servico a WHERE a.descricao = :descricao"),    
    @NamedQuery(name = "Servico.findByNome", query = "SELECT a FROM Servico a WHERE a.nome = :nome")})
public class Servico implements Serializable {
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

	@OneToMany(mappedBy="servico")
	private List<AtividadeServico> atividadeServicos;

	@OneToMany(mappedBy="servico")
	private List<ClienteServico> clienteServicos;
	
	@OneToMany(mappedBy="servico")
	private List<Orcamento> orcamentos;

	@OneToMany(mappedBy="servico")
	private List<Atividade> atividades;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	@Transient
	private List<Cliente> clientes;
	
	public Servico() {
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

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
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


	public List<ClienteServico> getClienteServicos() {
		return this.clienteServicos;
	}

	public void setClienteServicos(List<ClienteServico> clienteServicos) {
		this.clienteServicos = clienteServicos;
	}

	public ClienteServico addClienteServico(ClienteServico clienteServicos) {
		getClienteServicos().add(clienteServicos);
		clienteServicos.setServico(this);

		return clienteServicos;
	}

	public ClienteServico removeClienteServico(ClienteServico clienteServicos) {
		getClienteServicos().remove(clienteServicos);
		clienteServicos.setServico(null);

		return clienteServicos;
	}

	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}