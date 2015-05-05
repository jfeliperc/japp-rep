package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.GrupoProduto;

public class GrupoProdutoDao extends Dao<GrupoProduto> {

	public GrupoProdutoDao() {		
		super(GrupoProduto.class);
	}

	public List<GrupoProduto> findByExample(GrupoProduto grupo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<GrupoProduto> c = cb.createQuery(GrupoProduto.class);	    
	    
	    Root<GrupoProduto> raiz = c.from(GrupoProduto.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(grupo, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<GrupoProduto> query = em.createQuery(c);
	    List<GrupoProduto> grupos = query.getResultList();
		
		return grupos;
	}

	private Predicate prepararPredicatesByExample(GrupoProduto grupo, CriteriaBuilder cb, Root<GrupoProduto> raiz) {
		Predicate predicate = cb.and();
		if ((grupo.getId() != null)&&(!"".equals(grupo.getId()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("id"), grupo.getId()));
		}
		if ((grupo.getNome() != null)&&(!"".equals(grupo.getNome()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), grupo.getNome()));
		}
		if ((grupo.getDescricao() != null)&&(!"".equals(grupo.getDescricao()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("descricao"), grupo.getDescricao()));
		}
		
		return predicate;
	}
	
}
