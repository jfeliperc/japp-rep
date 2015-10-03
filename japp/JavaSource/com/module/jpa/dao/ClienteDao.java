package com.module.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.module.jpa.model.Cliente;

public class ClienteDao extends Dao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Cliente> buscarTodosFornecedores(){
//		List<Cliente> agentes = (ArrayList<Cliente>)getEm().createNamedQuery("Cliente.findByTipo").setParameter("tipo", "F").getResultList();
//		return agentes;		
//	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodosClientes(){
		List<Cliente> agentes = (ArrayList<Cliente>)getEm().createNamedQuery("Cliente.findByTipo").setParameter("tipo", "C").getResultList();
		return agentes;		
	}

	public List<Cliente> findByExample(Cliente agente) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);	    
	    
	    Root<Cliente> raiz = c.from(Cliente.class);
	    c.select(raiz);	  
	    Predicate predicate = prepararPredicatesByExample(agente, cb, raiz);
	    c.where(predicate);
	    
	    TypedQuery<Cliente> query = em.createQuery(c);
	    List<Cliente> emps = query.getResultList();
		
		return emps;
	}

	private Predicate prepararPredicatesByExample(Cliente agente, CriteriaBuilder cb, Root<Cliente> raiz) {
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
