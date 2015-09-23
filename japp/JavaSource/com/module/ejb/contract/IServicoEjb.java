package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Servico;


public interface IServicoEjb {

	List<Servico> buscarServico(Servico servico);

	Servico salvarServico(Servico servico);

	List<Servico> buscarAllServicos();
	
}
