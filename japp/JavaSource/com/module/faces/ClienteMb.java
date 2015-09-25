package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IClienteEjb;
import com.module.enums.TipoPessoa;
import com.module.jpa.model.AgenteExterno;

@ManagedBean
@SessionScoped
public class ClienteMb extends BaseMb{

	@EJB
	private IClienteEjb clienteEjb;

	private AgenteExterno cliente;
	private List<AgenteExterno> listCliente;
	
	public ClienteMb() {
		super();
		this.cliente = new AgenteExterno();
	}

	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		limpar();
	}
	
	public void limpar(){
		this.cliente = new AgenteExterno();
		this.listCliente = new ArrayList<AgenteExterno>();
	}
	
	public void buscar(){
		this.cliente.setEmpresa(getEmpresaAux());
		this.listCliente = clienteEjb.listarClientes(cliente);
		if ((this.listCliente != null)&&(!this.listCliente.isEmpty())&&(this.listCliente.size() == 1)){
			this.cliente = this.listCliente.get(0);
			empresaAux = this.cliente.getEmpresa();
			this.listCliente.clear();		
		}else if ((this.listCliente == null)||(this.listCliente.isEmpty())){
			addMsg("Nenhum cliente encontrado na busca.");
			limpar();
		}else{
			setMostrarLista((this.listCliente != null)&&(!this.listCliente.isEmpty()));
		}
		
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (TipoPessoa.PF.getValor().equals(this.cliente.getTipoPessoa())){
			if (StringUtils.isBlank(this.cliente.getNome())){
				addMsgError("O campo Nome é obrigatório");
				ret = false;
			}
			if (StringUtils.isBlank(this.cliente.getCpf())){
				addMsgError("O campo CPF é obrigatório");
				ret = false;
			}
		}else{
			if (StringUtils.isBlank(this.cliente.getRazaoSocial())){
				addMsgError("O campo Razão social é obrigatório");
				ret = false;
			}
			if (StringUtils.isBlank(this.cliente.getNomeFantasia())){
				addMsgError("O campo Nome Fantasia é obrigatório");
				ret = false;
			}
			if (StringUtils.isBlank(this.cliente.getCnpj())){
				addMsgError("O campo CNPJ é obrigatório");
				ret = false;
			}
		}
		return ret;
	}
	
	public void salvar(){
		if (validarSalvar()){
			this.cliente.setEmpresa(getEmpresaAux());
			this.cliente = clienteEjb.cadastrarCliente(this.cliente);
		}
	}
	
	public void excluir(){
		if (validarSalvar()){
			clienteEjb.excluirCliente(this.cliente);
		}
	}
	
	public void editar(AgenteExterno us){
		this.cliente = us;
		empresaAux = this.cliente.getEmpresa();
		alternaMostraLista();
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
