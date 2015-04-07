package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Usuario;

@ManagedBean
@SessionScoped
public class PessoaMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	private Pessoa pessoa;
	
	private List<Usuario> listaUsuarios;
	
	public PessoaMb() {
		super();
		this.pessoa = new Pessoa();
		this.listaUsuarios = new ArrayList<Usuario>();
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

	public void limpar(){

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
