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
public class AcessoMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Empresa> empresas;
		
	public AcessoMb() {
		super();
		limpar();
	}

	public void solicitarCadastroPessoa(){
		pessoaEjb.solicitarCadastro(pessoa);
        addMsg("Dados gravados com sucesso.");
	}
		
	public void buscar(){
		try {
			this.pessoas = pessoaEjb.listarPessoas(this.pessoa);
			
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
			this.pessoa = pessoaEjb.salvarPessoa(this.pessoa);
		}
	}

	private boolean validarSalvar() {
		
		return false;
	}

	public void excluir(){
		
	}

	public void limpar(){
		this.pessoa = new Pessoa();
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

}
