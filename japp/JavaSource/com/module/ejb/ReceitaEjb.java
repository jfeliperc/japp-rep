package com.module.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IReceitaEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.TipoProdutoDao;
import com.module.jpa.dao.TipoReceitaDao;
import com.module.jpa.model.Receita;
import com.module.jpa.model.TipoProduto;
import com.module.jpa.model.TipoReceita;

@Stateless
public class ReceitaEjb implements IReceitaEjb {

	@Override
	public Receita cadastrarReceita(Receita receita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receita buscarReceita(Receita receita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receita> listarReceitas(Receita receita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirReceita(Receita receita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Receita> buscarAllReceitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoReceita> buscarTipoReceita(TipoReceita tipoReceita) {
		TipoReceitaDao dao = new TipoReceitaDao();
		List<TipoReceita> ret = new ArrayList<TipoReceita>();
		
		tipoReceita.setId(UtilsJapp.isNullOrZero(tipoReceita.getId()) ? null : tipoReceita.getId());
		if ((tipoReceita.getId() == null)
				&&((tipoReceita.getNome() == null)||("".equals(tipoReceita.getNome())))
				&&((tipoReceita.getDescricao() == null)||("".equals(tipoReceita.getDescricao())))){
			ret = dao.getAll();
		}else{
			ret = dao.findByExample(tipoReceita);
		}		
		return ret;
	}

	@Override
	public TipoReceita salvarTipoReceita(TipoReceita tipoReceita) {
		TipoReceitaDao dao = new TipoReceitaDao();
		try {
			tipoReceita.setDataalteracao(new Date());
			if (!UtilsJapp.isNullOrZero(tipoReceita.getId())){			
				dao.update(tipoReceita);			
			}else{
				tipoReceita.setDatainclusao(new Date());
				tipoReceita.setId(null);
				dao.add(tipoReceita);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoReceita;
	}

	@Override
	public List<TipoReceita> buscarAllTipoReceitas() {
		TipoReceitaDao dao = new TipoReceitaDao();
		return dao.getAll();
	}

	
	
}
