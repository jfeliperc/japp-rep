package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findById", query = "SELECT e FROM Empresa e WHERE e.empresaId = :id"),
    @NamedQuery(name = "Empresa.findByRazaoSocial", query = "SELECT e FROM Empresa e WHERE e.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Empresa.findByNomeFantasia", query = "SELECT e FROM Empresa e WHERE e.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj"),
    @NamedQuery(name = "Empresa.findByInscricaoEst", query = "SELECT e FROM Empresa e WHERE e.inscricaoEst = :inscricaoEst"),
    @NamedQuery(name = "Empresa.findByInscricaoMun", query = "SELECT e FROM Empresa e WHERE e.inscricaoMun = :inscricaoMun"),
    @NamedQuery(name = "Empresa.findByMatriz", query = "SELECT e FROM Empresa e WHERE e.matriz = :matriz")})
public class Empresa implements Serializable, IGenericModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer empresaId;

	private String ativo;

	private String cnpj;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	@Column(name="inscricao_est")
	private String inscricaoEst;

	@Column(name="inscricao_mun")
	private String inscricaoMun;

	private Integer matriz;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="razao_social")
	private String razaoSocial;

	@OneToMany(mappedBy="empresa")
	private List<AgenteExterno> agenteExternos;

	@OneToMany(mappedBy="empresa")
	private List<Endereco> enderecos;

	@OneToMany(mappedBy="empresa")
	private List<Orcamento> orcamentos;

	@OneToMany(mappedBy="empresa")
	private List<Pedido> pedidos;

	@OneToMany(mappedBy="empresa")
	private List<Pessoa> pessoas;

	@OneToMany(mappedBy="empresa")
	private List<Produto> produtos;
	
	@OneToMany(mappedBy="empresa")
	private List<Servico> servicos;
	
	@OneToMany(mappedBy="empresa")
	private List<Receita> receitas;
	
	public Empresa() {
	
	}


	@Override
	public Integer getId() {		
		return getEmpresaId();
	}

	@Override
	public void setId(Integer id) {
		setEmpresaId(id);
	}
	
	public Integer getEmpresaId() {
		return empresaId;
	}


	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
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

	public Integer getMatriz() {
		return this.matriz;
	}

	public void setMatriz(Integer matriz) {
		this.matriz = matriz;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<AgenteExterno> getAgenteExternos() {
		return this.agenteExternos;
	}

	public void setAgenteExternos(List<AgenteExterno> agenteExternos) {
		this.agenteExternos = agenteExternos;
	}

	public AgenteExterno addAgenteExterno(AgenteExterno agenteExterno) {
		getAgenteExternos().add(agenteExterno);
		agenteExterno.setEmpresa(this);

		return agenteExterno;
	}

	public AgenteExterno removeAgenteExterno(AgenteExterno agenteExterno) {
		getAgenteExternos().remove(agenteExterno);
		agenteExterno.setEmpresa(null);

		return agenteExterno;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setEmpresa(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setEmpresa(null);

		return endereco;
	}

	public List<Orcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Orcamento addOrcamento(Orcamento orcamento) {
		getOrcamentos().add(orcamento);
		orcamento.setEmpresa(this);

		return orcamento;
	}

	public Orcamento removeOrcamento(Orcamento orcamento) {
		getOrcamentos().remove(orcamento);
		orcamento.setEmpresa(null);

		return orcamento;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setEmpresa(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setEmpresa(null);

		return pedido;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setEmpresa(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setEmpresa(null);

		return pessoa;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setEmpresa(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setEmpresa(null);

		return produto;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setEmpresa(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setEmpresa(null);

		return servico;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}


	public Receita addReceita(Receita receita) {
		getReceitas().add(receita);
		receita.setEmpresa(this);

		return receita;
	}

	public Receita removeReceita(Receita receita) {
		getReceitas().remove(receita);
		receita.setEmpresa(null);

		return receita;
	}
}