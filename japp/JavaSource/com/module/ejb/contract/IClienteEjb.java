package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.AgenteExterno;

public interface IClienteEjb {

	public AgenteExterno cadastrarCliente(AgenteExterno cliente);
	
	public AgenteExterno buscarCliente(AgenteExterno cliente);
	
	public List<AgenteExterno> listarClientes(AgenteExterno cliente);
	
	public void excluirCliente(AgenteExterno cliente);

	public int buscarQtdCliente();
	
}
