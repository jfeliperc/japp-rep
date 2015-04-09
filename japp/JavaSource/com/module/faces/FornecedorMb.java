package com.module.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IFornecedorEjb;
import com.module.jpa.model.AgenteExterno;


@ManagedBean
@SessionScoped
public class FornecedorMb extends BaseMb{

	@EJB
	private IFornecedorEjb fornecedorEjb;

	private AgenteExterno fornecedor;

	public AgenteExterno getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(AgenteExterno fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
