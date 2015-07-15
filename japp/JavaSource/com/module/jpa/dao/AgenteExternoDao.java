package com.module.jpa.dao;

import java.util.List;

import com.module.jpa.model.AgenteExterno;

public class AgenteExternoDao extends Dao<AgenteExterno> {

	public AgenteExternoDao() {
		super(AgenteExterno.class);
	}
	
	public List<AgenteExterno> buscarTodosFornecedores(){
		
		return null;		
	}
	
	public List<AgenteExterno> buscarTodosClientes(){
		
		return null;		
	}

	public List<AgenteExterno> findByExample(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
