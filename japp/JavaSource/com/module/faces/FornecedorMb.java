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
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Fornecedor;


@ManagedBean
@SessionScoped
public class FornecedorMb extends BaseMb{

	@EJB
	private IFornecedorEjb fornecedorEjb;
	@EJB
	private IEmpresaEjb empresaEjb;
			
	private Fornecedor fornecedor;
	private List<Fornecedor> listFornecedor;

	public FornecedorMb(){
		super();
		limpar();
	}
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
	}
	
	public void limpar(){
		this.fornecedor = new Fornecedor();
		this.listFornecedor = new ArrayList<Fornecedor>();
		empresaAux = new Empresa();
	}
	
	public void buscar(){		
		this.fornecedor.setEmpresa(empresaAux);
		
		this.listFornecedor = fornecedorEjb.listarFornecedores(fornecedor);
		
		if ((this.listFornecedor != null)&&(!this.listFornecedor.isEmpty())&&(this.listFornecedor.size() == 1)){
			this.fornecedor = this.listFornecedor.get(0);
			empresaAux = this.fornecedor.getEmpresa();
			this.listFornecedor.clear();
		}else if ((this.listFornecedor == null)||(this.listFornecedor.isEmpty())){
			addMsg("Nenhum fornecedor encontrado na busca.");
			limpar();
		}else{
			empresaAux = new Empresa();
			setMostrarLista((this.listFornecedor != null)&&(!this.listFornecedor.isEmpty()));
		}
	}
	
	public void salvar(){
		
		if (validarSalvar()){
			try {
				this.fornecedor.setEmpresa(empresaAux);
				this.fornecedor = fornecedorEjb.cadastrarFornecedor(this.fornecedor);
			} catch (Exception e) {				
				addMsgError("Erro ao salvar dados - "+e.getMessage());
			}
			this.listFornecedor.clear();
			addMsg("Registro salvo com sucesso.");
		}
		
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.fornecedor.getRazaoSocial())){
			addMsgError("O campo Raz�o Social � obrigat�rio");
			ret = false;
		}
		if (StringUtils.isBlank(this.fornecedor.getCnpj())){
			addMsgError("O campo CNPJ � obrigat�rio");
			ret = false;
		}
		return ret;
	}

	public void editar(Fornecedor us){
		this.fornecedor = us;
		this.fornecedor = fornecedorEjb.buscarFornecedor(this.fornecedor);	
		empresaAux = this.fornecedor.getEmpresa();	
		alternaMostraLista();
	}
	
	public void excluir(){

	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getListFornecedor() {
		return listFornecedor;
	}

	public void setListFornecedor(List<Fornecedor> listFornecedor) {
		this.listFornecedor = listFornecedor;
	}
	
}
