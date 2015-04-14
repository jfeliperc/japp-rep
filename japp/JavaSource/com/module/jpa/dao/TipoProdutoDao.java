package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.TipoProduto;

public class TipoProdutoDao extends Dao<TipoProduto> {

	public TipoProdutoDao() {
		super(TipoProduto.class);
	}

	public List<TipoProduto> findByExample(TipoProduto tipoProduto) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<TipoProduto> c = cb.createQuery(TipoProduto.class);	    
	    
	    Root<TipoProduto> raiz = c.from(TipoProduto.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(tipoProduto, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<TipoProduto> query = em.createQuery(c);
	    List<TipoProduto> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(TipoProduto tipoProduto, CriteriaBuilder cb, Root<TipoProduto> raiz) {
		Predicate predicate = cb.and();
//		if ((tipoProduto.getNomeFantasia() != null)&&(!"".equals(tipoProduto.getNomeFantasia()))){
//			predicate = cb.and(predicate, cb.equal(raiz.get("nomefantasia"), tipoProduto.getNomeFantasia()));
//		}
//		if ((tipoProduto.getRazaoSocial() != null)&&(!"".equals(tipoProduto.getRazaoSocial()))){
//			predicate = cb.and(predicate, cb.equal(raiz.get("razaosocial"), tipoProduto.getRazaoSocial()));
//		}
		
		return predicate;
	}
	
}
