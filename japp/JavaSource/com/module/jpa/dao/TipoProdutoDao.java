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

	private Predicate prepararPredicatesByExample(TipoProduto tipo, CriteriaBuilder cb, Root<TipoProduto> raiz) {
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
