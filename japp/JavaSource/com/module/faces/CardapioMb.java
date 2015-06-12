package com.module.faces;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.ICardapioEjb;
import com.module.jpa.model.Cardapio;
import com.module.jpa.model.Produto;
import com.module.jpa.model.Receita;


@ManagedBean
@SessionScoped
public class CardapioMb extends BaseMb{

	@EJB
	private ICardapioEjb cardapioEjb;

	private Cardapio cardapio;
	private Receita receita;
	private List<Produto> listProduto;
	private List<Receita> listReceita;
	private List<Cardapio> listCardapio;
	
	@PostConstruct
	public void construcao(){
		
	}
	
	public CardapioMb(){		
		
	}

	public void limpar(){
		
	}
	
	public void buscar(){
//		this.listProduto = produtoEjb.listarProdutos(this.produto);
//		if ((this.listProduto != null)&&(!this.listProduto.isEmpty())&&(this.listProduto.size() == 1)){
//			this.produto = this.listProduto.get(0);
//			this.listProduto.clear();
//		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			
		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		
		return ret;
	}

	public void editar(Receita us){
		this.receita = us;
	}
	
	public void excluir(){
//		this.produtoEjb.excluirProduto(this.produto);
		buscar();
	}
	
	public void limparDetalhe(){
		
	}
	
	public void salvarDetalhe(){
		
	}
	
	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

	public List<Receita> getListReceita() {
		return listReceita;
	}

	public void setListReceita(List<Receita> listReceita) {
		this.listReceita = listReceita;
	}

	public List<Cardapio> getListCardapio() {
		return listCardapio;
	}

	public void setListCardapio(List<Cardapio> listCardapio) {
		this.listCardapio = listCardapio;
	}
	
}
