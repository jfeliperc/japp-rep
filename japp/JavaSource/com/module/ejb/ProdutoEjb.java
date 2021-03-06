package com.module.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IProdutoEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.GrupoProdutoDao;
import com.module.jpa.dao.ProdutoDao;
import com.module.jpa.dao.TipoProdutoDao;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;

@Stateless
public class ProdutoEjb implements IProdutoEjb {

	
	@Override
	public Produto cadastrarProduto(Produto produto) {
						
		Dao<Produto> dao = new Dao<Produto>();
		produto.setDataalteracao(new Date());

		if ((produto.getEmpresa() == null)||(UtilsJapp.isNullOrZero(produto.getEmpresa().getId()))){
			produto.setEmpresa(null);
		}
		if ((produto.getTipoProduto() == null)||(UtilsJapp.isNullOrZero(produto.getTipoProduto().getId()))){
			produto.setTipoProduto(null);
		}
		if ((produto.getGrupoProduto() == null)||(UtilsJapp.isNullOrZero(produto.getGrupoProduto().getId()))){
			produto.setGrupoProduto(null);
		}
		
		if (UtilsJapp.isNullOrZero(produto.getId())){			
			produto.setId(null);			
			produto.setDatainclusao(new Date());
			dao.add(produto);
		}else{
			dao.update(produto);
		}
		
		return produto;
	}

	@Override
	public Produto buscarProduto(Produto produto) {
		Produto ret = new Produto();		
		List<Produto> lst = listarProdutos(produto);
		if (!lst.isEmpty()){
			ret = lst.get(0);
		}		
		return ret;
	}

	@Override
	public List<Produto> listarProdutos(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> ret = new ArrayList<Produto>();		
		ret = dao.findByExample(produto);		
		return ret;
	}

	@Override
	public void excluirProduto(Produto produto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoProduto> buscarTipoProduto(TipoProduto tipoProduto) {
		TipoProdutoDao dao = new TipoProdutoDao();
		List<TipoProduto> ret = new ArrayList<TipoProduto>();
		tipoProduto.setId(UtilsJapp.isNullOrZero(tipoProduto.getId()) ? null : tipoProduto.getId());
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
		grupoProduto.setId(UtilsJapp.isNullOrZero(grupoProduto.getId()) ? null : grupoProduto.getId());
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
	public TipoProduto salvarTipoProduto(TipoProduto tipoProduto) {
		TipoProdutoDao dao = new TipoProdutoDao();
		try {
			tipoProduto.setDataalteracao(new Date());
			if (!UtilsJapp.isNullOrZero(tipoProduto.getId())){			
				dao.update(tipoProduto);			
			}else{
				tipoProduto.setDatainclusao(new Date());
				tipoProduto.setId(null);
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
			if (!UtilsJapp.isNullOrZero(grupoProduto.getId())){					
				dao.update(grupoProduto);
			}else{
				grupoProduto.setDatainclusao(new Date());
				grupoProduto.setId(null);
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

	@Override
	public List<Produto> buscarAllProdutos() {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> ret = dao.getAll();
		return ret;
	}


}
