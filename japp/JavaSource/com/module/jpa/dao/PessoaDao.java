package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.Contato;
import com.module.jpa.model.Pessoa;

public class PessoaDao extends Dao<Pessoa> {

	public PessoaDao() {
		super(Pessoa.class);
	}

	public Pessoa getByLogin(String login) {		
		Pessoa pessoa = (Pessoa)getEm().createNamedQuery("Pessoa.findByLogin")
				.setParameter("login", login) 
				.getSingleResult();		
		return pessoa;
	}
	
	public List<Pessoa> findByExample(Pessoa pessoa) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Pessoa> c = cb.createQuery(Pessoa.class);	    
	    
	    Root<Pessoa> raiz = c.from(Pessoa.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(pessoa, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Pessoa> query = em.createQuery(c);
	    List<Pessoa> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Pessoa pessoa, CriteriaBuilder cb, Root<Pessoa> raiz) {
		Predicate predicate = cb.and();
		if ((pessoa.getNome() != null)&&(!"".equals(pessoa.getNome()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), pessoa.getNome()));
		}
		if ((pessoa.getNomecompleto() != null)&&(!"".equals(pessoa.getNomecompleto()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nomecompleto"), pessoa.getNomecompleto()));
		}
		if ((pessoa.getCpf() != null)&&(!"".equals(pessoa.getCpf()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("cpf"), pessoa.getCpf()));
		}
		
		return predicate;
	}

	public List<Contato> getContatosPessoa(Pessoa pessoa) {
		@SuppressWarnings("unchecked")
		List<Contato> contatos = getEm().createNamedQuery("Contato.findByPessoaAll")
				.setParameter("idPessoa", pessoa.getId()) 
				.getResultList();		
		return contatos;
	}

	
	
}
