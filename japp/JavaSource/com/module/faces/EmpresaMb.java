package com.module.faces;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IEmpresaEjb;
import com.module.jpa.model.Empresa;


@ManagedBean
@SessionScoped
public class EmpresaMb extends BaseMb{

	@EJB
	private IEmpresaEjb empresaEjb;

	private Empresa empresa;
	
	private List<Empresa> listEmpresa;

	private List<Empresa> listMatriz;
		
	
	public EmpresaMb() {
		super();
		limpar();
	}

	public void limpar(){
		this.empresa = new Empresa();
	}
	
	public void buscar(){
		
	}
	
	public void salvar(){
		if (validarSalvar()){
			empresaEjb.salvarEmpresa(this.empresa);
		}
	}
	
	private boolean validarSalvar() {
		return false;
	}

	public void excluir(){
		
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	public void setListEmpresa(List<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	public List<Empresa> getListMatriz() {
		return listMatriz;
	}

	public void setListMatriz(List<Empresa> listMatriz) {
		this.listMatriz = listMatriz;
	}
	
	
}
