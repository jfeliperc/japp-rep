package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IClienteEjb;
import com.module.jpa.model.AgenteExterno;

@ManagedBean
@SessionScoped
public class ClienteMb extends BaseMb{

	@EJB
	private IClienteEjb clienteEjb;

	private AgenteExterno cliente;
	private List<AgenteExterno> listCliente;

	@PostConstruct
	public void posConstrucao(){
		limpar();
	}
	
	public void limpar(){
		this.cliente = new AgenteExterno();
		this.listCliente = new ArrayList<AgenteExterno>();
	}
	
	public void buscar(){
		this.listCliente = clienteEjb.listarClientes(cliente);
		if ((this.listCliente != null)&&(!this.listCliente.isEmpty())&&(this.listCliente.size() == 1)){
			this.cliente = this.listCliente.get(0);
			this.listCliente.clear();
		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.cliente.getNome())){
			addMsgError("O campo Nome é obrigatório");
			ret = false;
		}
		if (StringUtils.isBlank(this.cliente.getCpf())){
			addMsgError("O campo CPF é obrigatório");
			ret = false;
		}
		return ret;
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.cliente = clienteEjb.cadastrarCliente(this.cliente);
		}
	}
	
	public void excluir(){

	}
	
	public AgenteExterno getCliente() {
		return cliente;
	}

	public void setCliente(AgenteExterno cliente) {
		this.cliente = cliente;
	}

	public List<AgenteExterno> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<AgenteExterno> listCliente) {
		this.listCliente = listCliente;
	}
	
}
