package com.module.jpa.dao;

import java.util.List;

import com.module.jpa.model.Contato;
import com.module.jpa.model.Pessoa;

public class ContatoDao extends Dao<Contato> {

	public ContatoDao() {
		super(Contato.class);
	}
	
	public List<Contato> getContatosPessoa(Pessoa pessoa) {
		@SuppressWarnings("unchecked")
		List<Contato> contatos = getEm().createNamedQuery("Contato.findByPessoaAll")
				.setParameter("idPessoa", pessoa.getId()) 
				.getResultList();		
		return contatos;
	}

	public void removeAllByPessoa(Pessoa pessoa) {		
		getEm().getTransaction().begin();
		getEm().createNamedQuery("Contato.removeByPessoaAll").setParameter("idPessoa", pessoa.getId()).executeUpdate();
		getEm().getTransaction().commit();
	}
	
}
