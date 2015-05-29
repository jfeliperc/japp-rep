package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id"),
    @NamedQuery(name = "Pessoa.findByTipo", query = "SELECT p FROM Pessoa p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByNomecompleto", query = "SELECT p FROM Pessoa p WHERE p.nomecompleto = :nomecompleto"),
    @NamedQuery(name = "Pessoa.findByDatanascimento", query = "SELECT p FROM Pessoa p WHERE p.datanascimento = :datanascimento"),
    @NamedQuery(name = "Pessoa.findByDocumento", query = "SELECT p FROM Pessoa p WHERE p.documento = :documento"),
    @NamedQuery(name = "Pessoa.findByTipodocumento", query = "SELECT p FROM Pessoa p WHERE p.tipodocumento = :tipodocumento"),
    @NamedQuery(name = "Pessoa.findByTipoPessoa", query = "SELECT p FROM Pessoa p WHERE p.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "Pessoa.findByLogin", query = "SELECT p FROM Pessoa p WHERE p.login = :login"),
    @NamedQuery(name = "Pessoa.findByPass", query = "SELECT p FROM Pessoa p WHERE p.pass = :pass"),
    @NamedQuery(name = "Pessoa.findByValidadeLogin", query = "SELECT p FROM Pessoa p WHERE p.validadeLogin = :validadeLogin"),
    @NamedQuery(name = "Pessoa.findByTipoUsuario", query = "SELECT p FROM Pessoa p WHERE p.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Pessoa.findByDataultimoacesso", query = "SELECT p FROM Pessoa p WHERE p.dataultimoacesso = :dataultimoacesso")})
public class Pessoa implements Serializable, IGenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datanascimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataultimoacesso;

	private String documento;

	private String email;

	private String login;

	private String nome;

	private String nomecompleto;

	private String pass;

	/**
	 * refere-se ao status A=ativo; I=Inativo
	 */
	private String tipo;

	@Column(name="tipo_pessoa")
	private String tipoPessoa;

	@Column(name="tipo_usuario")
	private String tipoUsuario;

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

	//bi-directional many-to-one association to Empresa
	@ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name="id")
	private Empresa empresa;

	public Pessoa() {
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

	public Date getDataultimoacesso() {
		return this.dataultimoacesso;
	}

	public void setDataultimoacesso(Date dataultimoacesso) {
		this.dataultimoacesso = dataultimoacesso;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}