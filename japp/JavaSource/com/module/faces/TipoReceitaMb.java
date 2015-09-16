package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IReceitaEjb;
import com.module.jpa.model.Receita;
import com.module.jpa.model.TipoReceita;


@ManagedBean
@SessionScoped
public class TipoReceitaMb extends BaseMb{

	@EJB
	private IReceitaEjb receitaEjb;

	private TipoReceita tipoReceita;
	private List<TipoReceita> listTipoReceita;
	
	@PostConstruct
	public void construcao(){
		
	}
	
	public TipoReceitaMb(){		
		limpar();
	}

	public void limpar(){
		this.tipoReceita = new TipoReceita();
		this.listTipoReceita = new ArrayList<TipoReceita>();  
	}
	
	public void buscar(){
		this.listTipoReceita = receitaEjb.buscarTipoReceita(this.tipoReceita);
	}
	
	public void salvar(){
		if (validarSalvarTipoReceita()){
			this.tipoReceita = receitaEjb.salvarTipoReceita(this.tipoReceita);
			buscar();
		}
	}
	
	private boolean validarSalvarTipoReceita() {
		boolean ret = true;
		if ((this.tipoReceita.getNome() == null)||("".equals(this.tipoReceita.getNome()))){
			ret = false;
			addMsgError("Campo nome é obrigatório. (Tipo Receita)");
		}
		if ((this.tipoReceita.getDescricao() == null)||("".equals(this.tipoReceita.getDescricao()))){
			ret = false;
			addMsgError("Campo descrição é obrigatório. (Tipo Receita)");
		}
		return ret;
	}

	public void editar(TipoReceita us){
		this.tipoReceita = us;
	}
	
	public void excluir(){
		
	}
	
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public List<TipoReceita> getListTipoReceita() {
		return listTipoReceita;
	}

	public void setListTipoReceita(List<TipoReceita> listTipoReceita) {
		this.listTipoReceita = listTipoReceita;
	}

}
