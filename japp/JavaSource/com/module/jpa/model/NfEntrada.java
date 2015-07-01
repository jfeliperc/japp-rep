/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.module.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joao.carvalho
 */
@Entity
@Table(name = "nf_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NfEntrada.findAll", query = "SELECT n FROM NfEntrada n"),
    @NamedQuery(name = "NfEntrada.findById", query = "SELECT n FROM NfEntrada n WHERE n.id = :id"),
    @NamedQuery(name = "NfEntrada.findByCodigo", query = "SELECT n FROM NfEntrada n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "NfEntrada.findByNotafiscal", query = "SELECT n FROM NfEntrada n WHERE n.notafiscal = :notafiscal"),
    @NamedQuery(name = "NfEntrada.findByNotafiscalinterna", query = "SELECT n FROM NfEntrada n WHERE n.notafiscalinterna = :notafiscalinterna"),
    @NamedQuery(name = "NfEntrada.findByFornecedor", query = "SELECT n FROM NfEntrada n WHERE n.fornecedor = :fornecedor"),
    @NamedQuery(name = "NfEntrada.findByOrdemdecompra", query = "SELECT n FROM NfEntrada n WHERE n.ordemdecompra = :ordemdecompra"),
    @NamedQuery(name = "NfEntrada.findByEntrada", query = "SELECT n FROM NfEntrada n WHERE n.entrada = :entrada"),
    @NamedQuery(name = "NfEntrada.findByEmissao", query = "SELECT n FROM NfEntrada n WHERE n.emissao = :emissao"),
    @NamedQuery(name = "NfEntrada.findBySaida", query = "SELECT n FROM NfEntrada n WHERE n.saida = :saida"),
    @NamedQuery(name = "NfEntrada.findByTransportadora", query = "SELECT n FROM NfEntrada n WHERE n.transportadora = :transportadora"),
    @NamedQuery(name = "NfEntrada.findByTipofrete", query = "SELECT n FROM NfEntrada n WHERE n.tipofrete = :tipofrete"),
    @NamedQuery(name = "NfEntrada.findByFreteagregado", query = "SELECT n FROM NfEntrada n WHERE n.freteagregado = :freteagregado"),
    @NamedQuery(name = "NfEntrada.findByBaseicms", query = "SELECT n FROM NfEntrada n WHERE n.baseicms = :baseicms"),
    @NamedQuery(name = "NfEntrada.findByValoricms", query = "SELECT n FROM NfEntrada n WHERE n.valoricms = :valoricms"),
    @NamedQuery(name = "NfEntrada.findByBasesubstituicao", query = "SELECT n FROM NfEntrada n WHERE n.basesubstituicao = :basesubstituicao"),
    @NamedQuery(name = "NfEntrada.findByValorsubstituicao", query = "SELECT n FROM NfEntrada n WHERE n.valorsubstituicao = :valorsubstituicao"),
    @NamedQuery(name = "NfEntrada.findByValordofrete", query = "SELECT n FROM NfEntrada n WHERE n.valordofrete = :valordofrete"),
    @NamedQuery(name = "NfEntrada.findByValordoseguro", query = "SELECT n FROM NfEntrada n WHERE n.valordoseguro = :valordoseguro"),
    @NamedQuery(name = "NfEntrada.findByOutrasdespesas", query = "SELECT n FROM NfEntrada n WHERE n.outrasdespesas = :outrasdespesas"),
    @NamedQuery(name = "NfEntrada.findByValordoipi", query = "SELECT n FROM NfEntrada n WHERE n.valordoipi = :valordoipi"),
    @NamedQuery(name = "NfEntrada.findByValordosprodutos", query = "SELECT n FROM NfEntrada n WHERE n.valordosprodutos = :valordosprodutos"),
    @NamedQuery(name = "NfEntrada.findByValordanota", query = "SELECT n FROM NfEntrada n WHERE n.valordanota = :valordanota"),
    @NamedQuery(name = "NfEntrada.findByBaseicmscalculado", query = "SELECT n FROM NfEntrada n WHERE n.baseicmscalculado = :baseicmscalculado"),
    @NamedQuery(name = "NfEntrada.findByValoricmscalculado", query = "SELECT n FROM NfEntrada n WHERE n.valoricmscalculado = :valoricmscalculado"),
    @NamedQuery(name = "NfEntrada.findByBasesubstituicaocalculado", query = "SELECT n FROM NfEntrada n WHERE n.basesubstituicaocalculado = :basesubstituicaocalculado"),
    @NamedQuery(name = "NfEntrada.findByValorsubstituicaocalculado", query = "SELECT n FROM NfEntrada n WHERE n.valorsubstituicaocalculado = :valorsubstituicaocalculado"),
    @NamedQuery(name = "NfEntrada.findByValordofretecalculado", query = "SELECT n FROM NfEntrada n WHERE n.valordofretecalculado = :valordofretecalculado"),
    @NamedQuery(name = "NfEntrada.findByValordosegurocalculado", query = "SELECT n FROM NfEntrada n WHERE n.valordosegurocalculado = :valordosegurocalculado"),
    @NamedQuery(name = "NfEntrada.findByOutrasdespesascalculado", query = "SELECT n FROM NfEntrada n WHERE n.outrasdespesascalculado = :outrasdespesascalculado"),
    @NamedQuery(name = "NfEntrada.findByValordoipicalculado", query = "SELECT n FROM NfEntrada n WHERE n.valordoipicalculado = :valordoipicalculado"),
    @NamedQuery(name = "NfEntrada.findByValordosprodutoscalculado", query = "SELECT n FROM NfEntrada n WHERE n.valordosprodutoscalculado = :valordosprodutoscalculado"),
    @NamedQuery(name = "NfEntrada.findByValordanotacalculado", query = "SELECT n FROM NfEntrada n WHERE n.valordanotacalculado = :valordanotacalculado"),
    @NamedQuery(name = "NfEntrada.findByDescontogeral", query = "SELECT n FROM NfEntrada n WHERE n.descontogeral = :descontogeral"),
    @NamedQuery(name = "NfEntrada.findByDescontogeralcalculado", query = "SELECT n FROM NfEntrada n WHERE n.descontogeralcalculado = :descontogeralcalculado"),
    @NamedQuery(name = "NfEntrada.findByPesobruto", query = "SELECT n FROM NfEntrada n WHERE n.pesobruto = :pesobruto"),
    @NamedQuery(name = "NfEntrada.findByPesoliquido", query = "SELECT n FROM NfEntrada n WHERE n.pesoliquido = :pesoliquido"),
    @NamedQuery(name = "NfEntrada.findByQuantidadevolume", query = "SELECT n FROM NfEntrada n WHERE n.quantidadevolume = :quantidadevolume"),
    @NamedQuery(name = "NfEntrada.findByEspecievolume", query = "SELECT n FROM NfEntrada n WHERE n.especievolume = :especievolume"),
    @NamedQuery(name = "NfEntrada.findByMarcavolume", query = "SELECT n FROM NfEntrada n WHERE n.marcavolume = :marcavolume"),
    @NamedQuery(name = "NfEntrada.findByNumerovolume", query = "SELECT n FROM NfEntrada n WHERE n.numerovolume = :numerovolume"),
    @NamedQuery(name = "NfEntrada.findByPlacaveiculo", query = "SELECT n FROM NfEntrada n WHERE n.placaveiculo = :placaveiculo"),
    @NamedQuery(name = "NfEntrada.findByUfveiculo", query = "SELECT n FROM NfEntrada n WHERE n.ufveiculo = :ufveiculo"),
    @NamedQuery(name = "NfEntrada.findByStatus", query = "SELECT n FROM NfEntrada n WHERE n.status = :status"),
    @NamedQuery(name = "NfEntrada.findByImpresso", query = "SELECT n FROM NfEntrada n WHERE n.impresso = :impresso"),
    @NamedQuery(name = "NfEntrada.findByObservacao", query = "SELECT n FROM NfEntrada n WHERE n.observacao = :observacao"),
    @NamedQuery(name = "NfEntrada.findBySerienf", query = "SELECT n FROM NfEntrada n WHERE n.serienf = :serienf"),
    @NamedQuery(name = "NfEntrada.findByModelo", query = "SELECT n FROM NfEntrada n WHERE n.modelo = :modelo"),
    @NamedQuery(name = "NfEntrada.findByCancelada", query = "SELECT n FROM NfEntrada n WHERE n.cancelada = :cancelada"),
    @NamedQuery(name = "NfEntrada.findByRatearDesconto", query = "SELECT n FROM NfEntrada n WHERE n.ratearDesconto = :ratearDesconto")})
public class NfEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "notafiscal")
    private String notafiscal;
    @Size(max = 15)
    @Column(name = "notafiscalinterna")
    private String notafiscalinterna;
    @Column(name = "fornecedor")
    private Integer fornecedor;
    @Column(name = "ordemdecompra")
    private Integer ordemdecompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emissao")
    @Temporal(TemporalType.DATE)
    private Date emissao;
    @Column(name = "saida")
    @Temporal(TemporalType.DATE)
    private Date saida;
    @Column(name = "transportadora")
    private Integer transportadora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipofrete")
    private int tipofrete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "freteagregado")
    private int freteagregado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "baseicms")
    private BigDecimal baseicms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoricms")
    private BigDecimal valoricms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "basesubstituicao")
    private BigDecimal basesubstituicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorsubstituicao")
    private BigDecimal valorsubstituicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordofrete")
    private BigDecimal valordofrete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordoseguro")
    private BigDecimal valordoseguro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outrasdespesas")
    private BigDecimal outrasdespesas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordoipi")
    private BigDecimal valordoipi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordosprodutos")
    private BigDecimal valordosprodutos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordanota")
    private BigDecimal valordanota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baseicmscalculado")
    private BigDecimal baseicmscalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoricmscalculado")
    private BigDecimal valoricmscalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "basesubstituicaocalculado")
    private BigDecimal basesubstituicaocalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorsubstituicaocalculado")
    private BigDecimal valorsubstituicaocalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordofretecalculado")
    private BigDecimal valordofretecalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordosegurocalculado")
    private BigDecimal valordosegurocalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outrasdespesascalculado")
    private BigDecimal outrasdespesascalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordoipicalculado")
    private BigDecimal valordoipicalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordosprodutoscalculado")
    private BigDecimal valordosprodutoscalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valordanotacalculado")
    private BigDecimal valordanotacalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descontogeral")
    private BigDecimal descontogeral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descontogeralcalculado")
    private BigDecimal descontogeralcalculado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesobruto")
    private BigDecimal pesobruto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesoliquido")
    private BigDecimal pesoliquido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidadevolume")
    private BigDecimal quantidadevolume;
    @Size(max = 10)
    @Column(name = "especievolume")
    private String especievolume;
    @Size(max = 10)
    @Column(name = "marcavolume")
    private String marcavolume;
    @Column(name = "numerovolume")
    private Integer numerovolume;
    @Size(max = 10)
    @Column(name = "placaveiculo")
    private String placaveiculo;
    @Size(max = 2)
    @Column(name = "ufveiculo")
    private String ufveiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impresso")
    private int impresso;
    @Size(max = 200)
    @Column(name = "observacao")
    private String observacao;
    @Size(max = 10)
    @Column(name = "serienf")
    private String serienf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancelada")
    private int cancelada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratear_desconto")
    private int ratearDesconto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nfentrada")
    private List<CfopNfentrada> cfopNfentradaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nfentrada")
    private List<ParcelasNfe> parcelasNfeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nfentrada")
    private List<ItemNfEntrada> itemNfEntradaList;

    public NfEntrada() {
    }

    public NfEntrada(Integer id) {
        this.id = id;
    }

    public NfEntrada(Integer id, String codigo, String notafiscal, Date entrada, Date emissao, int tipofrete, int freteagregado, BigDecimal baseicms, BigDecimal valoricms, BigDecimal basesubstituicao, BigDecimal valorsubstituicao, BigDecimal valordofrete, BigDecimal valordoseguro, BigDecimal outrasdespesas, BigDecimal valordoipi, BigDecimal valordosprodutos, BigDecimal valordanota, BigDecimal baseicmscalculado, BigDecimal valoricmscalculado, BigDecimal basesubstituicaocalculado, BigDecimal valorsubstituicaocalculado, BigDecimal valordofretecalculado, BigDecimal valordosegurocalculado, BigDecimal outrasdespesascalculado, BigDecimal valordoipicalculado, BigDecimal valordosprodutoscalculado, BigDecimal valordanotacalculado, BigDecimal descontogeral, BigDecimal descontogeralcalculado, BigDecimal pesobruto, BigDecimal pesoliquido, BigDecimal quantidadevolume, int status, int impresso, String modelo, int cancelada, int ratearDesconto) {
        this.id = id;
        this.codigo = codigo;
        this.notafiscal = notafiscal;
        this.entrada = entrada;
        this.emissao = emissao;
        this.tipofrete = tipofrete;
        this.freteagregado = freteagregado;
        this.baseicms = baseicms;
        this.valoricms = valoricms;
        this.basesubstituicao = basesubstituicao;
        this.valorsubstituicao = valorsubstituicao;
        this.valordofrete = valordofrete;
        this.valordoseguro = valordoseguro;
        this.outrasdespesas = outrasdespesas;
        this.valordoipi = valordoipi;
        this.valordosprodutos = valordosprodutos;
        this.valordanota = valordanota;
        this.baseicmscalculado = baseicmscalculado;
        this.valoricmscalculado = valoricmscalculado;
        this.basesubstituicaocalculado = basesubstituicaocalculado;
        this.valorsubstituicaocalculado = valorsubstituicaocalculado;
        this.valordofretecalculado = valordofretecalculado;
        this.valordosegurocalculado = valordosegurocalculado;
        this.outrasdespesascalculado = outrasdespesascalculado;
        this.valordoipicalculado = valordoipicalculado;
        this.valordosprodutoscalculado = valordosprodutoscalculado;
        this.valordanotacalculado = valordanotacalculado;
        this.descontogeral = descontogeral;
        this.descontogeralcalculado = descontogeralcalculado;
        this.pesobruto = pesobruto;
        this.pesoliquido = pesoliquido;
        this.quantidadevolume = quantidadevolume;
        this.status = status;
        this.impresso = impresso;
        this.modelo = modelo;
        this.cancelada = cancelada;
        this.ratearDesconto = ratearDesconto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(String notafiscal) {
        this.notafiscal = notafiscal;
    }

    public String getNotafiscalinterna() {
        return notafiscalinterna;
    }

    public void setNotafiscalinterna(String notafiscalinterna) {
        this.notafiscalinterna = notafiscalinterna;
    }

    public Integer getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Integer fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getOrdemdecompra() {
        return ordemdecompra;
    }

    public void setOrdemdecompra(Integer ordemdecompra) {
        this.ordemdecompra = ordemdecompra;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Integer getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Integer transportadora) {
        this.transportadora = transportadora;
    }

    public int getTipofrete() {
        return tipofrete;
    }

    public void setTipofrete(int tipofrete) {
        this.tipofrete = tipofrete;
    }

    public int getFreteagregado() {
        return freteagregado;
    }

    public void setFreteagregado(int freteagregado) {
        this.freteagregado = freteagregado;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
    }

    public BigDecimal getBasesubstituicao() {
        return basesubstituicao;
    }

    public void setBasesubstituicao(BigDecimal basesubstituicao) {
        this.basesubstituicao = basesubstituicao;
    }

    public BigDecimal getValorsubstituicao() {
        return valorsubstituicao;
    }

    public void setValorsubstituicao(BigDecimal valorsubstituicao) {
        this.valorsubstituicao = valorsubstituicao;
    }

    public BigDecimal getValordofrete() {
        return valordofrete;
    }

    public void setValordofrete(BigDecimal valordofrete) {
        this.valordofrete = valordofrete;
    }

    public BigDecimal getValordoseguro() {
        return valordoseguro;
    }

    public void setValordoseguro(BigDecimal valordoseguro) {
        this.valordoseguro = valordoseguro;
    }

    public BigDecimal getOutrasdespesas() {
        return outrasdespesas;
    }

    public void setOutrasdespesas(BigDecimal outrasdespesas) {
        this.outrasdespesas = outrasdespesas;
    }

    public BigDecimal getValordoipi() {
        return valordoipi;
    }

    public void setValordoipi(BigDecimal valordoipi) {
        this.valordoipi = valordoipi;
    }

    public BigDecimal getValordosprodutos() {
        return valordosprodutos;
    }

    public void setValordosprodutos(BigDecimal valordosprodutos) {
        this.valordosprodutos = valordosprodutos;
    }

    public BigDecimal getValordanota() {
        return valordanota;
    }

    public void setValordanota(BigDecimal valordanota) {
        this.valordanota = valordanota;
    }

    public BigDecimal getBaseicmscalculado() {
        return baseicmscalculado;
    }

    public void setBaseicmscalculado(BigDecimal baseicmscalculado) {
        this.baseicmscalculado = baseicmscalculado;
    }

    public BigDecimal getValoricmscalculado() {
        return valoricmscalculado;
    }

    public void setValoricmscalculado(BigDecimal valoricmscalculado) {
        this.valoricmscalculado = valoricmscalculado;
    }

    public BigDecimal getBasesubstituicaocalculado() {
        return basesubstituicaocalculado;
    }

    public void setBasesubstituicaocalculado(BigDecimal basesubstituicaocalculado) {
        this.basesubstituicaocalculado = basesubstituicaocalculado;
    }

    public BigDecimal getValorsubstituicaocalculado() {
        return valorsubstituicaocalculado;
    }

    public void setValorsubstituicaocalculado(BigDecimal valorsubstituicaocalculado) {
        this.valorsubstituicaocalculado = valorsubstituicaocalculado;
    }

    public BigDecimal getValordofretecalculado() {
        return valordofretecalculado;
    }

    public void setValordofretecalculado(BigDecimal valordofretecalculado) {
        this.valordofretecalculado = valordofretecalculado;
    }

    public BigDecimal getValordosegurocalculado() {
        return valordosegurocalculado;
    }

    public void setValordosegurocalculado(BigDecimal valordosegurocalculado) {
        this.valordosegurocalculado = valordosegurocalculado;
    }

    public BigDecimal getOutrasdespesascalculado() {
        return outrasdespesascalculado;
    }

    public void setOutrasdespesascalculado(BigDecimal outrasdespesascalculado) {
        this.outrasdespesascalculado = outrasdespesascalculado;
    }

    public BigDecimal getValordoipicalculado() {
        return valordoipicalculado;
    }

    public void setValordoipicalculado(BigDecimal valordoipicalculado) {
        this.valordoipicalculado = valordoipicalculado;
    }

    public BigDecimal getValordosprodutoscalculado() {
        return valordosprodutoscalculado;
    }

    public void setValordosprodutoscalculado(BigDecimal valordosprodutoscalculado) {
        this.valordosprodutoscalculado = valordosprodutoscalculado;
    }

    public BigDecimal getValordanotacalculado() {
        return valordanotacalculado;
    }

    public void setValordanotacalculado(BigDecimal valordanotacalculado) {
        this.valordanotacalculado = valordanotacalculado;
    }

    public BigDecimal getDescontogeral() {
        return descontogeral;
    }

    public void setDescontogeral(BigDecimal descontogeral) {
        this.descontogeral = descontogeral;
    }

    public BigDecimal getDescontogeralcalculado() {
        return descontogeralcalculado;
    }

    public void setDescontogeralcalculado(BigDecimal descontogeralcalculado) {
        this.descontogeralcalculado = descontogeralcalculado;
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        this.pesobruto = pesobruto;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public BigDecimal getQuantidadevolume() {
        return quantidadevolume;
    }

    public void setQuantidadevolume(BigDecimal quantidadevolume) {
        this.quantidadevolume = quantidadevolume;
    }

    public String getEspecievolume() {
        return especievolume;
    }

    public void setEspecievolume(String especievolume) {
        this.especievolume = especievolume;
    }

    public String getMarcavolume() {
        return marcavolume;
    }

    public void setMarcavolume(String marcavolume) {
        this.marcavolume = marcavolume;
    }

    public Integer getNumerovolume() {
        return numerovolume;
    }

    public void setNumerovolume(Integer numerovolume) {
        this.numerovolume = numerovolume;
    }

    public String getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(String placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

    public String getUfveiculo() {
        return ufveiculo;
    }

    public void setUfveiculo(String ufveiculo) {
        this.ufveiculo = ufveiculo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getImpresso() {
        return impresso;
    }

    public void setImpresso(int impresso) {
        this.impresso = impresso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSerienf() {
        return serienf;
    }

    public void setSerienf(String serienf) {
        this.serienf = serienf;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCancelada() {
        return cancelada;
    }

    public void setCancelada(int cancelada) {
        this.cancelada = cancelada;
    }

    public int getRatearDesconto() {
        return ratearDesconto;
    }

    public void setRatearDesconto(int ratearDesconto) {
        this.ratearDesconto = ratearDesconto;
    }

    @XmlTransient
    public List<CfopNfentrada> getCfopNfentradaList() {
        return cfopNfentradaList;
    }

    public void setCfopNfentradaList(List<CfopNfentrada> cfopNfentradaList) {
        this.cfopNfentradaList = cfopNfentradaList;
    }

    @XmlTransient
    public List<ParcelasNfe> getParcelasNfeList() {
        return parcelasNfeList;
    }

    public void setParcelasNfeList(List<ParcelasNfe> parcelasNfeList) {
        this.parcelasNfeList = parcelasNfeList;
    }

    @XmlTransient
    public List<ItemNfEntrada> getItemNfEntradaList() {
        return itemNfEntradaList;
    }

    public void setItemNfEntradaList(List<ItemNfEntrada> itemNfEntradaList) {
        this.itemNfEntradaList = itemNfEntradaList;
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
        if (!(object instanceof NfEntrada)) {
            return false;
        }
        NfEntrada other = (NfEntrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.module.jpa.model.NfEntrada[ id=" + id + " ]";
    }
    
}
