package com.module.faces;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Usuario;

@ManagedBean
@SessionScoped
public class PessoaMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	private Usuario usuario;
	private Pessoa pessoa;
	
	private String cadEmail;
	
	private List<Usuario> listaUsuarios;
	
	public PessoaMb() {
		super();
		this.usuario = new Usuario();
		this.pessoa = new Pessoa();
	}

	public String solicitarCadastroPessoa(){
		pessoaEjb.solicitarCadastro(pessoa, usuario);
        setMsg("Solicitação de cadastro registrada.");
		return "login";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCadEmail() {
		return cadEmail;
	}

	public void setCadEmail(String cadEmail) {
		this.cadEmail = cadEmail;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
