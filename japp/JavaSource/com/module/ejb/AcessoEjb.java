package com.module.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IAcessoEjb;
import com.module.jpa.model.Acesso;
import com.module.jpa.model.Pessoa;

@Stateless
public class AcessoEjb implements IAcessoEjb, Serializable {

	private static final long serialVersionUID = 2727418736797001639L;

	private Acesso current;   

    public AcessoEjb() {
    }

	@Override
	public Acesso cadastrarAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acesso buscarAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acesso> listarAcessos(Acesso acesso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void solicitarCadastro(Acesso acesso, Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

    
}
