package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IServicoEjb;
import com.module.jpa.model.Servico;


@ManagedBean
@SessionScoped
public class ServicoMb extends BaseMb{

	@EJB
	private IServicoEjb servicoEjb;

	private Servico servico;	
	private List<Servico> listServico;
	
	@PostConstruct
	public void construcao(){
		
	}
	
	public ServicoMb(){		
		limpar();
	}

	public void limpar(){
		this.servico = new Servico();
		this.listServico = new ArrayList<Servico>();  
	}
	
	public void buscar(){
		this.listServico = servicoEjb.buscarServico(this.servico);
	}
	
	public void salvar(){
		if (validarSalvarServico()){
			this.servico = servicoEjb.salvarServico(this.servico);
			buscar();
		}
	}
	
	public void editar(Servico us){
		this.servico = us;
		//buscar();
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
	
	
	
}
