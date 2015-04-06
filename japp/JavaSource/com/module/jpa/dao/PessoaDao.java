package com.module.jpa.dao;

import com.module.jpa.model.Pessoa;

public class PessoaDao extends Dao<Pessoa> {

	public Pessoa getByLogin(String login) {
		
//		Pessoa pessoa = new Pessoa();
//		pessoa.setLogin(login);
//		List<Pessoa> result = (List<Pessoa>) getEm().find(Pessoa.class, pessoa);
		
		Pessoa pessoa = (Pessoa)getEm().createNamedQuery("Pessoa.findByLogin")
				.setParameter("login", login) 
				.getSingleResult();
		
		
		return pessoa;
	}

	
	
}
