package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Produto;

public interface IEmpresaEjb {

	public Produto cadastrarProduto(Produto produto);
	
	public Produto buscarProduto(Produto produto);
	
	public List<Produto> listarProdutos(Produto produto);
	
	public void excluirProduto(Produto produto);
	
	public void testeTipoPessoa();
}
