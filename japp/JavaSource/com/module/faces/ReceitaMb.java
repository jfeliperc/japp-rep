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
	
	@PostConstruct
	public void construcao(){
		this.itemsTipoProduto = new ArrayList<TipoProduto>();
		this.itemsGrupoProduto = new ArrayList<GrupoProduto>();
		this.itemsTipoReceita = new ArrayList<TipoReceita>();
		this.listReceitaProduto = new ArrayList<ReceitaProduto>();
		this.receita = new Receita();
		this.receitaProduto = new ReceitaProduto();
	}
	
	public ReceitaMb(){		
		this.produto = new Produto();
		this.itemsTipoProduto = new ArrayList<TipoProduto>();   
	}

	public void limpar(){
		this.produto = new Produto();
		this.listProduto = new ArrayList<Produto>();
		this.itemsTipoProduto = produtoEjb.buscarAllTipoProduto();
		this.itemsGrupoProduto = produtoEjb.buscarAllGrupoProduto();
		this.itemsTipoReceita = receitaEjb.buscarAllTipoReceitas();
		this.listServico = servicoEjb.buscarAllServicos();
		this.produto.setId(null);
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
			this.produto = this.produtoEjb.cadastrarProduto(this.produto);
		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.produto.getNome())){
			addMsgError("O campo Nome é obrigatório");
			ret = false;
		}
		if (StringUtils.isBlank(this.produto.getDescricao())){
			addMsgError("O campo Descriééo é obrigatório");
			ret = false;
		}
		return ret;
	}

	public void editar(Receita us){
		this.receita = us;
	}
	
	public void excluir(){
		this.produtoEjb.excluirProduto(this.produto);
		buscar();
	}
	
	public void limparDetalhe(){
		
	}
	
	public void salvarDetalhe(){
		
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
	
}
