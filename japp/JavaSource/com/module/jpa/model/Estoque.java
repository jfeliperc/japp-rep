package com.module.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the estoque database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findById", query = "SELECT e FROM Estoque e WHERE e.id = :id"),
    @NamedQuery(name = "Estoque.findByPessoaId", query = "SELECT e FROM Estoque e WHERE e.pessoaId = :pessoaId"),
    @NamedQuery(name = "Estoque.findByDataultimofechamento", query = "SELECT e FROM Estoque e WHERE e.dataultimofechamento = :dataultimofechamento"),
    @NamedQuery(name = "Estoque.findByDatacontagem", query = "SELECT e FROM Estoque e WHERE e.datacontagem = :datacontagem"),
    @NamedQuery(name = "Estoque.findByQuantidade", query = "SELECT e FROM Estoque e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "Estoque.findByStatus", query = "SELECT e FROM Estoque e WHERE e.status = :status")})
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
	
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    
    @Column(name = "dataultimofechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimofechamento;
    
    @Column(name = "datacontagem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacontagem;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    
    @Column(name = "status")
    private String status;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresa;
    
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produto produto;

    public Estoque() {
    }

    public Estoque(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Date getDataultimofechamento() {
        return dataultimofechamento;
    }

    public void setDataultimofechamento(Date dataultimofechamento) {
        this.dataultimofechamento = dataultimofechamento;
    }

    public Date getDatacontagem() {
        return datacontagem;
    }

    public void setDatacontagem(Date datacontagem) {
        this.datacontagem = datacontagem;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapptestes.jpa.model.Estoque[ id=" + id + " ]";
    }
    
}
