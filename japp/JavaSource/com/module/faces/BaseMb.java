package com.module.faces;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.module.ejb.contract.IEmpresaEjb;
import com.module.jpa.model.Empresa;

@ManagedBean
@SessionScoped
public class BaseMb {
	
	@EJB
	private IEmpresaEjb empresaEjb;
	
	private String msg;
	
	private boolean mostrarLista;

	protected List<Empresa> empresas;
	
	protected Empresa empresaAux;

	private String themeFace;
	
	public BaseMb() {
		super();
		this.themeFace = "humanity";
		//this.themeFace = "pepper-grinder"; 
		//this.themeFace = "afterwork";
		//this.themeFace = "glass-x";
		//this.themeFace = "overcast";
	}

	@PostConstruct
	public void posConstrucao(){
		this.empresaAux = new Empresa();
		this.empresas = empresaEjb.listarAllEmpresas();
	}
	
	protected void recarregarListEmpresa(){
		this.empresas = empresaEjb.listarAllEmpresas();
	}
	
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
	
	public void alternaMostraLista(){
		this.mostrarLista = !this.mostrarLista;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa getEmpresaAux() {
		if (empresaAux == null){
			setEmpresaAux(new Empresa());
		}
		return  this.empresaAux;
	}

	public void setEmpresaAux(Empresa empresaAux) {
		this.empresaAux = empresaAux;
	}

	protected void addMsgError(String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no processo - "+msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, message);   
	}
	
	protected void addMsg(String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,  "");
        FacesContext.getCurrentInstance().addMessage(null, message);     
	}
	
	protected boolean isIdZeroOrNull(Integer id){		
		return ((id == null)||(id.intValue() == 0));
		
	}

	public String getThemeFace() {
		return themeFace;
	}

	public void setThemeFace(String themeFace) {
		this.themeFace = themeFace;
	}
		
}
