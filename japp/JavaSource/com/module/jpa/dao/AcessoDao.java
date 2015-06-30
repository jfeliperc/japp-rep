package com.module.jpa.dao;

import java.util.List;

import com.module.jpa.model.Acesso;
import com.module.jpa.model.Pessoa;

public class AcessoDao extends Dao<Acesso>{

	public AcessoDao() {
		super(Acesso.class);
	}

	public List<Acesso> getAcessoPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

}
