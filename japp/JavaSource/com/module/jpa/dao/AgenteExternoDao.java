package com.module.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import com.module.jpa.model.AgenteExterno;

public class AgenteExternoDao extends Dao<AgenteExterno> {

	public AgenteExternoDao() {
		super(AgenteExterno.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<AgenteExterno> buscarTodosFornecedores(){
		List<AgenteExterno> agentes = (ArrayList<AgenteExterno>)getEm().createNamedQuery("AgenteExterno.findByTipo").setParameter("tipo", "F").getResultList();
		return agentes;		
	}
	
	@SuppressWarnings("unchecked")
	public List<AgenteExterno> buscarTodosClientes(){
		List<AgenteExterno> agentes = (ArrayList<AgenteExterno>)getEm().createNamedQuery("AgenteExterno.findByTipo").setParameter("tipo", "C").getResultList();
		return agentes;		
	}

	public List<AgenteExterno> findByExample(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
