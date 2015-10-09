package com.module.ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IAtividadeEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.AtividadeDao;
import com.module.jpa.model.Atividade;

@Stateless
public class AtividadeEjb implements IAtividadeEjb, Serializable {

	private static final long serialVersionUID = 2727418736797001639L;

	//private Atividade atividade; 
	private AtividadeDao dao;

    public AtividadeEjb() {
    	this.dao = new AtividadeDao();
    }

	@Override
	public List<Atividade> buscarAtividade(Atividade atividade) {		
		List<Atividade> res = dao.findByExample(atividade);
		return res;
	}

	@Override
	public Atividade salvarAtividade(Atividade atividade) {
		atividade.setDataalteracao(new Date());
		
		atividade.setTipoAtividade(null);
		
		if (UtilsJapp.isNullOrZero(atividade.getId())){
			atividade.setDatainclusao(new Date());
			atividade.setId(null);
			
			this.dao.add(atividade);
		}else{
			this.dao.update(atividade);
		}
		return atividade;		
	}

	@Override
	public List<Atividade> buscarAllAtividades() {
		List<Atividade> ret = dao.getAll();
		return ret;
	}

}
