package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;


@ManagedBean
@SessionScoped
public class ProdutoMb extends BaseMb{

	@EJB
	private IProdutoEjb produtoEjb;

	private Produto produto;
	private List<Produto> listProduto;
	private List<TipoProduto> itemsTipoProduto;
	private List<GrupoProduto> itemsGrupoProduto;
	
	@PostConstruct
	public void construcao(){
		itemsTipoProduto = this.produtoEjb.buscarAllTipoProduto();
		itemsGrupoProduto = this.produtoEjb.buscarAllGrupoProduto();
	}
	
	public ProdutoMb(){		
		this.produto = new Produto();
		this.itemsTipoProduto = new ArrayList<TipoProduto>();   
	}

	public void limpar(){
		this.produto = new Produto();
		this.listProduto = new ArrayList<Produto>();
	}
	
	public void buscar(){
		this.listProduto = produtoEjb.listarProdutos(this.produto);
		if ((this.listProduto != null)&&(!this.listProduto.isEmpty())&&(this.listProduto.size() == 1)){
			this.produto = this.listProduto.get(0);
			this.listProduto.clear();
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			this. produto = this.produtoEjb.cadastrarProduto(this.produto);
		}
	}
	
	private boolean validarSalvar() {
		return true;
	}

	public void excluir(){

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

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}
	
}
