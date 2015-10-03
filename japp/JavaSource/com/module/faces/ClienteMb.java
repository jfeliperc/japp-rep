package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DualListModel;

import com.module.ejb.contract.IClienteEjb;
import com.module.ejb.contract.IServicoEjb;
import com.module.enums.TipoPessoa;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.model.Cliente;
import com.module.jpa.model.Servico;

@ManagedBean
@SessionScoped
public class ClienteMb extends BaseMb{

	@EJB
	private IClienteEjb clienteEjb;

	@EJB
	private IServicoEjb servicoEjb;
	
	private Cliente cliente;
	private List<Cliente> listCliente;
	
	private List<Servico> listServico;
	private List<Servico> listServicoSelect;
	private DualListModel<Servico> listServicoSelecao;
	
	public ClienteMb() {
		super();
		this.cliente = new Cliente();
	}

	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();
		limpar();
	}
	
	public void limpar(){
		this.cliente = new Cliente();
		this.listCliente = new ArrayList<Cliente>();
		
		this.listServico = servicoEjb.buscarAllServicos();
		
		this.listServicoSelecao = new DualListModel<Servico>(listServico, listServicoSelect);
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
		
		if (UtilsJapp.isNullOrZero(this.cliente.getId())){
			this.cliente = clienteEjb.buscarServicoCliente(this.cliente);
			this.listServicoSelect = this.cliente.getServicos();
		}
	}
	
	private boolean validarSalvar() {
		boolean ret = true;
		if (TipoPessoa.PF.getValor().equals(this.cliente.getTipoPessoa())){
			if (StringUtils.isBlank(this.cliente.getNome())){
				addMsgError("O campo Nome � obrigat�rio");
				ret = false;
			}
			if (StringUtils.isBlank(this.cliente.getCpf())){
				addMsgError("O campo CPF � obrigat�rio");
				ret = false;
			}
		}else{
			if (StringUtils.isBlank(this.cliente.getRazaoSocial())){
				addMsgError("O campo Raz�o social � obrigat�rio");
				ret = false;
			}
			if (StringUtils.isBlank(this.cliente.getNomeFantasia())){
				addMsgError("O campo Nome Fantasia � obrigat�rio");
				ret = false;
			}
			if (StringUtils.isBlank(this.cliente.getCnpj())){
				addMsgError("O campo CNPJ � obrigat�rio");
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
	
	public void editar(Cliente us){
		this.cliente = us;
		empresaAux = this.cliente.getEmpresa();
		alternaMostraLista();
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public List<Servico> getListServico() {
		return listServico;
	}

	public void setListServico(List<Servico> listServico) {
		this.listServico = listServico;
	}

	public List<Servico> getListServicoSelect() {
		return listServicoSelect;
	}

	public void setListServicoSelect(List<Servico> listServicoSelect) {
		this.listServicoSelect = listServicoSelect;
	}

	public DualListModel<Servico> getListServicoSelecao() {
		return listServicoSelecao;
	}

	public void setListServicoSelecao(DualListModel<Servico> listServicoSelecao) {
		this.listServicoSelecao = listServicoSelecao;
	}
	
}
