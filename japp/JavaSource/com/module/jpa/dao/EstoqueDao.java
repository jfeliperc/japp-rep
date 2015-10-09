package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.Estoque;

public class EstoqueDao extends Dao<Estoque> {
	
	public EstoqueDao(){
		super(Estoque.class);
	}

	public List<Estoque> findByExample(Estoque estoque) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Estoque> c = cb.createQuery(Estoque.class);	    
	    
	    Root<Estoque> raiz = c.from(Estoque.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(estoque, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Estoque> query = em.createQuery(c);
	    List<Estoque> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Estoque estoque, CriteriaBuilder cb, Root<Estoque> raiz) {
		Predicate predicate = cb.and();
		if ((estoque.getId() != null)&&(!"".equals(estoque.getId()))&&(0 != estoque.getId().intValue())){
			predicate = cb.and(predicate, cb.equal(raiz.get("id"), estoque.getId()));
		}
//		if ((estoque.getNome() != null)&&(!"".equals(estoque.getNome()))){
//			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), estoque.getNome()));
//		}
//		if ((estoque.getDescricao() != null)&&(!"".equals(estoque.getDescricao()))){
//			predicate = cb.and(predicate, cb.equal(raiz.get("descricao"), estoque.getDescricao()));
//		}
		
		return predicate;
	}
	
}
