package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IEstoqueEjb;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Estoque;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.TipoProduto;


@ManagedBean
@SessionScoped
public class EstoqueMb extends BaseMb{

	@EJB
	private IEstoqueEjb estoqueEjb;

	private List<Produto> listProduto;
	private List<Estoque> listEstoque;
	private List<TipoProduto> itemsTipoProduto;
	private List<GrupoProduto> itemsGrupoProduto;
	private List<Empresa> itemsempresa;

	private Produto produto;
	private GrupoProduto grupoProduto;
	private TipoProduto tipoProduto;
	private Empresa empresa;
	private Estoque estoqueFiltro;
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
	}
	
	public EstoqueMb(){		
		this.produto = new Produto();
		this.estoqueFiltro = new Estoque();
		this.itemsTipoProduto = new ArrayList<TipoProduto>();
		this.listEstoque = new ArrayList<Estoque>();
	}

	public void limpar(){
		this.produto = new Produto();
		this.estoqueFiltro = new Estoque();
		this.listProduto = new ArrayList<Produto>();
		this.listEstoque = new ArrayList<Estoque>();
	}
	
	public void buscar(){
		try {
			this.listEstoque = estoqueEjb.buscarPosicaoEstoque(estoqueFiltro);
		} catch (Exception e) {
			addMsgError("Erro ao tentar buscar dados posição estoque.");
		}
	}
	
	public void salvar(){
		if (validarSalvar()){

		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.produto.getNome())){
			addMsgError("O campo Nome � obrigat�rio");
			ret = false;
		}
		if (StringUtils.isBlank(this.produto.getDescricao())){
			addMsgError("O campo Descri��o � obrigat�rio");
			ret = false;
		}
		return ret;
	}

	public void excluir(){
//		this.produtoEjb.excluirProduto(this.produto);
		buscar();
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

	public List<GrupoProduto> getItemsGrupoProduto() {
		return itemsGrupoProduto;
	}

	public void setItemsGrupoProduto(List<GrupoProduto> itemsGrupoProduto) {
		this.itemsGrupoProduto = itemsGrupoProduto;
	}

	public List<Estoque> getListEstoque() {
		return listEstoque;
	}

	public void setListEstoque(List<Estoque> listEstoque) {
		this.listEstoque = listEstoque;
	}

	public List<Empresa> getItemsempresa() {
		return itemsempresa;
	}

	public void setItemsempresa(List<Empresa> itemsempresa) {
		this.itemsempresa = itemsempresa;
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Estoque getEstoqueFiltro() {
		return estoqueFiltro;
	}

	public void setEstoqueFiltro(Estoque estoqueFiltro) {
		this.estoqueFiltro = estoqueFiltro;
	}
	
}
