package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Acesso;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Rotina;

public interface IAcessoEjb {

	public Acesso cadastrarAcesso(Acesso acesso);
	
	public Acesso buscarAcesso(Acesso acesso);
	
	public List<Acesso> listarAcessos(Acesso acesso);
	
	public void excluirAcesso(Acesso acesso);

	public List<Rotina> listarTodasRotinas();

	public List<Acesso> listarTodosAcessos();

	public List<Acesso> listarAcessos(Pessoa pessoa);
	
}
