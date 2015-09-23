package com.module.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.module.jpa.model.Empresa;

public class EmpresaDao extends Dao<Empresa> {

	public List<Empresa> getAllEmpresas() {		
		List<Empresa> empresas = (ArrayList<Empresa>)getEm().createNamedQuery("Empresa.findAll").getResultList();		
		return empresas;
	}
	
	public List<Empresa> findByExample(Empresa empresa) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Empresa> c = cb.createQuery(Empresa.class);	    
	    
	    Root<Empresa> raiz = c.from(Empresa.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(empresa, cb, raiz);
	    predicate = cb.and(predicate, cb.isNull(raiz.get("matriz")));
	    c.where(predicate);
	    
	    TypedQuery<Empresa> query = em.createQuery(c);
	    List<Empresa> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Empresa empresa, CriteriaBuilder cb, Root<Empresa> raiz) {
		Predicate predicate = cb.and();
		if ((empresa.getNomeFantasia() != null)&&(!"".equals(empresa.getNomeFantasia()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("nomeFantasia"), empresa.getNomeFantasia()));
		}
		if ((empresa.getRazaoSocial() != null)&&(!"".equals(empresa.getRazaoSocial()))){
			predicate = cb.and(predicate, cb.equal(raiz.get("razaoSocial"), empresa.getRazaoSocial()));
		}
		
		return predicate;
	}

	public List<Empresa> getFiliais(Empresa empresa) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Empresa> c = cb.createQuery(Empresa.class);	    
	    
	    Root<Empresa> raiz = c.from(Empresa.class);
	    c.select(raiz);	  
	    Predicate predicate = cb.equal(raiz.get("matriz"), empresa.getEmpresaId());
	    c.where(predicate);
	    
	    TypedQuery<Empresa> query = em.createQuery(c);
	    List<Empresa> emps = query.getResultList();
		
		return emps;
	}
	
}
