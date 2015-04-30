package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Pessoa;

public interface IPessoaEjb {

	public Pessoa cadastrarPessoa(Pessoa Pessoa);
	
	public Pessoa buscarPessoa(Pessoa Pessoa);
	
	public List<Pessoa> listarPessoas(Pessoa Pessoa);
	
	public void excluirPessoa(Pessoa Pessoa);

	public void solicitarCadastro(Pessoa pessoa);

	public int buscarQtdPessoa();

	public Pessoa buscarPorLogin(String login);

	public boolean validarLogin(String login, String pass, Integer empresaId);

	public Pessoa salvarPessoa(Pessoa pessoa);

	public void excluirPessoa(Pessoa pessoa, boolean exclusaoFisica);
	
}
