package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the agente_externo database table.
 * 
 */
@Entity
@Table(name="agente_externo")
@NamedQuery(name="AgenteExterno.findAll", query="SELECT a FROM AgenteExterno a")
public class AgenteExterno implements Serializable {
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

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to FornecProduto
	@OneToMany(mappedBy="agenteExterno")
	private List<FornecProduto> fornecProdutos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="agenteExterno")
	private List<Pedido> pedidos;

	public AgenteExterno() {
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
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
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

	public List<FornecProduto> getFornecProdutos() {
		return this.fornecProdutos;
	}

	public void setFornecProdutos(List<FornecProduto> fornecProdutos) {
		this.fornecProdutos = fornecProdutos;
	}

	public FornecProduto addFornecProduto(FornecProduto fornecProduto) {
		getFornecProdutos().add(fornecProduto);
		fornecProduto.setAgenteExterno(this);

		return fornecProduto;
	}

	public FornecProduto removeFornecProduto(FornecProduto fornecProduto) {
		getFornecProdutos().remove(fornecProduto);
		fornecProduto.setAgenteExterno(null);

		return fornecProduto;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setAgenteExterno(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setAgenteExterno(null);

		return pedido;
	}

}