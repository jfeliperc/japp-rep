package com.module.faces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class BaseMb {
	
	private String msg;
	
	private boolean mostrarLista;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isMostrarLista() {
		return mostrarLista;
	}

	public void setMostrarLista(boolean mostrarLista) {
		this.mostrarLista = mostrarLista;
	}

	protected void addMsgError(String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no processo", msg);
        FacesContext.getCurrentInstance().addMessage(null, message);   
	}
	
	protected void addMsg(String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,  "");
        FacesContext.getCurrentInstance().addMessage(null, message);     
	}
		
}
