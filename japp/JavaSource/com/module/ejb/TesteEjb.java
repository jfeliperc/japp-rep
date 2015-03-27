package com.module.ejb;

import com.module.jpa.dao.Dao;
import com.module.jpa.model.TipoPessoa;

public class TesteEjb implements ITesteEjb{

	@Override
	public TipoPessoa processaTeste() {
		
		Dao<TipoPessoa> daoTeste = new Dao<TipoPessoa>();
		TipoPessoa tp = new TipoPessoa();
		tp.setNome("Fisica");
		daoTeste.add(tp);
		
		System.out.println("Validacao -> "+tp.getNome());
		
		return null;
	}

}
