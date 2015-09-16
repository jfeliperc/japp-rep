package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.TipoReceita;

public class TipoReceitaDao extends Dao<TipoReceita> {

	public TipoReceitaDao() {
		super(TipoReceita.class);
	}

	public List<TipoReceita> findByExample(TipoReceita tipoReceita) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<TipoReceita> c = cb.createQuery(TipoReceita.class);	    
	    
	    Root<TipoReceita> raiz = c.from(TipoReceita.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(tipoReceita, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<TipoReceita> query = em.createQuery(c);
	    List<TipoReceita> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(TipoReceita tipo, CriteriaBuilder cb, Root<TipoReceita> raiz) {
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
