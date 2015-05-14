package com.module.faces;

import java.util.ArrayList;
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
	
	private Empresa filial;	
	private List<Empresa> listFiliais;

	private List<Empresa> listMatriz;
		
	
	public EmpresaMb() {
		super();
		limpar();
	}

	public void limpar(){
		this.empresa = new Empresa();
		this.filial = new Empresa();
		this.listFiliais = new ArrayList<Empresa>(); 
	}
	
	
	public void buscar(){		
		this.listEmpresa = empresaEjb.listarEmpresas(empresa);
		if ((this.listEmpresa != null)&&(!this.listEmpresa.isEmpty())&&(this.listEmpresa.size() == 1)){
			this.empresa = this.listEmpresa.get(0);
			this.listEmpresa.clear();
			
			this.listFiliais = empresaEjb.listarFiliais(this.empresa);
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.empresa = empresaEjb.cadastrarEmpresa(this.empresa);
			addMsg("Dados da empresa registrados com sucesso.");
		}
	}
	
	private boolean validarSalvar() {
		return true;
	}

	public void excluir(){
		if ((this.empresa != null)&&(this.empresa.getEmpresaId() != null)){
			empresaEjb.excluirEmpresa(this.empresa);
			limpar();
		}		
	}
	
	public void buscarFilial(){		
		this.listEmpresa = empresaEjb.listarEmpresas(empresa);
		if ((this.empresa != null)&&(this.empresa.getId() != null)&&(this.empresa.getId().intValue() > 0)){			
			this.listFiliais = empresaEjb.listarFiliais(this.empresa);
		}
	}
	
	public void limparFilial(){
		this.filial = new Empresa(); 
	}
	
	private boolean validarSalvarFilial() {
		return true;
	}
	
	public void salvarFilial(){
		if (validarSalvarFilial()){
			this.filial = empresaEjb.cadastrarEmpresa(this.filial);
			this.listFiliais = empresaEjb.listarFiliais(this.empresa);
			addMsg("Dados da filial registrados com sucesso.");
		}
	}
	
	public void editarFilial(Empresa filial){
		this.filial = filial;
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

	public Empresa getFilial() {
		return filial;
	}

	public void setFilial(Empresa filial) {
		this.filial = filial;
	}

	public List<Empresa> getListFiliais() {
		return listFiliais;
	}

	public void setListFiliais(List<Empresa> listFiliais) {
		this.listFiliais = listFiliais;
	}
	
	
}
