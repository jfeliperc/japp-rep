package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Cardapio;

public interface ICardapioEjb {

	public Cardapio cadastrarCardapio(Cardapio cardapio);
	
	public Cardapio buscarCardapio(Cardapio cardapio);
	
	public List<Cardapio> listarCardapios(Cardapio cardapio);
	
	public void excluirCardapio(Cardapio cardapio);
	
}
