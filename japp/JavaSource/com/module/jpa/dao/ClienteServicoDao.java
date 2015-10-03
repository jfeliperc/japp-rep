package com.module.jpa.dao;

import java.util.List;

import com.module.jpa.model.Cliente;
import com.module.jpa.model.ClienteServico;
import com.module.jpa.model.Servico;

public class ClienteServicoDao extends Dao<ClienteServico> {

	public ClienteServicoDao() {
		super(ClienteServico.class);
	}

	public List<ClienteServico> findByCliente(Cliente cliente) {
		@SuppressWarnings("unchecked")
		List<ClienteServico> servicos = getEm().createNamedQuery("ClienteServico.findByCliente")
				.setParameter("id", cliente.getId()) 
				.getResultList();		
		return servicos;
	}
	
	public List<ClienteServico> findByServico(Servico servico) {
		@SuppressWarnings("unchecked")
		List<ClienteServico> clientes = getEm().createNamedQuery("ClienteServico.findByServico")
				.setParameter("id", servico.getId()) 
				.getResultList();		
		return clientes;
	}
	
}
