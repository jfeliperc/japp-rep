package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Pessoa;

public interface IUsuarioEjb {

	public Pessoa cadastrarPessoa(Pessoa pessoa);
	
	public Pessoa buscarPessoa(Pessoa pessoa);
	
	public List<Pessoa> listarPessoas(Pessoa pessoa);
	
	public void excluirPessoa(Pessoa pessoa);
	
	public boolean validarLogin(String user, String pass, Integer empresaId);
}
