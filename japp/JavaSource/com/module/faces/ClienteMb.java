package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IClienteEjb;
import com.module.jpa.model.AgenteExterno;

@ManagedBean
@SessionScoped
public class ClienteMb extends BaseMb{

	@EJB
	private IClienteEjb clienteEjb;

	private AgenteExterno cliente;
	private List<AgenteExterno> listCliente;

	public void limpar(){
		this.cliente = new AgenteExterno();
		this.listCliente = new ArrayList<AgenteExterno>();
	}
	
	public void buscar(){
		
	}
	
	public void salvar(){

	}
	
	public void excluir(){

	}
	
	public AgenteExterno getCliente() {
		return cliente;
	}

	public void setCliente(AgenteExterno cliente) {
		this.cliente = cliente;
	}

	public List<AgenteExterno> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<AgenteExterno> listCliente) {
		this.listCliente = listCliente;
	}
	
}
