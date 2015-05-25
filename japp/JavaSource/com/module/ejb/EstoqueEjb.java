package com.module.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IEstoqueEjb;
import com.module.jpa.dao.GrupoProdutoDao;
import com.module.jpa.dao.ProdutoDao;
import com.module.jpa.dao.TipoProdutoDao;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;

@Stateless
public class EstoqueEjb implements IEstoqueEjb {


	@Override
	public List<Produto> listarProdutos(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> ret = new ArrayList<Produto>();		
		ret = dao.findByExample(produto);		
		return ret;
	}

	@Override
	public List<TipoProduto> buscarTipoProduto(TipoProduto tipoProduto) {
		TipoProdutoDao dao = new TipoProdutoDao();
		List<TipoProduto> ret = new ArrayList<TipoProduto>();
		tipoProduto.setId(tipoProduto.getId() != null && tipoProduto.getId().intValue() == 0 ? null : tipoProduto.getId());
		if ((tipoProduto.getId() == null)
				&&((tipoProduto.getNome() == null)||("".equals(tipoProduto.getNome())))
				&&((tipoProduto.getDescricao() == null)||("".equals(tipoProduto.getDescricao())))){
			ret = dao.getAll();
		}else{
			ret = dao.findByExample(tipoProduto);
		}		
		return ret;
	}

	@Override
	public List<GrupoProduto> buscarGrupoProduto(GrupoProduto grupoProduto) {
		GrupoProdutoDao dao = new GrupoProdutoDao();
		List<GrupoProduto> ret = new ArrayList<GrupoProduto>();
		grupoProduto.setId(grupoProduto.getId() != null && grupoProduto.getId().intValue() == 0 ? null : grupoProduto.getId());
		if ((grupoProduto.getId() == null)				
				&&((grupoProduto.getNome() == null)||("".equals(grupoProduto.getNome())))
				&&((grupoProduto.getDescricao() == null)||("".equals(grupoProduto.getDescricao())))
				&&((grupoProduto.getGrupoPai() == null)||(grupoProduto.getGrupoPai().intValue() == 0))){
			ret = dao.getAll();
		}else{
			ret = dao.findByExample(grupoProduto);
		}		
		return ret;
	}

	@Override
	public List<GrupoProduto> buscarAllGrupoProduto() {		
		GrupoProdutoDao dao = new GrupoProdutoDao();
		List<GrupoProduto> ret = dao.getAll();
		return ret;
	}
	
	@Override
	public List<TipoProduto> buscarAllTipoProduto() {		
		TipoProdutoDao dao = new TipoProdutoDao();
		List<TipoProduto> ret = dao.getAll();
		return ret;
	}


}
