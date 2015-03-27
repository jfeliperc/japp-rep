package com.module.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dataenvio;

	@Temporal(TemporalType.DATE)
	private Date datapedido;

	@Temporal(TemporalType.DATE)
	private Date dataprevista;

	private String destcaixapostal;

	private String destcidade;

	private String destendereco;

	private String destestado;

	private String destnome;

	private String destpais;

	private int enviovia;

	private BigDecimal valorfrete;

	private BigDecimal valorpedido;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to PedidoItem
	@OneToMany(mappedBy="pedido")
	private List<PedidoItem> pedidoItems;

	public Pedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataenvio() {
		return this.dataenvio;
	}

	public void setDataenvio(Date dataenvio) {
		this.dataenvio = dataenvio;
	}

	public Date getDatapedido() {
		return this.datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}

	public Date getDataprevista() {
		return this.dataprevista;
	}

	public void setDataprevista(Date dataprevista) {
		this.dataprevista = dataprevista;
	}

	public String getDestcaixapostal() {
		return this.destcaixapostal;
	}

	public void setDestcaixapostal(String destcaixapostal) {
		this.destcaixapostal = destcaixapostal;
	}

	public String getDestcidade() {
		return this.destcidade;
	}

	public void setDestcidade(String destcidade) {
		this.destcidade = destcidade;
	}

	public String getDestendereco() {
		return this.destendereco;
	}

	public void setDestendereco(String destendereco) {
		this.destendereco = destendereco;
	}

	public String getDestestado() {
		return this.destestado;
	}

	public void setDestestado(String destestado) {
		this.destestado = destestado;
	}

	public String getDestnome() {
		return this.destnome;
	}

	public void setDestnome(String destnome) {
		this.destnome = destnome;
	}

	public String getDestpais() {
		return this.destpais;
	}

	public void setDestpais(String destpais) {
		this.destpais = destpais;
	}

	public int getEnviovia() {
		return this.enviovia;
	}

	public void setEnviovia(int enviovia) {
		this.enviovia = enviovia;
	}

	public BigDecimal getValorfrete() {
		return this.valorfrete;
	}

	public void setValorfrete(BigDecimal valorfrete) {
		this.valorfrete = valorfrete;
	}

	public BigDecimal getValorpedido() {
		return this.valorpedido;
	}

	public void setValorpedido(BigDecimal valorpedido) {
		this.valorpedido = valorpedido;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<PedidoItem> getPedidoItems() {
		return this.pedidoItems;
	}

	public void setPedidoItems(List<PedidoItem> pedidoItems) {
		this.pedidoItems = pedidoItems;
	}

	public PedidoItem addPedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().add(pedidoItem);
		pedidoItem.setPedido(this);

		return pedidoItem;
	}

	public PedidoItem removePedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().remove(pedidoItem);
		pedidoItem.setPedido(null);

		return pedidoItem;
	}

}