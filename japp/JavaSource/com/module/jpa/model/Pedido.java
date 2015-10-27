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
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
    @NamedQuery(name = "Pedido.findByDatapedido", query = "SELECT p FROM Pedido p WHERE p.datapedido = :datapedido"),
    @NamedQuery(name = "Pedido.findByDataprevista", query = "SELECT p FROM Pedido p WHERE p.dataprevista = :dataprevista"),
    @NamedQuery(name = "Pedido.findByDataenvio", query = "SELECT p FROM Pedido p WHERE p.dataenvio = :dataenvio"),
    @NamedQuery(name = "Pedido.findByEnviovia", query = "SELECT p FROM Pedido p WHERE p.enviovia = :enviovia"),
    @NamedQuery(name = "Pedido.findByValorfrete", query = "SELECT p FROM Pedido p WHERE p.valorfrete = :valorfrete"),
    @NamedQuery(name = "Pedido.findByValorpedido", query = "SELECT p FROM Pedido p WHERE p.valorpedido = :valorpedido"),
    @NamedQuery(name = "Pedido.findByDestnome", query = "SELECT p FROM Pedido p WHERE p.destnome = :destnome"),
    @NamedQuery(name = "Pedido.findByDestendereco", query = "SELECT p FROM Pedido p WHERE p.destendereco = :destendereco"),
    @NamedQuery(name = "Pedido.findByDestcidade", query = "SELECT p FROM Pedido p WHERE p.destcidade = :destcidade"),
    @NamedQuery(name = "Pedido.findByDestestado", query = "SELECT p FROM Pedido p WHERE p.destestado = :destestado"),
    @NamedQuery(name = "Pedido.findByDestcaixapostal", query = "SELECT p FROM Pedido p WHERE p.destcaixapostal = :destcaixapostal"),
    @NamedQuery(name = "Pedido.findByDestpais", query = "SELECT p FROM Pedido p WHERE p.destpais = :destpais")})
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

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

	private Integer enviovia;

	private BigDecimal valorfrete;

	private BigDecimal valorpedido;

	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	@ManyToOne
	private Empresa empresa;

	@OneToMany(mappedBy="pedido")
	private List<PedidoItem> pedidoItems;

	public Pedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Integer getEnviovia() {
		return this.enviovia;
	}

	public void setEnviovia(Integer enviovia) {
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

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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