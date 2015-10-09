package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IEstoqueEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.EstoqueDao;
import com.module.jpa.dao.MovimentoEstoqueDao;
import com.module.jpa.model.Estoque;
import com.module.jpa.model.EstoqueMovimento;
import com.module.jpa.model.Produto;

@Stateless
public class EstoqueEjb implements IEstoqueEjb {

	@Override
	public void inserirProdutoEstoque(Produto produto) {
		
		if (!UtilsJapp.isNullOrZero(produto.getId())){
			EstoqueDao dao = new EstoqueDao();
			Estoque estoque = new Estoque();
			estoque.setId(null);
			estoque.setProduto(produto);
			estoque.setQuantidade(0d);
			estoque.setStatus("1");
			estoque.setDatacontagem(new Date());
			dao.add(estoque);
		}
		
	}

	@Override
	public void inserirMovimentacaoEstoque(EstoqueMovimento movimentoEstoque) {
		MovimentoEstoqueDao dao = new MovimentoEstoqueDao();
		
	}

	@Override
	public List<Estoque> buscarPosicaoEstoque(Estoque estoqueFiltro) {
		EstoqueDao dao = new EstoqueDao();
		List<Estoque> ret = dao.getAll();
		return ret;
	}
	
	


}
