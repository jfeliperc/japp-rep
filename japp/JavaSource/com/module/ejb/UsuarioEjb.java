package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IUsuarioEjb;
import com.module.jpa.dao.Dao;
import com.module.jpa.model.Pessoa;

@Stateless
public class UsuarioEjb implements IUsuarioEjb {

	@Override
	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		
		Dao<Pessoa> dao = new Dao<Pessoa>();
		if (pessoa.getId() == null){
			dao.add(pessoa);
		}else{
			dao.update(pessoa);
		}
		return pessoa;
	}

	@Override
	public Pessoa buscarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listarPessoas(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validarLogin(String user, String pass, Integer empresaId) {
		// TODO Auto-generated method stub
		return false;
	}

}
