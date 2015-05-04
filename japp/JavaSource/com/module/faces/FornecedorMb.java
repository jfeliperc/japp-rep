package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IFornecedorEjb;
import com.module.jpa.model.AgenteExterno;


@ManagedBean
@SessionScoped
public class FornecedorMb extends BaseMb{

	@EJB
	private IFornecedorEjb fornecedorEjb;

	private AgenteExterno fornecedor;
	private List<AgenteExterno> listFornecedor;

	public FornecedorMb(){
		super();
		limpar();
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
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.fornecedor = fornecedorEjb.cadastrarFornecedor(this.fornecedor);
		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.fornecedor.getNome())){
			addMsgError("O campo Nome � obrigat�rio");
			ret = false;
		}
		if (StringUtils.isBlank(this.fornecedor.getCnpj())){
			addMsgError("O campo CPF � obrigat�rio");
			ret = false;
		}
		return ret;
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
	
}
