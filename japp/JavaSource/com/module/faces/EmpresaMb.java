package com.module.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.model.Produto;


@ManagedBean
@SessionScoped
public class EmpresaMb extends BaseMb{

	@EJB
	private IProdutoEjb produtoEjb;

	private Produto produto;
	
	public String testeEjb(){
		
		produtoEjb.testeTipoPessoa();
        
		return "login";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
