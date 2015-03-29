package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.dao.Dao;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoPessoa;

@Stateless
public class ProdutoEjb implements IProdutoEjb {

	@Override
	public Produto cadastrarProduto(Produto produto) {
		
		Dao<Produto> dao = new Dao<Produto>();
		if (produto.getId() == null){
			dao.add(produto);
		}else{
			dao.update(produto);
		}
		
		return produto;
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
		Dao<TipoPessoa> daoTeste = new Dao<TipoPessoa>();
		TipoPessoa tp = new TipoPessoa();
		tp.setNome("Juridica");
		daoTeste.add(tp);
		
	}

}
