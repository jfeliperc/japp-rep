package com.module.faces;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	private List<Empresa> empresas;
	
	private Contato contatoTemp;
	
	private boolean mostrarListaPessoas;
		
	public PessoaMb() {
		super();
		limpar();
	}

	public void solicitarCadastroPessoa(){
		pessoaEjb.solicitarCadastro(pessoa);
        addMsg("Solicitação de cadastro registrada.");
		//return "login";
	}
	
	public void buscar(){
		
	}
	
	public void salvar(){

	}

	public void excluir(){
		
	}

	public void limpar(){
		this.pessoa = new Pessoa();
		this.contatoTemp = new Contato();
	}
	
	public boolean isMostrarListaPessoas(){
		return ((this.pessoas != null)&&(!this.pessoas.isEmpty()));
	}
	
	public void setMostrarListaPessoas(boolean mostrarListaPessoas) {
		this.mostrarListaPessoas = mostrarListaPessoas;
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

}
