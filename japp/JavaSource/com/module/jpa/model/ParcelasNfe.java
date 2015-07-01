/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.module.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joao.carvalho
 */
@Entity
@Table(name = "parcelas_nfe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParcelasNfe.findAll", query = "SELECT p FROM ParcelasNfe p"),
    @NamedQuery(name = "ParcelasNfe.findById", query = "SELECT p FROM ParcelasNfe p WHERE p.id = :id"),
    @NamedQuery(name = "ParcelasNfe.findByParcelasnfe", query = "SELECT p FROM ParcelasNfe p WHERE p.parcelasnfe = :parcelasnfe"),
    @NamedQuery(name = "ParcelasNfe.findByNotafiscal", query = "SELECT p FROM ParcelasNfe p WHERE p.notafiscal = :notafiscal"),
    @NamedQuery(name = "ParcelasNfe.findByDocumento", query = "SELECT p FROM ParcelasNfe p WHERE p.documento = :documento"),
    @NamedQuery(name = "ParcelasNfe.findByVencimento", query = "SELECT p FROM ParcelasNfe p WHERE p.vencimento = :vencimento"),
    @NamedQuery(name = "ParcelasNfe.findByValor", query = "SELECT p FROM ParcelasNfe p WHERE p.valor = :valor")})
public class ParcelasNfe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parcelasnfe")
    private int parcelasnfe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "notafiscal")
    private String notafiscal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "nfentrada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NfEntrada nfentrada;

    public ParcelasNfe() {
    }

    public ParcelasNfe(Integer id) {
        this.id = id;
    }

    public ParcelasNfe(Integer id, int parcelasnfe, String notafiscal, String documento, Date vencimento, BigDecimal valor) {
        this.id = id;
        this.parcelasnfe = parcelasnfe;
        this.notafiscal = notafiscal;
        this.documento = documento;
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getParcelasnfe() {
        return parcelasnfe;
    }

    public void setParcelasnfe(int parcelasnfe) {
        this.parcelasnfe = parcelasnfe;
    }

    public String getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(String notafiscal) {
        this.notafiscal = notafiscal;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        if (!(object instanceof ParcelasNfe)) {
            return false;
        }
        ParcelasNfe other = (ParcelasNfe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.module.jpa.model.ParcelasNfe[ id=" + id + " ]";
    }
    
}
