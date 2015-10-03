package com.module.faces;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Contato;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
		
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private Boolean renovarSenha;
	private Contato contatoTemp;
	private List<Contato> listContatoTemp;
		
	public PessoaMb() {
		super();
		limpar();
	}
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		empresaAux = new Empresa();
	}

	public void solicitarCadastroPessoa(){
		pessoaEjb.solicitarCadastro(pessoa);
        addMsg("Solicita��o de cadastro registrada.");
	}
		
	public void buscar(){
		try {
			this.pessoa.setEmpresa(getEmpresaAux());
			this.pessoas = pessoaEjb.listarPessoas(this.pessoa);
			
			if ((this.pessoas != null)&&(!this.pessoas.isEmpty())&&(this.pessoas.size() == 1)){
				this.pessoa = this.pessoas.get(0);
				this.pessoas.clear();
				
				this.pessoa = pessoaEjb.buscarPessoa(this.pessoa);
				empresaAux = this.pessoa.getEmpresa() == null ? new Empresa() : this.pessoa.getEmpresa();
			}else if ((this.pessoas == null)||(this.pessoas.isEmpty())){
				addMsg("Nenhuma pessoa encontrada na busca.");
			}else{				
				empresaAux = new Empresa();
				setMostrarLista((this.pessoas != null)&&(!this.pessoas.isEmpty()));
			}
			
		} catch (Exception e) {
			addMsgError("Erro ao buscar pessoa(s) - "+e.getMessage());
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			try {
				List<Contato> contatosTemp = this.pessoa.getContatos();
				
				this.pessoa.setEmpresa(getEmpresaAux());
				this.pessoa = pessoaEjb.salvarPessoa(this.pessoa);
				
				pessoaEjb.removeAllContatos(this.pessoa);
				pessoaEjb.salvarListContatoPessoa(this.pessoa, contatosTemp);
				this.pessoa.setContatos(pessoaEjb.buscarContatos(this.pessoa));
				
			} catch (NoSuchAlgorithmException e) {				
				addMsgError("Erro ao salvar dados - "+e.getMessage());
			}
			this.pessoas.clear();
			addMsg("Registro salvo com sucesso.");
		}
	}

	public void editar(Pessoa us){
		this.pessoa = us;
		this.pessoa = pessoaEjb.buscarPessoa(this.pessoa);
		empresaAux = this.pessoa.getEmpresa() == null ? new Empresa() : this.pessoa.getEmpresa();
		alternaMostraLista();
	}
	
	public void editarContato(Contato us){
		this.contatoTemp = us;
	}

	public void excluirContato(Contato us){
		this.pessoa.getContatos().remove(us);
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.pessoa.getNomecompleto())){
			addMsgError("O campo Nome Completo � obrigat�rio");
			ret = false;
		}
		if (StringUtils.isBlank(this.pessoa.getCpf())){
			addMsgError("O campo CPF � obrigat�rio");
			ret = false;
		}
		return ret;
	}

	public void excluir(){
		String msgResult = this.pessoa.getId()+"-"+this.pessoa.getNomecompleto()+"-"+this.getPessoa().getCpf();		
		pessoaEjb.excluirPessoa(this.pessoa, true);
		addMsg("Processo de exclus�o/inativa��o conclu�do. "+msgResult);
	}

	public void limpar(){
		this.pessoa = new Pessoa();
		this.contatoTemp = new Contato();
		this.pessoas = new ArrayList<Pessoa>();
		empresaAux = new Empresa();		
	}
	
	public void limparContatos(){
		this.contatoTemp = new Contato();
	}
	
	public void adicionarContatos(){
		if ((this.pessoa != null)&&(!isIdZeroOrNull(this.pessoa.getId()))){
			this.contatoTemp.setPessoa(this.pessoa);
			//pessoaEjb.salvarContatoPessoa(contatoTemp);
			//this.pessoa = pessoaEjb.buscarPessoa(this.pessoa);
			this.pessoa.getContatos().add(this.contatoTemp);
			this.contatoTemp = new Contato();
		}
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Contato getContatoTemp() {
		return contatoTemp;
	}

	public void setContatoTemp(Contato contatoTemp) {
		this.contatoTemp = contatoTemp;
	}

	public Boolean getRenovarSenha() {
		return renovarSenha;
	}

	public void setRenovarSenha(Boolean renovarSenha) {
		this.renovarSenha = renovarSenha;
	}

	public List<Contato> getListContatoTemp() {
		return listContatoTemp;
	}

	public void setListContatoTemp(List<Contato> listContatoTemp) {
		this.listContatoTemp = listContatoTemp;
	}

}
