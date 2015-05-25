package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;

public interface IEstoqueEjb {

	public List<Produto> listarProdutos(Produto produto);
	
	public List<TipoProduto> buscarTipoProduto(TipoProduto tipoProduto);

	public List<GrupoProduto> buscarGrupoProduto(GrupoProduto grupoProduto);
	
	public List<GrupoProduto> buscarAllGrupoProduto();

	public List<TipoProduto> buscarAllTipoProduto();
	
}