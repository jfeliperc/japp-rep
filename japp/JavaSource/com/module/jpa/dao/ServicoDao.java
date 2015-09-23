package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.module.jpa.model.Servico;

public class ServicoDao extends Dao<Servico> {

	public ServicoDao() {
		super(Servico.class);
	}

	public List<Servico> findByExample(Servico servico) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Servico> c = cb.createQuery(Servico.class);	    
	    
	    Root<Servico> raiz = c.from(Servico.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(servico, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Servico> query = em.createQuery(c);
	    List<Servico> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Servico servico, CriteriaBuilder cb, Root<Servico> raiz) {
		Predicate predicate = cb.and();
		if ((servico.getId() != null)&&(servico.getId().intValue() > 0 )){
			predicate = cb.and(predicate, cb.equal(raiz.get("id"), servico.getId()));
		}
		if (!StringUtils.isBlank(servico.getNome())){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), servico.getNome()));
		}
		if (!StringUtils.isBlank(servico.getDescricao())){
			predicate = cb.and(predicate, cb.equal(raiz.get("descricao"), servico.getDescricao()));
		}
		
		return predicate;
	}
	
}
