package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import com.module.ejb.contract.IAtividadeEjb;
import com.module.ejb.contract.IClienteEjb;
import com.module.ejb.contract.IServicoEjb;
import com.module.jpa.model.Atividade;
import com.module.jpa.model.Cliente;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Servico;


@ManagedBean
@ViewScoped
public class ServicoMb extends BaseMb{

	@EJB
	private IServicoEjb servicoEjb;
	
	@EJB
	private IAtividadeEjb atividadeEjb;
	
	@EJB
	private IClienteEjb clienteEjb;
	
	private Servico servico;	
	private List<Servico> listServico;

	private List<Atividade> listAtividade;
	private List<Atividade> listAtividadeSelect;
	private DualListModel<Atividade> listAtividadeSelecao;
	
	private List<Cliente> listCliente;
	private List<Cliente> listClienteSelect;
	private DualListModel<Cliente> listClienteSelecao;
	
	private Atividade atividadeTemp;
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();

		this.listAtividadeSelecao = new DualListModel<Atividade>(listAtividade, listAtividadeSelect);
		this.listClienteSelecao = new DualListModel<Cliente>(listCliente, listClienteSelect);
	}
	
	public ServicoMb(){	
		this.servico = new Servico();
		this.listServico = new ArrayList<Servico>(); 
		this.atividadeTemp = new Atividade();

		this.listAtividadeSelecao = new DualListModel<Atividade>(listAtividade, listAtividadeSelect);
		this.listClienteSelecao = new DualListModel<Cliente>(listCliente, listClienteSelect);
	}

	public void limpar(){
		this.servico = new Servico();
		this.listServico = new ArrayList<Servico>(); 
		this.atividadeTemp = new Atividade();
		empresaAux = new Empresa();
		super.recarregarListEmpresa();		

		this.listCliente = clienteEjb.buscarAllClientes();
		this.listAtividade = atividadeEjb.buscarAllAtividades();
		
		this.listAtividadeSelect = new ArrayList<Atividade>();
		this.listClienteSelect = new ArrayList<Cliente>();
		
		this.listAtividadeSelecao = new DualListModel<Atividade>(listAtividade, listAtividadeSelect);
		this.listClienteSelecao = new DualListModel<Cliente>(listCliente, listClienteSelect);
		
	}
	
	public void buscar(){
		this.listServico = servicoEjb.buscarServico(this.servico);		
		if ((this.listServico != null)&&(!this.listServico.isEmpty())&&(this.listServico.size() == 1)){
			this.servico = this.listServico.get(0);
			this.listServico.clear();
		}else if ((this.listServico == null)||(this.listServico.isEmpty())){
			addMsg("Nenhum serviço encontrado na busca.");
			limpar();
		}else{
			setMostrarLista((this.listServico != null)&&(!this.listServico.isEmpty()));
		}
		
	}
	
	public void salvar(){
		if (validarSalvarServico()){
			this.servico.setEmpresa(empresaAux);
			this.servico = servicoEjb.salvarServico(this.servico);
			buscar();
		}
	}
	
	public void editar(Servico us){
		this.servico = us;
		empresaAux = this.servico.getEmpresa() == null ? new Empresa() : this.servico.getEmpresa();
		alternaMostraLista();
	}
	
	private boolean validarSalvarServico() {
		boolean ret = true;
		if ((this.servico.getNome() == null)||("".equals(this.servico.getNome()))){
			ret = false;
			addMsgError("Campo nome � obrigat�rio. ");
		}
		if ((this.servico.getDescricao() == null)||("".equals(this.servico.getDescricao()))){
			ret = false;
			addMsgError("Campo descri��o � obrigat�rio. ");
		}
		return ret;
	}

	public void excluir(){

	}
	
	public void limparAtividade(){
		
	}
	
	public void buscarAtividade(){

	}

	public void salvarAtividade(){

	}

	public void excluirAtividade(){

	}
	
	public void editarAtividade(Atividade us){
		this.atividadeTemp = us;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getListServico() {
		return listServico;
	}

	public void setListServico(List<Servico> listServico) {
		this.listServico = listServico;
	}

	public Atividade getAtividadeTemp() {
		return atividadeTemp;
	}

	public void setAtividadeTemp(Atividade atividadeTemp) {
		this.atividadeTemp = atividadeTemp;
	}

	public List<Atividade> getListAtividade() {
		return listAtividade;
	}

	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}

	public List<Atividade> getListAtividadeSelect() {
		return listAtividadeSelect == null ? new ArrayList<Atividade>() : listAtividadeSelect;
	}

	public void setListAtividadeSelect(List<Atividade> listAtividadeSelect) {
		this.listAtividadeSelect = listAtividadeSelect;
	}

	public DualListModel<Atividade> getListAtividadeSelecao() {
		return listAtividadeSelecao;
	}

	public void setListAtividadeSelecao(
			DualListModel<Atividade> listAtividadeSelecao) {
		this.listAtividadeSelecao = listAtividadeSelecao;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public List<Cliente> getListClienteSelect() {
		return listClienteSelect == null ? new ArrayList<Cliente>() : listClienteSelect;
	}

	public void setListClienteSelect(List<Cliente> listClienteSelect) {
		this.listClienteSelect = listClienteSelect;
	}

	public DualListModel<Cliente> getListClienteSelecao() {
		return listClienteSelecao;
	}

	public void setListClienteSelecao(DualListModel<Cliente> listClienteSelecao) {
		this.listClienteSelecao = listClienteSelecao;
	}
	
}
