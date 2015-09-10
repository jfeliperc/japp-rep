package com.module.ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IServicoEjb;
import com.module.jpa.dao.ServicoDao;
import com.module.jpa.model.Servico;

@Stateless
public class ServicoEjb implements IServicoEjb, Serializable {

	private static final long serialVersionUID = 2727418736797001639L;

	private Servico servico; 
	private ServicoDao dao;

    public ServicoEjb() {
    	this.dao = new ServicoDao();
    }

	@Override
	public List<Servico> buscarServico(Servico servico) {		
		List<Servico> res = dao.findByExample(servico);
		return res;
	}

	@Override
	public Servico salvarServico(Servico servico) {
		if (servico.getId() == null){
			servico.setDatainclusao(new Date());
			
			this.dao.add(servico);
		}else{
			this.dao.update(servico);
		}
		return servico;
	}

	

    
}
