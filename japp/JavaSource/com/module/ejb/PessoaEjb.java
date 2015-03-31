package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.dao.Dao;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.TipoPessoa;
import com.module.jpa.model.Usuario;

@Stateless
public class PessoaEjb implements IPessoaEjb {

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
	public Pessoa buscarPessoa(Pessoa Pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listarPessoas(Pessoa Pessoa) {
		
		return null;
	}

	@Override
	public void excluirPessoa(Pessoa Pessoa) {
		
	}

	@Override
	public void solicitarCadastro(Pessoa pessoa, Usuario usuario) {
		Dao<Pessoa> daoPessoa = new Dao<Pessoa>();
		Dao<Usuario> daoUsuario = new Dao<Usuario>();
		
		pessoa.setDataalteracao(new Date());
		pessoa.setTipo("2");		
		pessoa.setTipoPessoa("PF");
		
		usuario.setDataalteracao(new Date());
		usuario.setTipo("2");
		
		if (pessoa.getId() == null){
			pessoa.setDatainclusao(new Date());
			daoPessoa.add(pessoa);
		}else{
			daoPessoa.update(pessoa);
		}
		usuario.setPessoa(pessoa);
		if (usuario.getId() == null){
			usuario.setDatainclusao(new Date());
			daoUsuario.add(usuario);
		}else{
			daoUsuario.update(usuario);
		}
	}

}
