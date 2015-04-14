package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.beanutils.BeanUtils;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.GrupoProdutoDao;
import com.module.jpa.dao.TipoProdutoDao;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;

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
		TipoProdutoDao dao = new TipoProdutoDao();
		try {
			tipoProduto.setDataalteracao(new Date());
			if ((tipoProduto.getId() != null)&&(tipoProduto.getId().intValue() > 0)){			
				dao.update(tipoProduto);			
			}else{
				tipoProduto.setDatainclusao(new Date());
				dao.add(tipoProduto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoProduto;
	}

	@Override
	public GrupoProduto salvarGrupoProduto(GrupoProduto grupoProduto) {
		GrupoProdutoDao dao = new GrupoProdutoDao();
		try {			
			grupoProduto.setDataalteracao(new Date());
			if ((grupoProduto.getId() != null)&&(grupoProduto.getId().intValue() > 0)){				
				dao.update(grupoProduto);
			}else{
				grupoProduto.setDatainclusao(new Date());
				dao.add(grupoProduto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return grupoProduto;
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
