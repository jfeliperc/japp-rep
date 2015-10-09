package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.Produto;

public class MovimentoEstoqueDao extends Dao<Produto> {

	public List<Produto> findByExample(Produto produto) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Produto> c = cb.createQuery(Produto.class);	    
	    
	    Root<Produto> raiz = c.from(Produto.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(produto, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Produto> query = em.createQuery(c);
	    List<Produto> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Produto produto, CriteriaBuilder cb, Root<Produto> raiz) {
		Predicate predicate = cb.and();
		if ((produto.getId() != null)&&(!"".equals(produto.getId()))&&(0 != produto.getId().intValue())){
			predicate = cb.and(predicate, cb.equal(raiz.get("id"), produto.getId()));
		}
		if ((produto.getNome() != null)&&(!"".equals(produto.getNome()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), produto.getNome()));
		}
		if ((produto.getDescricao() != null)&&(!"".equals(produto.getDescricao()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("descricao"), produto.getDescricao()));
		}
		
		return predicate;
	}
	
}
