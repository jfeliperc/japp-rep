package com.module.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import com.module.faces.geral.IGenericModel;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable, IGenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datainclusao;

	private String descricao;

	private String medida;
	
	@Column(name="cod_externo")
	private String codExterno;

	private String nome;

	@Column(name="qtd_minima")
	private Double qtdMinima;
	
	@Column(name="qtd_ref_compra")
	private String qtdRefCompra;

	@Column(name="qtd_ref_saida")
	private String qtdRefSaida;
	
	@Column(name="aliq_icms")
	private Double aliqIcms;

	@Column(name="aliq_ipi")
	private Double aliqIpi;
	
	@Column(name="fator_coaccao")
	private Double fatorCoaccao;

	@Column(name="indice_coaccao")
	private Double indiceCoaccao;
	
	@Column(name="calorias")
	private Double calorias;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="produto")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to FornecProduto
	@OneToMany(mappedBy="produto")
	private List<FornecProduto> fornecProdutos;

	//bi-directional many-to-many association to Orcamento
	@ManyToMany(mappedBy="produtos")
	private List<Orcamento> orcamentos;

	//bi-directional many-to-one association to PedidoItem
	@OneToMany(mappedBy="produto")
	private List<PedidoItem> pedidoItems;

	//bi-directional many-to-one association to GrupoProduto
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="grupo_produto_id")
	private GrupoProduto grupoProduto;

	//bi-directional many-to-one association to TipoProduto
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="tipo_produto_id")
	private TipoProduto tipoProduto;

	//bi-directional many-to-one association to ValorProduto
	@OneToMany(mappedBy="produto")
	private List<ValorProduto> valorProdutos;

	public Produto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getCodExterno() {
		return codExterno;
	}

	public void setCodExterno(String codExterno) {
		this.codExterno = codExterno;
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

	public List<FornecProduto> getFornecProdutos() {
		return this.fornecProdutos;
	}

	public void setFornecProdutos(List<FornecProduto> fornecProdutos) {
		this.fornecProdutos = fornecProdutos;
	}

	public FornecProduto addFornecProduto(FornecProduto fornecProduto) {
		getFornecProdutos().add(fornecProduto);
		fornecProduto.setProduto(this);

		return fornecProduto;
	}

	public FornecProduto removeFornecProduto(FornecProduto fornecProduto) {
		getFornecProdutos().remove(fornecProduto);
		fornecProduto.setProduto(null);

		return fornecProduto;
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

	public GrupoProduto getGrupoProduto() {
		return this.grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
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

	public Double getAliqIcms() {
		return aliqIcms;
	}

	public void setAliqIcms(Double aliqIcms) {
		this.aliqIcms = aliqIcms;
	}

	public Double getAliqIpi() {
		return aliqIpi;
	}

	public void setAliqIpi(Double aliqIpi) {
		this.aliqIpi = aliqIpi;
	}

	public Double getFatorCoaccao() {
		return fatorCoaccao;
	}

	public void setFatorCoaccao(Double fatorCoaccao) {
		this.fatorCoaccao = fatorCoaccao;
	}

	public Double getIndiceCoaccao() {
		return indiceCoaccao;
	}

	public void setIndiceCoaccao(Double indiceCoaccao) {
		this.indiceCoaccao = indiceCoaccao;
	}

	public Double getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Double qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	
}