package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.TipoProduto;


@ManagedBean
@SessionScoped
public class TipoGrupoProdutoMb extends BaseMb{

	@EJB
	private IProdutoEjb produtoEjb;

	private TipoProduto tipoProduto;
	private GrupoProduto grupoProduto;
	private List<TipoProduto> listTipoProduto;
	private List<GrupoProduto> listGrupoProduto;
	private List<GrupoProduto> listGrupoProdutoPai;
	
	public TipoGrupoProdutoMb(){		
		limparTipoProduto();
		limparGrupoProduto();
	}

	public void limparTipoProduto(){
		this.tipoProduto = new TipoProduto();
		this.listTipoProduto = new ArrayList<TipoProduto>();  
	}
	
	public void buscarTipoProduto(){
		
	}
	
	public void salvarTipoProduto(){

	}
	
	public void excluirTipoProduto(){

	}
	
	public void limparGrupoProduto(){
		this.grupoProduto = new GrupoProduto();
		this.listGrupoProduto = new ArrayList<GrupoProduto>();
	}
	
	public void buscarGrupoProduto(){
		
	}
	
	public void salvarGrupoProduto(){

	}
	
	public void excluirGrupoProduto(){

	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public List<TipoProduto> getListTipoProduto() {
		return listTipoProduto;
	}

	public void setListTipoProduto(List<TipoProduto> listTipoProduto) {
		this.listTipoProduto = listTipoProduto;
	}

	public List<GrupoProduto> getListGrupoProduto() {
		return listGrupoProduto;
	}

	public void setListGrupoProduto(List<GrupoProduto> listGrupoProduto) {
		this.listGrupoProduto = listGrupoProduto;
	}

	public List<GrupoProduto> getListGrupoProdutoPai() {
		return listGrupoProdutoPai;
	}

	public void setListGrupoProdutoPai(List<GrupoProduto> listGrupoProdutoPai) {
		this.listGrupoProdutoPai = listGrupoProdutoPai;
	}

	
}
