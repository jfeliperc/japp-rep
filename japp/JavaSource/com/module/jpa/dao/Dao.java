package com.module.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
//@Transactional
public class Dao<T> implements IDao<T> {

	private Class<T> entityClass;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("japp");	
	protected EntityManager em; 
 
	public Dao() {
		this.em  = emf.createEntityManager();
	}
	
	public Dao(Class<T> entityClass) {
		this.em  = emf.createEntityManager();
        this.entityClass = entityClass;
    }
	
	protected EntityManager getEm(){
		return this.em;
	}
	
    @Override
    public void add(T obj) {
    	if (obj != null){    		
    		em.getTransaction().begin();
    	    if (!em.contains(obj)) {
    	        em.persist(obj);
    	    }    	    
    	    em.getTransaction().commit();
    	}
    }
 
    @Override
    public void update(T obj) {
    	if (obj != null){    		
    		em.getTransaction().begin();
    	    if (!em.contains(obj)) {
    	        em.merge(obj);
    	        em.flush();
    	    }    	    
    	    em.getTransaction().commit();
    	}
//    	em.merge(obj);
//        em.flush();
    }
 
    @Override
    public void delete(T obj) {
        em.remove(
            em.contains(obj) ? obj : em.merge(obj)
        );
    }
 
    @Override
    public T getById(int id) {
    	return em.find(entityClass, id);
    }
 
    @SuppressWarnings("rawtypes")
	@Override
    public List<T> getAll() {
    	CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    
    public List<T> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
