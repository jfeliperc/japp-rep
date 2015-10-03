package com.module.ejb.contract;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.module.jpa.model.Contato;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Pessoa;

public interface IPessoaEjb {

	public Pessoa cadastrarPessoa(Pessoa Pessoa);
	
	public Pessoa buscarPessoa(Pessoa Pessoa);
	
	public List<Pessoa> listarPessoas(Pessoa Pessoa);
	
	public void excluirPessoa(Pessoa Pessoa);

	public void solicitarCadastro(Pessoa pessoa);

	public int buscarQtdPessoa();

	public Pessoa buscarPorLogin(String login);

	public boolean validarLogin(String login, String pass, Empresa empresaId) throws NoSuchAlgorithmException;

	public Pessoa salvarPessoa(Pessoa pessoa) throws NoSuchAlgorithmException;

	public void excluirPessoa(Pessoa pessoa, boolean exclusaoFisica);

	public List<Pessoa> listarPessoasAcesso(Pessoa pessoa);

	public void salvarContatoPessoa(Contato contatoTemp);

	public void removeAllContatos(Pessoa pessoa);

	public void salvarListContatoPessoa(Pessoa pessoa,List<Contato> contatosTemp);

	public List<Contato> buscarContatos(Pessoa pessoa);
	
}
