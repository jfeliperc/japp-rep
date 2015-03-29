package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Usuario;

public interface IPessoaEjb {

	public Pessoa cadastrarPessoa(Pessoa Pessoa);
	
	public Pessoa buscarPessoa(Pessoa Pessoa);
	
	public List<Pessoa> listarPessoas(Pessoa Pessoa);
	
	public void excluirPessoa(Pessoa Pessoa);

	public void solicitarCadastro(Pessoa pessoa, Usuario usuario);
	
}
