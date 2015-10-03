package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Fornecedor;

public interface IFornecedorEjb {

	public Fornecedor cadastrarFornecedor(Fornecedor fornecedor);
	
	public Fornecedor buscarFornecedor(Fornecedor fornecedor);
	
	public List<Fornecedor> listarFornecedores(Fornecedor fornecedor);
	
	public void excluirFornecedor(Fornecedor fornecedor);

	public int buscarQtdFornecedor();
	
}
