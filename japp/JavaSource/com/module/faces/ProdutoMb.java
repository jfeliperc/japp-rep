package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IProdutoEjb;
import com.module.jpa.model.Empresa;
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
	
	private List<SelectItem> sisTipoProduto;
	
	private TipoProduto tipo;
	private GrupoProduto grupo;
	
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		produto = new Produto();
		tipo = new TipoProduto();
		grupo = new GrupoProduto();
		itemsTipoProduto = this.produtoEjb.buscarAllTipoProduto();
		itemsGrupoProduto = this.produtoEjb.buscarAllGrupoProduto();
		
		sisTipoProduto = new ArrayList<SelectItem>();
		for (TipoProduto tipo : itemsTipoProduto) {
			SelectItem si = new SelectItem(tipo, tipo.getNome(), tipo.getDescricao());
			sisTipoProduto.add(si);
		}
	}
	
	public ProdutoMb(){	
		super();
		tipo = new TipoProduto();
		grupo = new GrupoProduto();
		empresaAux = new Empresa();
		this.produto = new Produto();
	}

	public void limpar(){
		this.produto = new Produto();
		tipo = new TipoProduto();
		grupo = new GrupoProduto();
		this.listProduto = new ArrayList<Produto>();
		this.itemsTipoProduto = produtoEjb.buscarAllTipoProduto();
		this.itemsGrupoProduto = produtoEjb.buscarAllGrupoProduto();
		this.produto.setId(null);
		empresaAux = new Empresa();
	}
	
	public void buscar(){
		
		try {
			this.produto.setEmpresa(empresaAux);
			this.listProduto = produtoEjb.listarProdutos(this.produto);
			
			if ((this.listProduto != null)&&(!this.listProduto.isEmpty())&&(this.listProduto.size() == 1)){
				this.produto = this.listProduto.get(0);
				this.tipo = this.produto.getTipoProduto() != null ? this.produto.getTipoProduto() : new TipoProduto() ;
				this.grupo = this.produto.getGrupoProduto() != null ? this.produto.getGrupoProduto() : new GrupoProduto();
				empresaAux = this.produto.getEmpresa() != null ? this.produto.getEmpresa() : new Empresa();
				this.listProduto.clear();
			}else{
				empresaAux = new Empresa();
				setMostrarLista((this.listProduto != null)&&(!this.listProduto.isEmpty()));
			}
			
		} catch (Exception e) {
			addMsgError("Erro ao buscar pessoa(s) - "+e.getMessage());
		}
		
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.produto.setTipoProduto(this.tipo);
			this.produto.setGrupoProduto(this.grupo);
			this.produto.setEmpresa(getEmpresaAux());
			this.produto = this.produtoEjb.cadastrarProduto(this.produto);
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

	public void editar(Produto us){
		this.produto = us;
		this.tipo = this.produto.getTipoProduto() == null ? new TipoProduto() : this.produto.getTipoProduto();
		this.grupo = this.produto.getGrupoProduto() == null ? new GrupoProduto() : this.produto.getGrupoProduto();
		empresaAux = this.produto.getEmpresa() == null ? new Empresa() : this.produto.getEmpresa();
		alternaMostraLista();
	}

	
	public void excluir(){
		this.produtoEjb.excluirProduto(this.produto);
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

	public TipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

	public GrupoProduto getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoProduto grupo) {
		this.grupo = grupo;
	}

	public List<SelectItem> getSisTipoProduto() {
		return sisTipoProduto;
	}
	
}
