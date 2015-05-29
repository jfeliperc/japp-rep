package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IFornecedorEjb;
import com.module.jpa.dao.FornecedorDao;
import com.module.jpa.model.AgenteExterno;

@Stateless
public class FornecedorEjb implements IFornecedorEjb {

	FornecedorDao dao; 
	
	public FornecedorEjb() {
		this.dao = new FornecedorDao();
    }
	
	@Override
	public AgenteExterno cadastrarFornecedor(AgenteExterno fornecedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgenteExterno buscarFornecedor(AgenteExterno fornecedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgenteExterno> listarFornecedores(AgenteExterno fornecedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirFornecedor(AgenteExterno fornecedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int buscarQtdFornecedor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
