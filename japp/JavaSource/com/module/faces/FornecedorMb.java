package com.module.faces;

import java.util.ArrayList;
import java.util.List;

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
	private List<AgenteExterno> listFornecedor;

	public void limpar(){
		this.fornecedor = new AgenteExterno();
		this.listFornecedor = new ArrayList<AgenteExterno>();
	}
	
	public void buscar(){
		
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.fornecedor = fornecedorEjb.cadastrarFornecedor(this.fornecedor);
		}
	}
	
	private boolean validarSalvar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void excluir(){

	}
	
	public AgenteExterno getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(AgenteExterno fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<AgenteExterno> getListFornecedor() {
		return listFornecedor;
	}

	public void setListFornecedor(List<AgenteExterno> listFornecedor) {
		this.listFornecedor = listFornecedor;
	}
	
}
