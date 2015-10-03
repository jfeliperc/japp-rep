package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Atividade;


public interface IAtividadeEjb {
	
	List<Atividade> buscarAtividade(Atividade atividade);

	Atividade salvarAtividade(Atividade atividade);

	List<Atividade> buscarAllAtividades();
	
}
