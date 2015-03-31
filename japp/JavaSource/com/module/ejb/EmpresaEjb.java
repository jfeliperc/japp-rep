package com.module.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IEmpresaEjb;
import com.module.jpa.model.Produto;

@Stateless
public class EmpresaEjb implements IEmpresaEjb, Serializable {

    public EmpresaEjb() {
    }

	@Override
	public Produto cadastrarProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto buscarProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listarProdutos(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testeTipoPessoa() {
		// TODO Auto-generated method stub
		
	}

}