package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Receita;
import com.module.jpa.model.TipoReceita;

public interface IReceitaEjb {

	public Receita cadastrarReceita(Receita receita);
	
	public Receita buscarReceita(Receita receita);
	
	public List<Receita> listarReceitas(Receita receita);
	
	public void excluirReceita(Receita receita);

	public List<Receita> buscarAllReceitas();

	public List<TipoReceita> buscarAllTipoReceitas();
	
	public List<TipoReceita> buscarTipoReceita(TipoReceita tipoReceita);

	public TipoReceita salvarTipoReceita(TipoReceita tipoReceita);
	
}
