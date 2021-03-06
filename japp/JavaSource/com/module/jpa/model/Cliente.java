package com.module.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;


/**
 * The persistent class for the agente_externo database table.
 * 
 */
@Entity
//@Table(name="cliente")

@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT a FROM Cliente a"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT a FROM Cliente a WHERE a.id = :id"),
    @NamedQuery(name = "Cliente.findByTipo", query = "SELECT a FROM Cliente a WHERE a.tipo = :tipo"),    
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT a FROM Cliente a WHERE a.nome = :nome")})

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String ativo;

	private String cnpj;

	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datanascimento;

	private String documento;

	@Column(name="inscricao_est")
	private String inscricaoEst;

	@Column(name="inscricao_mun")
	private String inscricaoMun;

	private String nome;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	private String nomecompleto;

	private String observacao;

	@Column(name="razao_social")
	private String razaoSocial;

	private String tipo;

	@Column(name="tipo_pessoa")
	private String tipoPessoa;

	private String tipodocumento;

	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="empresa_id")
	private Empresa empresa;

	@OneToMany(mappedBy="servico")
	private List<ClienteServico> clienteServicos;
	
	@Transient
	private List<Servico> servicos;
	
	//@OneToMany(mappedBy="cliente")
	//private List<Servico> servicos;

	//@OneToMany(mappedBy="cliente")
	//private List<Pedido> pedidos;

	public Cliente() {
		this.tipoPessoa = "PF";
		
		if (this.empresa == null){
			this.empresa = new Empresa();
		}
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Date getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getInscricaoEst() {
		return this.inscricaoEst;
	}

	public void setInscricaoEst(String inscricaoEst) {
		this.inscricaoEst = inscricaoEst;
	}

	public String getInscricaoMun() {
		return this.inscricaoMun;
	}

	public void setInscricaoMun(String inscricaoMun) {
		this.inscricaoMun = inscricaoMun;
	}

	public String getNome() {
		if (StringUtils.isBlank(this.nome) && StringUtils.isNotBlank(this.nomeFantasia)){
			return this.nomeFantasia;
		}
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		if (StringUtils.isBlank(this.nomeFantasia) && StringUtils.isNotBlank(this.nome)){
			return this.nome;
		}
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomecompleto() {
		return this.nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	

	public List<ClienteServico> getClienteServicos() {
		return this.clienteServicos;
	}

	public void setClienteServicos(List<ClienteServico> clienteServicos) {
		this.clienteServicos = clienteServicos;
	}

	public ClienteServico addClienteServico(ClienteServico clienteServicos) {
		getClienteServicos().add(clienteServicos);
		clienteServicos.setCliente(this);

		return clienteServicos;
	}

	public ClienteServico removeClienteServico(ClienteServico clienteServicos) {
		getClienteServicos().remove(clienteServicos);
		clienteServicos.setCliente(null);

		return clienteServicos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	
//
//	public List<FornecProduto> getFornecProdutos() {
//		return this.fornecProdutos;
//	}
//
//	public void setFornecProdutos(List<FornecProduto> fornecProdutos) {
//		this.fornecProdutos = fornecProdutos;
//	}
//
//	public FornecProduto addFornecProduto(FornecProduto fornecProduto) {
//		getFornecProdutos().add(fornecProduto);
//		fornecProduto.setCliente(this);
//
//		return fornecProduto;
//	}
//
//	public FornecProduto removeFornecProduto(FornecProduto fornecProduto) {
//		getFornecProdutos().remove(fornecProduto);
//		fornecProduto.setCliente(null);
//
//		return fornecProduto;
//	}
//
//	public List<Pedido> getPedidos() {
//		return this.pedidos;
//	}
//
//	public void setPedidos(List<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}
//
//	public Pedido addPedido(Pedido pedido) {
//		getPedidos().add(pedido);
//		pedido.setCliente(this);
//
//		return pedido;
//	}
//
//	public Pedido removePedido(Pedido pedido) {
//		getPedidos().remove(pedido);
//		pedido.setCliente(null);
//
//		return pedido;
//	}

}