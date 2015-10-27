package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IProdutoEjb;
import com.module.ejb.contract.IReceitaEjb;
import com.module.ejb.contract.IServicoEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.model.GrupoProduto;
import com.module.jpa.model.Produto;
import com.module.jpa.model.Receita;
import com.module.jpa.model.ReceitaProduto;
import com.module.jpa.model.Servico;
import com.module.jpa.model.TipoProduto;
import com.module.jpa.model.TipoReceita;


@ManagedBean
@SessionScoped
public class ReceitaMb extends BaseMb{

	@EJB
	private IProdutoEjb produtoEjb;
	
	@EJB
	private IReceitaEjb receitaEjb;
	
	@EJB
	private IServicoEjb servicoEjb;

	private Produto produto;
	private Receita receita;
	private ReceitaProduto receitaProduto;
	private List<ReceitaProduto> listReceitaProduto;
	private List<Produto> listProduto;
	private List<Receita> listReceita;
	private List<Servico> listServico;
	private List<TipoReceita> itemsTipoReceita;
	private List<TipoProduto> itemsTipoProduto;
	private List<GrupoProduto> itemsGrupoProduto;
	
	private Servico servicoAux;
	private TipoReceita tipoReceitaAux;
	private TipoProduto tipoProdutoAux;
	private GrupoProduto grupoProdutoAux;
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		limpar();	
	}
	
	public ReceitaMb(){		
		super();
		this.produto = new Produto();
		this.itemsTipoProduto = new ArrayList<TipoProduto>();   
	}

	public void limpar(){
		this.produto = new Produto();
		this.produto.setId(null);
		
		this.listProduto = produtoEjb.buscarAllProdutos(); // new ArrayList<Produto>();
		this.itemsTipoProduto = produtoEjb.buscarAllTipoProduto();
		this.itemsGrupoProduto = produtoEjb.buscarAllGrupoProduto();
		this.itemsTipoReceita = receitaEjb.buscarAllTipoReceitas();
		this.listServico = servicoEjb.buscarAllServicos();
		
		this.receita = new Receita();
		this.receitaProduto = new ReceitaProduto();
		this.servicoAux = new Servico();
		this.tipoReceitaAux = new TipoReceita();
		this.tipoProdutoAux = new TipoProduto();
		this.grupoProdutoAux = new GrupoProduto();			

		this.listReceitaProduto = new ArrayList<ReceitaProduto>();
	}
	
	public void buscar(){
				
		try {
			
			
		} catch (Exception e) {
			addMsgError("Erro ao buscar pessoa(s) - "+e.getMessage());
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
		
		return ret;
	}

	public void editar(Receita us){
		this.receita = us;
	}
	
	public void removerProdutoReceita(ReceitaProduto prod){
		this.listReceitaProduto.remove(prod);
	}
	
	public void excluir(){
		this.produtoEjb.excluirProduto(this.produto);
		buscar();
	}
	
	public void limparCamposIngredientes(){
		
	}
	
	public void adicionarIngrediente(){
		if (this.listReceitaProduto == null){
			this.listReceitaProduto = new ArrayList<ReceitaProduto>();
		}
		
		if (!UtilsJapp.isNullOrZero(this.produto.getId())){
			this.receitaProduto.setProduto( produtoEjb.buscarProduto(this.produto));
			this.listReceitaProduto.add(this.receitaProduto);

			this.receitaProduto = new ReceitaProduto();		
		}
	}
	
	public String irCadastroTipoReceita(){
		return "tipoReceita";
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

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public List<Receita> getListReceita() {
		return listReceita;
	}

	public void setListReceita(List<Receita> listReceita) {
		this.listReceita = listReceita;
	}

	public ReceitaProduto getReceitaProduto() {
		return receitaProduto;
	}

	public void setReceitaProduto(ReceitaProduto receitaProduto) {
		this.receitaProduto = receitaProduto;
	}

	public List<ReceitaProduto> getListReceitaProduto() {
		return listReceitaProduto;
	}

	public void setListReceitaProduto(List<ReceitaProduto> listReceitaProduto) {
		this.listReceitaProduto = listReceitaProduto;
	}

	public List<Servico> getListServico() {
		return listServico;
	}

	public void setListServico(List<Servico> listServico) {
		this.listServico = listServico;
	}

	public List<TipoReceita> getItemsTipoReceita() {
		return itemsTipoReceita;
	}

	public void setItemsTipoReceita(List<TipoReceita> itemsTipoReceita) {
		this.itemsTipoReceita = itemsTipoReceita;
	}

	public Servico getServicoAux() {
		return servicoAux;
	}

	public void setServicoAux(Servico servicoAux) {
		this.servicoAux = servicoAux;
	}

	public TipoReceita getTipoReceitaAux() {
		return tipoReceitaAux;
	}

	public void setTipoReceitaAux(TipoReceita tipoReceitaAux) {
		this.tipoReceitaAux = tipoReceitaAux;
	}

	public TipoProduto getTipoProdutoAux() {
		return tipoProdutoAux;
	}

	public void setTipoProdutoAux(TipoProduto tipoProdutoAux) {
		this.tipoProdutoAux = tipoProdutoAux;
	}

	public GrupoProduto getGrupoProdutoAux() {
		return grupoProdutoAux;
	}

	public void setGrupoProdutoAux(GrupoProduto grupoProdutoAux) {
		this.grupoProdutoAux = grupoProdutoAux;
	}
	
}
