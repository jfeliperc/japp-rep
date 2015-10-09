package com.module.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.Fornecedor;

public class FornecedorDao extends Dao<Fornecedor> {

	public FornecedorDao(){
		super(Fornecedor.class);
	}
	
	public List<Fornecedor> findByExample(Fornecedor fornecedor) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Fornecedor> c = cb.createQuery(Fornecedor.class);	    
	    
	    Root<Fornecedor> raiz = c.from(Fornecedor.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(fornecedor, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Fornecedor> query = em.createQuery(c);
	    List<Fornecedor> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Fornecedor fornecedor, CriteriaBuilder cb, Root<Fornecedor> raiz) {
		Predicate predicate = cb.and();
		if ((fornecedor.getNome() != null)&&(!"".equals(fornecedor.getNome()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), fornecedor.getNome()));
		}
		if ((fornecedor.getNomecompleto() != null)&&(!"".equals(fornecedor.getNomecompleto()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nomecompleto"), fornecedor.getNomecompleto()));
		}
		if ((fornecedor.getCpf() != null)&&(!"".equals(fornecedor.getCpf()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("cpf"), fornecedor.getCpf()));
		}
		
		return predicate;
	}
	
}
