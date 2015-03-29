package com.module.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class LoginMb extends BaseMb{

	private String login;
	private String pass;
	
	public String executarLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", "True");
		
//        if (LoginCtr.validarLogin()){
//        	return "inicio";
//        }
        
		return "inicio";
	}
	
	public String executarLogout(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", null);
		
		return "login";
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
