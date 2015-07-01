/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.module.jpa.model;

import java.io.Serializable;
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
@Table(name = "cfop_nfentrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfopNfentrada.findAll", query = "SELECT c FROM CfopNfentrada c"),
    @NamedQuery(name = "CfopNfentrada.findById", query = "SELECT c FROM CfopNfentrada c WHERE c.id = :id"),
    @NamedQuery(name = "CfopNfentrada.findByCfopNfentrada", query = "SELECT c FROM CfopNfentrada c WHERE c.cfopNfentrada = :cfopNfentrada"),
    @NamedQuery(name = "CfopNfentrada.findByCfop", query = "SELECT c FROM CfopNfentrada c WHERE c.cfop = :cfop")})

public class CfopNfentrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfop_nfentrada")
    private int cfopNfentrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cfop")
    private String cfop;
    @JoinColumn(name = "nfentrada", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NfEntrada nfentrada;

    public CfopNfentrada() {
    }

    public CfopNfentrada(Integer id) {
        this.id = id;
    }

    public CfopNfentrada(Integer id, int cfopNfentrada, String cfop) {
        this.id = id;
        this.cfopNfentrada = cfopNfentrada;
        this.cfop = cfop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCfopNfentrada() {
        return cfopNfentrada;
    }

    public void setCfopNfentrada(int cfopNfentrada) {
        this.cfopNfentrada = cfopNfentrada;
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
        if (!(object instanceof CfopNfentrada)) {
            return false;
        }
        CfopNfentrada other = (CfopNfentrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.module.jpa.model.CfopNfentrada[ id=" + id + " ]";
    }
    
}
