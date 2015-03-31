package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;


@ManagedBean
@SessionScoped
public class ProdutoMb extends BaseMb{

	@EJB
	private IProdutoEjb produtoEjb;

	private Produto produto;
	private List<TipoProduto> itemsTipoProduto;
	
	public ProdutoMb(){		
		this.produto = new Produto();
		this.itemsTipoProduto = new ArrayList<TipoProduto>();   
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<TipoProduto> getItemsTipoProduto() {
		return itemsTipoProduto;
	}

	public void setItemsTipoProduto(List<TipoProduto> itemsTipoProduto) {
		this.itemsTipoProduto = itemsTipoProduto;
	}
	
	
}
