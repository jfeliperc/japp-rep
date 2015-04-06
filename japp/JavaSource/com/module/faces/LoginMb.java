package com.module.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Pessoa;


@ManagedBean
@SessionScoped
public class LoginMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	private String login;
	private String pass;
	private Integer empresaId;
	
	public String executarLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", "True");
		
        if (pessoaEjb.validarLogin(login, pass, empresaId)){
        	
        	Pessoa pessoa = new Pessoa();
        	pessoa.setLogin(login);
        	pessoa.setPass(pass);
        	pessoa = pessoaEjb.buscarPorLogin(login);
        	
        	session.setAttribute("userLog", pessoa);
        	
        	return "inicio";
        }else{
        	setMsg("Login e/ou senha inválido(s).");
    		return "login";
        }
        
	}
	
	public String executarLogout(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", null);
		return "login";
	}
	
	public String encaminharSolicitaCadastro(){
		return "c_pessoa";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
