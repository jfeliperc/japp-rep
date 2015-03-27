package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	private String descricao;

	private String medida;

	private String nome;

	@Column(name="qtd_ref_compra")
	private String qtdRefCompra;

	@Column(name="qtd_ref_saida")
	private String qtdRefSaida;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="produto")
	private List<Estoque> estoques;

	//bi-directional many-to-many association to Orcamento
	@ManyToMany(mappedBy="produtos")
	private List<Orcamento> orcamentos;

	//bi-directional many-to-one association to PedidoItem
	@OneToMany(mappedBy="produto")
	private List<PedidoItem> pedidoItems;

	//bi-directional many-to-one association to TipoProduto
	@ManyToOne
	@JoinColumn(name="tipo_produto_id")
	private TipoProduto tipoProduto;

	//bi-directional many-to-one association to ValorProduto
	@OneToMany(mappedBy="produto")
	private List<ValorProduto> valorProdutos;

	public Produto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataalteracao() {
		return this.dataalteracao;
	}

	public void setDataalteracao(Date dataalteracao) {
		this.dataalteracao = dataalteracao;
	}

	public Date getDatainclusao() {
		return this.datainclusao;
	}

	public void setDatainclusao(Date datainclusao) {
		this.datainclusao = datainclusao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQtdRefCompra() {
		return this.qtdRefCompra;
	}

	public void setQtdRefCompra(String qtdRefCompra) {
		this.qtdRefCompra = qtdRefCompra;
	}

	public String getQtdRefSaida() {
		return this.qtdRefSaida;
	}

	public void setQtdRefSaida(String qtdRefSaida) {
		this.qtdRefSaida = qtdRefSaida;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setProduto(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setProduto(null);

		return estoque;
	}

	public List<Orcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public List<PedidoItem> getPedidoItems() {
		return this.pedidoItems;
	}

	public void setPedidoItems(List<PedidoItem> pedidoItems) {
		this.pedidoItems = pedidoItems;
	}

	public PedidoItem addPedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().add(pedidoItem);
		pedidoItem.setProduto(this);

		return pedidoItem;
	}

	public PedidoItem removePedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().remove(pedidoItem);
		pedidoItem.setProduto(null);

		return pedidoItem;
	}

	public TipoProduto getTipoProduto() {
		return this.tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<ValorProduto> getValorProdutos() {
		return this.valorProdutos;
	}

	public void setValorProdutos(List<ValorProduto> valorProdutos) {
		this.valorProdutos = valorProdutos;
	}

	public ValorProduto addValorProduto(ValorProduto valorProduto) {
		getValorProdutos().add(valorProduto);
		valorProduto.setProduto(this);

		return valorProduto;
	}

	public ValorProduto removeValorProduto(ValorProduto valorProduto) {
		getValorProdutos().remove(valorProduto);
		valorProduto.setProduto(null);

		return valorProduto;
	}

}