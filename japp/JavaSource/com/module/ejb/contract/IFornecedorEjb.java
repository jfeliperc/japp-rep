package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.AgenteExterno;

public interface IFornecedorEjb {

	public AgenteExterno cadastrarFornecedor(AgenteExterno fornecedor);
	
	public AgenteExterno buscarFornecedor(AgenteExterno fornecedor);
	
	public List<AgenteExterno> listarFornecedores(AgenteExterno fornecedor);
	
	public void excluirFornecedor(AgenteExterno fornecedor);

	public int buscarQtdFornecedor();
	
}
