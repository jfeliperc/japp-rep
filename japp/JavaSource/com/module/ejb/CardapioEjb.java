package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.ICardapioEjb;
import com.module.jpa.model.Cardapio;

@Stateless
public class CardapioEjb implements ICardapioEjb {

	@Override
	public Cardapio cadastrarCardapio(Cardapio cardapio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardapio buscarCardapio(Cardapio cardapio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cardapio> listarCardapios(Cardapio cardapio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirCardapio(Cardapio cardapio) {
		// TODO Auto-generated method stub
		
	}
		
}
