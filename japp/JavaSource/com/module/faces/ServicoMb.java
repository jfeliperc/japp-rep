package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IServicoEjb;
import com.module.jpa.model.Atividade;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Servico;
import com.sun.media.sound.EmergencySoundbank;


@ManagedBean
@SessionScoped
public class ServicoMb extends BaseMb{

	@EJB
	private IServicoEjb servicoEjb;

	private Servico servico;	
	private List<Servico> listServico;
	
	private Atividade atividadeTemp;
	
	@PostConstruct
	public void posConstrucao(){
		super.posConstrucao();		
	}
	
	public ServicoMb(){	
		this.servico = new Servico();
		this.listServico = new ArrayList<Servico>(); 
		this.atividadeTemp = new Atividade();
	}

	public void limpar(){
		this.servico = new Servico();
		this.listServico = new ArrayList<Servico>(); 
		this.atividadeTemp = new Atividade();
		empresaAux = new Empresa();
		super.recarregarListEmpresa();
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
			addMsgError("Campo nome é obrigatório. ");
		}
		if ((this.servico.getDescricao() == null)||("".equals(this.servico.getDescricao()))){
			ret = false;
			addMsgError("Campo descrição é obrigatório. ");
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
	
}
