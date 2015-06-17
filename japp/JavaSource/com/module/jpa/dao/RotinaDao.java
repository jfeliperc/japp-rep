package com.module.jpa.dao;

import java.util.List;

import com.module.jpa.model.Rotina;

public class RotinaDao extends Dao<Rotina>{
	
	public RotinaDao() {
		super(Rotina.class);
	}

	public List<Rotina> getRotinas() {		
		return getAll();
	}

}
