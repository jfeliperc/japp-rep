package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datanascimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataultimoacesso;

	private String docprincipal;

	private String documento;

	private String login;

	private String nome;

	private String nomecompleto;

	private String pass;

	private String tipo;

	@Column(name="tipo_pessoa")
	private String tipoPessoa;

	@Column(name="tipo_usuario")
	private String tipoUsuario;

	private String tipodocprincipal;

	private String tipodocumento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="validade_login")
	private Date validadeLogin;

	//bi-directional many-to-one association to Acesso
	@OneToMany(mappedBy="pessoa")
	private List<Acesso> acessos;

	//bi-directional many-to-one association to Contato
	@OneToMany(mappedBy="pessoa")
	private List<Contato> contatos;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="pessoa")
	private List<Endereco> enderecos;

	//bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy="pessoa")
	private List<Orcamento> orcamentos;

	//bi-directional many-to-one association to TipoPessoa
	@ManyToOne
	@JoinColumn(name="tipo_pessoa_id")
	private TipoPessoa tipoPessoaBean;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="pessoa")
	private List<Usuario> usuarios;

	public Pessoa() {
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

	public Date getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Date getDataultimoacesso() {
		return this.dataultimoacesso;
	}

	public void setDataultimoacesso(Date dataultimoacesso) {
		this.dataultimoacesso = dataultimoacesso;
	}

	public String getDocprincipal() {
		return this.docprincipal;
	}

	public void setDocprincipal(String docprincipal) {
		this.docprincipal = docprincipal;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomecompleto() {
		return this.nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipodocprincipal() {
		return this.tipodocprincipal;
	}

	public void setTipodocprincipal(String tipodocprincipal) {
		this.tipodocprincipal = tipodocprincipal;
	}

	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Date getValidadeLogin() {
		return this.validadeLogin;
	}

	public void setValidadeLogin(Date validadeLogin) {
		this.validadeLogin = validadeLogin;
	}

	public List<Acesso> getAcessos() {
		return this.acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

	public Acesso addAcesso(Acesso acesso) {
		getAcessos().add(acesso);
		acesso.setPessoa(this);

		return acesso;
	}

	public Acesso removeAcesso(Acesso acesso) {
		getAcessos().remove(acesso);
		acesso.setPessoa(null);

		return acesso;
	}

	public List<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Contato addContato(Contato contato) {
		getContatos().add(contato);
		contato.setPessoa(this);

		return contato;
	}

	public Contato removeContato(Contato contato) {
		getContatos().remove(contato);
		contato.setPessoa(null);

		return contato;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setPessoa(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setPessoa(null);

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
		orcamento.setPessoa(this);

		return orcamento;
	}

	public Orcamento removeOrcamento(Orcamento orcamento) {
		getOrcamentos().remove(orcamento);
		orcamento.setPessoa(null);

		return orcamento;
	}

	public TipoPessoa getTipoPessoaBean() {
		return this.tipoPessoaBean;
	}

	public void setTipoPessoaBean(TipoPessoa tipoPessoaBean) {
		this.tipoPessoaBean = tipoPessoaBean;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPessoa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPessoa(null);

		return usuario;
	}

}