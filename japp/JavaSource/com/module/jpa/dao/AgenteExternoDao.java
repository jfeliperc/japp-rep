package com.module.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.module.jpa.model.AgenteExterno;

public class AgenteExternoDao extends Dao<AgenteExterno> {

	public AgenteExternoDao() {
		super(AgenteExterno.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<AgenteExterno> buscarTodosFornecedores(){
		List<AgenteExterno> agentes = (ArrayList<AgenteExterno>)getEm().createNamedQuery("AgenteExterno.findByTipo").setParameter("tipo", "F").getResultList();
		return agentes;		
	}
	
	@SuppressWarnings("unchecked")
	public List<AgenteExterno> buscarTodosClientes(){
		List<AgenteExterno> agentes = (ArrayList<AgenteExterno>)getEm().createNamedQuery("AgenteExterno.findByTipo").setParameter("tipo", "C").getResultList();
		return agentes;		
	}

	public List<AgenteExterno> findByExample(AgenteExterno agente) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<AgenteExterno> c = cb.createQuery(AgenteExterno.class);	    
	    
	    Root<AgenteExterno> raiz = c.from(AgenteExterno.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(agente, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<AgenteExterno> query = em.createQuery(c);
	    List<AgenteExterno> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(AgenteExterno agente, CriteriaBuilder cb, Root<AgenteExterno> raiz) {
		Predicate predicate = cb.and();
		if (!StringUtils.isBlank(agente.getNome())){
			predicate = cb.and(predicate, cb.equal(raiz.get("nome"), agente.getNome()));
		}
		if (!StringUtils.isBlank(agente.getNomecompleto())){
			predicate = cb.and(predicate, cb.equal(raiz.get("nomecompleto"), agente.getNomecompleto()));
		}
		if (!StringUtils.isBlank(agente.getCpf())){
			predicate = cb.and(predicate, cb.equal(raiz.get("cpf"), agente.getCpf()));
		}		
		if (!StringUtils.isBlank(agente.getRazaoSocial())){
			predicate = cb.and(predicate, cb.equal(raiz.get("razaoSocial"), agente.getRazaoSocial()));
		}
		
		if (!StringUtils.isBlank(agente.getNomeFantasia())){
			predicate = cb.and(predicate, cb.equal(raiz.get("nomefantasia"), agente.getNomeFantasia()));
		}
		if (!StringUtils.isBlank(agente.getCnpj())){
			predicate = cb.and(predicate, cb.equal(raiz.get("cnpj"), agente.getCnpj()));
		}		
		if (!StringUtils.isBlank(agente.getDocumento())){
			predicate = cb.and(predicate, cb.equal(raiz.get("documento"), agente.getDocumento()));
		}		
		if (!StringUtils.isBlank(agente.getTipo())){
			predicate = cb.and(predicate, cb.equal(raiz.get("tipo"), agente.getTipo()));
		}
		return predicate;
	}
	
}
