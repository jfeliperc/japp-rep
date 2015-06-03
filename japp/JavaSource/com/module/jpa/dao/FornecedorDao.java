package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.AgenteExterno;

public class FornecedorDao extends Dao<AgenteExterno> {

	public List<AgenteExterno> findByExample(AgenteExterno fornecedor) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<AgenteExterno> c = cb.createQuery(AgenteExterno.class);	    
	    
	    Root<AgenteExterno> raiz = c.from(AgenteExterno.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(fornecedor, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<AgenteExterno> query = em.createQuery(c);
	    List<AgenteExterno> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(AgenteExterno agente, CriteriaBuilder cb, Root<AgenteExterno> raiz) {
		Predicate predicate = cb.and();
		if ((agente.getNome() != null)&&(!"".equals(agente.getNome()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), agente.getNome()));
		}
		if ((agente.getNomecompleto() != null)&&(!"".equals(agente.getNomecompleto()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nomecompleto"), agente.getNomecompleto()));
		}
		if ((agente.getCpf() != null)&&(!"".equals(agente.getCpf()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("cpf"), agente.getCpf()));
		}
		
		return predicate;
	}
	
}
