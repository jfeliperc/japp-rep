package com.module.faces;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IAcessoEjb;
import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Acesso;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Rotina;

@ManagedBean
@SessionScoped
public class AcessoMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	@EJB
	private IAcessoEjb acessoEjb;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;			
	private List<Acesso> acessos;
	private List<Rotina> rotinas;
		
	
	public AcessoMb() {
		super();
		limpar();
	}
		
	public void buscar(){
		try {
			this.pessoas = pessoaEjb.listarPessoasAcesso(this.pessoa);
			
			if ((this.pessoas != null)&&(!this.pessoas.isEmpty())&&(this.pessoas.size() == 1)){
				this.pessoa = this.pessoas.get(0);
				this.pessoas.clear();
			}else{
				setMostrarLista((this.pessoas != null)&&(!this.pessoas.isEmpty()));
			}
			
		} catch (Exception e) {
			addMsgError("Erro ao buscar pessoa(s) - "+e.getMessage());
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			try {
				this.pessoa = pessoaEjb.salvarPessoa(this.pessoa);
			} catch (NoSuchAlgorithmException e) {
				addMsgError("Erro ao salvar dados - "+e.getMessage());
				//e.printStackTrace();
			}
		}
	}

	private boolean validarSalvar() {
		
		return false;
	}
	
	public void limpar(){
		this.pessoa = new Pessoa();
		this.rotinas = acessoEjb.listarRotinas();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

	public List<Rotina> getRotinas() {
		return rotinas;
	}

	public void setRotinas(List<Rotina> rotinas) {
		this.rotinas = rotinas;
	}
	
	

}
