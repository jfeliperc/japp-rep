package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IClienteEjb;
import com.module.jpa.model.AgenteExterno;

@Stateless
public class ClienteEjb implements IClienteEjb {

	@Override
	public AgenteExterno cadastrarCliente(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgenteExterno buscarCliente(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgenteExterno> listarClientes(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirCliente(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int buscarQtdCliente() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
