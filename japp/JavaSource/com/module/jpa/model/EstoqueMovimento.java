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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joaocarvalho
 */
@Entity
@Table(name = "estoque_movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstoqueMovimento.findAll", query = "SELECT e FROM EstoqueMovimento e"),
    @NamedQuery(name = "EstoqueMovimento.findById", query = "SELECT e FROM EstoqueMovimento e WHERE e.id = :id"),
    @NamedQuery(name = "EstoqueMovimento.findByPessoaId", query = "SELECT e FROM EstoqueMovimento e WHERE e.pessoaId = :pessoaId"),
    @NamedQuery(name = "EstoqueMovimento.findByTipoMovimento", query = "SELECT e FROM EstoqueMovimento e WHERE e.tipoMovimento = :tipoMovimento"),
    @NamedQuery(name = "EstoqueMovimento.findByNumDocumento", query = "SELECT e FROM EstoqueMovimento e WHERE e.numDocumento = :numDocumento"),
    @NamedQuery(name = "EstoqueMovimento.findByDataMovimento", query = "SELECT e FROM EstoqueMovimento e WHERE e.dataMovimento = :dataMovimento"),
    @NamedQuery(name = "EstoqueMovimento.findByQuantidade", query = "SELECT e FROM EstoqueMovimento e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "EstoqueMovimento.findByQuantidadeTrans", query = "SELECT e FROM EstoqueMovimento e WHERE e.quantidadeTrans = :quantidadeTrans"),
    @NamedQuery(name = "EstoqueMovimento.findByMedida", query = "SELECT e FROM EstoqueMovimento e WHERE e.medida = :medida"),
    @NamedQuery(name = "EstoqueMovimento.findByStatus", query = "SELECT e FROM EstoqueMovimento e WHERE e.status = :status")})
public class EstoqueMovimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Column(name = "tipo_movimento")
    private String tipoMovimento;
    @Column(name = "num_documento")
    private String numDocumento;
    @Column(name = "data_movimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Column(name = "quantidade_trans")
    private BigDecimal quantidadeTrans;
    @Column(name = "medida")
    private String medida;
    @Column(name = "status")
    private String status;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresaId;
    
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produtoId;

    public EstoqueMovimento() {
    }

    public EstoqueMovimento(Integer id) {
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

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidadeTrans() {
        return quantidadeTrans;
    }

    public void setQuantidadeTrans(BigDecimal quantidadeTrans) {
        this.quantidadeTrans = quantidadeTrans;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
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
        if (!(object instanceof EstoqueMovimento)) {
            return false;
        }
        EstoqueMovimento other = (EstoqueMovimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapptestes.jpa.model.EstoqueMovimento[ id=" + id + " ]";
    }
    
}
