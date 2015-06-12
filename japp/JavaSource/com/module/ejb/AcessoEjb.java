package com.module.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IAcessoEjb;
import com.module.jpa.dao.AcessoDao;
import com.module.jpa.dao.RotinaDao;
import com.module.jpa.model.Acesso;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Rotina;

@Stateless
public class AcessoEjb implements IAcessoEjb, Serializable {

	private static final long serialVersionUID = 2727418736797001639L;

	private Acesso acesso; 
	private AcessoDao dao;
	private RotinaDao rotinaDao;

    public AcessoEjb() {
    	this.dao = new AcessoDao();
    	this.rotinaDao = new RotinaDao();
    }

	@Override
	public Acesso cadastrarAcesso(Acesso acesso) {
		
		return null;
	}

	@Override
	public Acesso buscarAcesso(Acesso acesso) {
		Acesso ret = null;
		if ((acesso.getPessoa() != null)&&(acesso.getRotina1() != null)){
			
		}
		return ret;
	}

	@Override
	public List<Acesso> listarAcessos(Acesso acesso) {
		List<Acesso> ret = new ArrayList<Acesso>();
		if ((acesso.getPessoa() != null)&&(acesso.getRotina1() != null)){
			this.dao.getAcessoPorPessoa(acesso.getPessoa());
		}
		return null;
	}

	@Override
	public void excluirAcesso(Acesso acesso) {
		// TODO Auto-generated method stub		
	}

	@Override
	public List<Rotina> listarTodasRotinas() {
		List<Rotina> rotinas = rotinaDao.getRotinas();
		return rotinas;		
	}

	@Override
	public List<Acesso> listarTodosAcessos() {
		List<Acesso> acessos = dao.getAll();
		return acessos;
	}

	@Override
	public List<Acesso> listarAcessos(Pessoa pessoa) {
		List<Acesso> ret = new ArrayList<Acesso>();
		if ((acesso.getPessoa() != null)&&(acesso.getRotina1() != null)){
			ret = this.dao.getAcessoPorPessoa(acesso.getPessoa());
		}
		return ret;
	}

    
}
