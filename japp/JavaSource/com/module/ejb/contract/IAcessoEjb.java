package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Acesso;
import com.module.jpa.model.Usuario;

public interface IAcessoEjb {

	public Acesso cadastrarAcesso(Acesso acesso);
	
	public Acesso buscarAcesso(Acesso acesso);
	
	public List<Acesso> listarAcessos(Acesso acesso);
	
	public void excluirAcesso(Acesso acesso);

	public void solicitarCadastro(Acesso acesso, Usuario usuario);
	
}
