package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IEmpresaEjb;
import com.module.ejb.contract.IFornecedorEjb;
import com.module.jpa.model.AgenteExterno;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Pessoa;


@ManagedBean
@SessionScoped
public class FornecedorMb extends BaseMb{

	@EJB
	private IFornecedorEjb fornecedorEjb;
	@EJB
	private IEmpresaEjb empresaEjb;
	
	private List<Empresa> empresas;
		
	private AgenteExterno fornecedor;
	private List<AgenteExterno> listFornecedor;

	public FornecedorMb(){
		super();
		limpar();
	}
	
	@PostConstruct
	public void posConstrucao(){
		this.empresas = empresaEjb.listarEmpresas(new Empresa());
	}
	
	public void limpar(){
		this.fornecedor = new AgenteExterno();
		this.listFornecedor = new ArrayList<AgenteExterno>();
	}
	
	public void buscar(){
		this.listFornecedor = fornecedorEjb.listarFornecedores(fornecedor);
		if ((this.listFornecedor != null)&&(!this.listFornecedor.isEmpty())&&(this.listFornecedor.size() == 1)){
			this.fornecedor = this.listFornecedor.get(0);
			this.listFornecedor.clear();
		}else if ((this.listFornecedor == null)||(this.listFornecedor.isEmpty())){
			addMsg("Nenhum fornecedor encontrado na busca.");
			limpar();
		}else{
			setMostrarLista((this.listFornecedor != null)&&(!this.listFornecedor.isEmpty()));
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.fornecedor = fornecedorEjb.cadastrarFornecedor(this.fornecedor);
		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.fornecedor.getRazaoSocial())){
			addMsgError("O campo Razão Social é obrigatório");
			ret = false;
		}
		if (StringUtils.isBlank(this.fornecedor.getCnpj())){
			addMsgError("O campo CPF é obrigatório");
			ret = false;
		}
		return ret;
	}

	public void editar(AgenteExterno us){
		this.fornecedor = us;
		this.fornecedor = fornecedorEjb.buscarFornecedor(this.fornecedor);		
		alternaMostraLista();
	}
	
	public void excluir(){

	}
	
	public AgenteExterno getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(AgenteExterno fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<AgenteExterno> getListFornecedor() {
		return listFornecedor;
	}

	public void setListFornecedor(List<AgenteExterno> listFornecedor) {
		this.listFornecedor = listFornecedor;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	
}
