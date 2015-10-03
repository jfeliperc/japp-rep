package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.Atividade;

public class AtividadeDao extends Dao<Atividade> {

	public AtividadeDao() {
		super(Atividade.class);
	}

	public List<Atividade> findByExample(Atividade atividade) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Atividade> c = cb.createQuery(Atividade.class);	    
	    
	    Root<Atividade> raiz = c.from(Atividade.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(atividade, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Atividade> query = em.createQuery(c);
	    List<Atividade> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Atividade tipo, CriteriaBuilder cb, Root<Atividade> raiz) {
		Predicate predicate = cb.and();
		if ((tipo.getId() != null)&&(!"".equals(tipo.getId()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("id"), tipo.getId()));
		}
		if ((tipo.getNome() != null)&&(!"".equals(tipo.getNome()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), tipo.getNome()));
		}
		if ((tipo.getDescricao() != null)&&(!"".equals(tipo.getDescricao()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("descricao"), tipo.getDescricao()));
		}
		
		return predicate;
	}
	
}
