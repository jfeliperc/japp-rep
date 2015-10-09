package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Estoque;
import com.module.jpa.model.EstoqueMovimento;
import com.module.jpa.model.Produto;

public interface IEstoqueEjb {
	
	public List<Estoque> buscarPosicaoEstoque(Estoque estoqueFiltro);
	
	public void inserirProdutoEstoque(Produto produto);
	
	public void inserirMovimentacaoEstoque(EstoqueMovimento movimentoEstoque);
	
}
