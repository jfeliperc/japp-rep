package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		this.listGrupoProdutoPai = produtoEjb.buscarAllGrupoProduto();		
	}
	
	public TipoGrupoProdutoMb(){		
		limparTipoProduto();
		limparGrupoProduto();
	}

	public void limparTipoProduto(){
		this.tipoProduto = new TipoProduto();
		this.listTipoProduto = new ArrayList<TipoProduto>();  
	}
	
	public void buscarTipoProduto(){
		this.listTipoProduto = produtoEjb.buscarTipoProduto(this.tipoProduto);
	}
	
	public void salvarTipoProduto(){
		if (validarSalvarTipoProduto()){
			this.tipoProduto = produtoEjb.salvarTipoProduto(this.tipoProduto);
			buscarTipoProduto();
		}
	}
	
	private boolean validarSalvarTipoProduto() {
		boolean ret = true;
		if ((this.tipoProduto.getNome() == null)||("".equals(this.tipoProduto.getNome()))){
			ret = false;
			addMsgError("Campo nome é obrigatório. (Tipo Produto)");
		}
		if ((this.tipoProduto.getDescricao() == null)||("".equals(this.tipoProduto.getDescricao()))){
			ret = false;
			addMsgError("Campo descrição é obrigatório. (Tipo Produto)");
		}
		return ret;
	}

	public void excluirTipoProduto(){

	}
	
	public void limparGrupoProduto(){
		this.grupoProduto = new GrupoProduto();
		this.listGrupoProduto = new ArrayList<GrupoProduto>();
	}
	
	public void buscarGrupoProduto(){
		this.listGrupoProduto = produtoEjb.buscarGrupoProduto(this.grupoProduto);
	}
	
	public void salvarGrupoProduto(){
		if (validarSalvarGrupoProduto()){
			this.grupoProduto = produtoEjb.salvarGrupoProduto(this.grupoProduto);
			buscarGrupoProduto();
		}
	}
	
	private boolean validarSalvarGrupoProduto() {
		boolean ret = true;
		if ((this.grupoProduto.getNome() == null)||("".equals(this.grupoProduto.getNome()))){
			ret = false;
			addMsgError("Campo nome é obrigatório. (Grupo Produto)");
		}
		if ((this.grupoProduto.getDescricao() == null)||("".equals(this.grupoProduto.getDescricao()))){
			ret = false;
			addMsgError("Campo descrição é obrigatório. (Grupo Produto)");
		}
		return ret;
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
