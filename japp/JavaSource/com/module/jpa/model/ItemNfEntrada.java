/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.module.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joao.carvalho
 */
@Entity
@Table(name = "item_nf_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemNfEntrada.findAll", query = "SELECT i FROM ItemNfEntrada i"),
    @NamedQuery(name = "ItemNfEntrada.findById", query = "SELECT i FROM ItemNfEntrada i WHERE i.id = :id"),
    @NamedQuery(name = "ItemNfEntrada.findByItemnfentrada", query = "SELECT i FROM ItemNfEntrada i WHERE i.itemnfentrada = :itemnfentrada"),
    @NamedQuery(name = "ItemNfEntrada.findByEan", query = "SELECT i FROM ItemNfEntrada i WHERE i.ean = :ean"),
    @NamedQuery(name = "ItemNfEntrada.findByProduto", query = "SELECT i FROM ItemNfEntrada i WHERE i.produto = :produto"),
    @NamedQuery(name = "ItemNfEntrada.findByCst", query = "SELECT i FROM ItemNfEntrada i WHERE i.cst = :cst"),
    @NamedQuery(name = "ItemNfEntrada.findByQuantidade", query = "SELECT i FROM ItemNfEntrada i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemNfEntrada.findByUnidadeembalagem", query = "SELECT i FROM ItemNfEntrada i WHERE i.unidadeembalagem = :unidadeembalagem"),
    @NamedQuery(name = "ItemNfEntrada.findByValorunitario", query = "SELECT i FROM ItemNfEntrada i WHERE i.valorunitario = :valorunitario"),
    @NamedQuery(name = "ItemNfEntrada.findByDesconto", query = "SELECT i FROM ItemNfEntrada i WHERE i.desconto = :desconto"),
    @NamedQuery(name = "ItemNfEntrada.findByIpi", query = "SELECT i FROM ItemNfEntrada i WHERE i.ipi = :ipi"),
    @NamedQuery(name = "ItemNfEntrada.findByIcmsentrada", query = "SELECT i FROM ItemNfEntrada i WHERE i.icmsentrada = :icmsentrada"),
    @NamedQuery(name = "ItemNfEntrada.findByIcmssaida", query = "SELECT i FROM ItemNfEntrada i WHERE i.icmssaida = :icmssaida"),
    @NamedQuery(name = "ItemNfEntrada.findByCfop", query = "SELECT i FROM ItemNfEntrada i WHERE i.cfop = :cfop")})
public class ItemNfEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemnfentrada")
    private int itemnfentrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ean")
    private String ean;
    @Basic(optional = false)
    @NotNull
    @Column(name = "produto")
    private int produto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cst")
    private int cst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidadeembalagem")
    private BigDecimal unidadeembalagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorunitario")
    private BigDecimal valorunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desconto")
    private BigDecimal desconto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ipi")
    private BigDecimal ipi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "icmsentrada")
    private BigDecimal icmsentrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "icmssaida")
    private BigDecimal icmssaida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cfop")
    private String cfop;
    @JoinColumn(name = "nfentrada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NfEntrada nfentrada;

    public ItemNfEntrada() {
    }

    public ItemNfEntrada(Integer id) {
        this.id = id;
    }

    public ItemNfEntrada(Integer id, int itemnfentrada, String ean, int produto, int cst, BigDecimal quantidade, BigDecimal unidadeembalagem, BigDecimal valorunitario, BigDecimal desconto, BigDecimal ipi, BigDecimal icmsentrada, BigDecimal icmssaida, String cfop) {
        this.id = id;
        this.itemnfentrada = itemnfentrada;
        this.ean = ean;
        this.produto = produto;
        this.cst = cst;
        this.quantidade = quantidade;
        this.unidadeembalagem = unidadeembalagem;
        this.valorunitario = valorunitario;
        this.desconto = desconto;
        this.ipi = ipi;
        this.icmsentrada = icmsentrada;
        this.icmssaida = icmssaida;
        this.cfop = cfop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getItemnfentrada() {
        return itemnfentrada;
    }

    public void setItemnfentrada(int itemnfentrada) {
        this.itemnfentrada = itemnfentrada;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCst() {
        return cst;
    }

    public void setCst(int cst) {
        this.cst = cst;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getUnidadeembalagem() {
        return unidadeembalagem;
    }

    public void setUnidadeembalagem(BigDecimal unidadeembalagem) {
        this.unidadeembalagem = unidadeembalagem;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public BigDecimal getIcmsentrada() {
        return icmsentrada;
    }

    public void setIcmsentrada(BigDecimal icmsentrada) {
        this.icmsentrada = icmsentrada;
    }

    public BigDecimal getIcmssaida() {
        return icmssaida;
    }

    public void setIcmssaida(BigDecimal icmssaida) {
        this.icmssaida = icmssaida;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public NfEntrada getNfentrada() {
        return nfentrada;
    }

    public void setNfentrada(NfEntrada nfentrada) {
        this.nfentrada = nfentrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemNfEntrada)) {
            return false;
        }
        ItemNfEntrada other = (ItemNfEntrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.module.jpa.model.ItemNfEntrada[ id=" + id + " ]";
    }
    
}
