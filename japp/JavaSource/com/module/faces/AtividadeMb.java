package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IAtividadeEjb;
import com.module.jpa.model.Atividade;


@ManagedBean
@SessionScoped
public class AtividadeMb extends BaseMb{

	@EJB
	private IAtividadeEjb atividadeEjb;

	private Atividade atividade;
	private List<Atividade> listAtividade;
	
	@PostConstruct
	public void construcao(){
		super.posConstrucao();
	}
	
	public AtividadeMb(){		
		limpar();
	}

	public void limpar(){
		this.atividade = new Atividade();
		this.listAtividade = new ArrayList<Atividade>();  
	}
	
	public void buscar(){
		this.listAtividade = atividadeEjb.buscarAtividade(this.atividade);
	}
	
	public void salvar(){
		if (validarSalvarAtividade()){
			this.atividade = atividadeEjb.salvarAtividade(this.atividade);
			buscar();
		}
	}
	
	private boolean validarSalvarAtividade() {
		boolean ret = true;
		if ((this.atividade.getNome() == null)||("".equals(this.atividade.getNome()))){
			ret = false;
			addMsgError("Campo nome é obrigatório. ");
		}
		if ((this.atividade.getDescricao() == null)||("".equals(this.atividade.getDescricao()))){
			ret = false;
			addMsgError("Campo descrição é obrigatório. ");
		}
		return ret;
	}

	public void editar(Atividade us){
		this.atividade = us;
	}
	
	public void excluir(){
		
	}
	
	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<Atividade> getListAtividade() {
		return listAtividade;
	}

	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}

}
