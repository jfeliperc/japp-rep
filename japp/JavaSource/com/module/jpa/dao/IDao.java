package com.module.jpa.dao;

import java.util.List;


public interface IDao<T> {

	void add(T obj);
	 
    void update(T obj);
 
    void delete(T obj);
 
    T getById(int id);
 
    List<T> getAll();

}
