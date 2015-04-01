package com.module.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Produto;


@ManagedBean
@SessionScoped
public class EmpresaMb extends BaseMb{

	@EJB
	private IProdutoEjb produtoEjb;

	private Empresa empresa;
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
