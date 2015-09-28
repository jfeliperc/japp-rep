package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;

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
	private List<Receita> listReceitaSelect;
	private DualListModel<Receita> listReceitaSelecao;
	private List<Cardapio> listCardapio;
	
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		this.listReceita = new ArrayList<Receita>();
		this.listReceitaSelect = new ArrayList<Receita>();
		setexemplo();
		this.listReceitaSelecao = new DualListModel<Receita>(listReceita, listReceitaSelect);
	}
	
	public CardapioMb(){
		this.cardapio = new Cardapio();
		this.listReceita = new ArrayList<Receita>();
		this.listReceitaSelect = new ArrayList<Receita>();
		setexemplo();
		this.listReceitaSelecao = new DualListModel<Receita>(listReceita, listReceitaSelect);
	}

	public void limpar(){
		this.cardapio = new Cardapio();
		this.listReceita = new ArrayList<Receita>();
		this.listReceitaSelect = new ArrayList<Receita>();
		setexemplo();
		this.listReceitaSelecao = new DualListModel<Receita>(listReceita, listReceitaSelect);
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
	
	public void onDrop(DragDropEvent ddEvent) {
        Receita receita = ((Receita) ddEvent.getData());  
        listReceitaSelect.add(receita);
        listReceita.remove(receita);
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

	public List<Receita> getListReceitaSelect() {
		return listReceitaSelect;
	}

	public void setListReceitaSelect(List<Receita> listReceitaSelect) {
		this.listReceitaSelect = listReceitaSelect;
	}

	public DualListModel<Receita> getListReceitaSelecao() {
		return listReceitaSelecao;
	}

	public void setListReceitaSelecao(DualListModel<Receita> listReceitaSelecao) {
		this.listReceitaSelecao = listReceitaSelecao;
	}
	
	public void setexemplo(){
		Receita rec = new Receita();
		rec.setId(1);
		rec.setDescricao("testerererere 001");
		rec.setResumo("res teste 01");
		
		Receita rec2 = new Receita();
		rec2.setId(2);
		rec2.setDescricao("teste 002");
		rec2.setResumo("res teste 02");
		
		Receita rec3 = new Receita();
		rec3.setId(3);
		rec3.setDescricao("teserererererererte 003");
		rec3.setResumo("res teste 03");
		
		listReceita = new ArrayList<Receita>();
		listReceita.add(rec);
		listReceita.add(rec2);
		listReceita.add(rec3);
	}
}
