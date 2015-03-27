package com.module.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.ITesteEjb;
import com.module.ejb.TesteEjb;

@ManagedBean
@SessionScoped
public class BaseMb {

//	@EJB(beanInterface=IDao.class)
//	private Dao<TipoPessoa> daoTeste;
	
	private String name;
	
	public String testeJpa(){		
		
		return "greeting";
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String sayHello() {
		
		ITesteEjb tes = new TesteEjb();
		tes.processaTeste();
		
		return "greeting";
	}
	
}
