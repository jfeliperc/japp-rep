package com.module.faces;

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

	public AgenteExterno getCliente() {
		return cliente;
	}

	public void setCliente(AgenteExterno cliente) {
		this.cliente = cliente;
	}

	
}
