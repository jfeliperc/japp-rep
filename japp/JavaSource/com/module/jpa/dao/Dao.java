package com.module.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class Dao<T> implements IDao<T> {

	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("japp");	
	private EntityManager em; 
 
	public Dao() {
		this.em  = emf.createEntityManager();
	}
	
    @Override
    public void add(T t) {
    	if (t != null){    		
    		em.getTransaction().begin();
    	    if (!em.contains(t)) {
    	        em.persist(t);
    	    }    	    
    	    em.getTransaction().commit();
    	}
    }
 
    @Override
    public void update(T user) {
        em.merge(user);
    }
 
    @Override
    public void delete(T user) {
        em.remove(
            em.contains(user) ? user : em.merge(user)
        );
    }
 
    @Override
    public T getById(int id) {
        return null; //em.find(T.class, id);
    }
 
    @Override
    public List<T> getAll() {
        return null; //em.createNamedQuery("User.getAll", T.class).getResultList();
    }
	
}
