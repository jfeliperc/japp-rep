package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IReceitaEjb;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;

@Stateless
public class ReceitaEjb implements IReceitaEjb {

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
	public List<TipoProduto> buscarTipoProduto(TipoProduto tipoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoProduto> buscarGrupoProduto(GrupoProduto grupoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoProduto salvarTipoProduto(TipoProduto tipoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoProduto salvarGrupoProduto(GrupoProduto grupoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoProduto> buscarAllGrupoProduto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoProduto> buscarAllTipoProduto() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
