package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Cliente;

public interface IClienteEjb {

	public Cliente cadastrarCliente(Cliente cliente);
	
	public Cliente buscarCliente(Cliente cliente);
	
	public List<Cliente> listarClientes(Cliente cliente);
	
	public void excluirCliente(Cliente cliente);

	public int buscarQtdCliente();

	public Cliente buscarServicoCliente(Cliente cliente);

	public List<Cliente> buscarAllClientes();
	
}
