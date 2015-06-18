package com.module.faces;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.module.ejb.contract.IAcessoEjb;
import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Acesso;
import com.module.jpa.model.Pessoa;
import com.module.jpa.model.Rotina;

@ManagedBean
@SessionScoped
public class AcessoMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	@EJB
	private IAcessoEjb acessoEjb;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;	
	private List<Acesso> acessosPessoa;
	private List<Rotina> rotinas;	
	private List<Acesso> modulos;		
	private List<Acesso> acessos;
		
	
	public AcessoMb() {
		super();
	}
	
	@PostConstruct
	public void posConstrucao(){
		limpar();
	}
		
	public void buscar(){
		try {
			this.pessoas = pessoaEjb.listarPessoasAcesso(this.pessoa);
			
			if ((this.pessoas != null)&&(!this.pessoas.isEmpty())&&(this.pessoas.size() == 1)){
				this.pessoa = this.pessoas.get(0);
				this.pessoas.clear();
			}else{
				setMostrarLista((this.pessoas != null)&&(!this.pessoas.isEmpty()));
			}
			
			if ((this.pessoa != null)&&(this.pessoa.getId() != null)&&(this.pessoa.getId() > 0)){
				acessosPessoa = acessoEjb.listarAcessos(this.pessoa);
			}
			
			prepararModulos();
			prepararAcessos();
			
		} catch (Exception e) {
			addMsgError("Erro ao buscar pessoa(s) - "+e.getMessage());
		}
	}
	
	private void prepararAcessos() {
		for (Rotina rotina : rotinas) {
			if (rotina.getRotinaPai() > 0){
				Acesso mod = new Acesso();
				mod.setRotina2(rotina);
				acessos.add(mod);
			}
		}
		
		for (Acesso acesso : acessos) {
			for (Acesso acessoPessoa : acessosPessoa) {
				acesso.setStatus( (acessoPessoa.getRotina2().getId() == acesso.getRotina2().getId()) ? 1 : 0 );
			}
		}
	}

	private void prepararModulos() {
		for (Rotina rotina : rotinas) {
			if (rotina.getRotinaPai() == 0){
				Acesso mod = new Acesso();
				mod.setRotina1(rotina);
				modulos.add(mod);
			}
		}
		
		for (Acesso modulo : modulos) {
			for (Acesso acesso : acessosPessoa) {
				modulo.setStatus( (acesso.getRotina1().getId() == modulo.getRotina1().getId()) ? 1 : 0 );
			}
		}
	}

	public void detalharModulo(Acesso modulo){
		
	}
	
	public void liberarModulo(Acesso modulo){
		
	}
	
	public void bloquearModulo(Acesso modulo){
		
	}
	
	public void liberarAcesso(Acesso modulo){
		
	}
	
	public void bloquearAcesso(Acesso modulo){
		
	}
	
	public void salvar(){
		if (validarSalvar()){
			try {
				this.pessoa = pessoaEjb.salvarPessoa(this.pessoa);
			} catch (NoSuchAlgorithmException e) {
				addMsgError("Erro ao salvar dados - "+e.getMessage());
			}
		}
	}

	private boolean validarSalvar() {
		
		return false;
	}
	
	public void editarPessoa(Pessoa us){
		this.pessoa = us;
		alternaMostraLista();
	}
	
	public void limpar(){
		this.pessoa = new Pessoa();
		this.rotinas = acessoEjb.listarTodasRotinas();
		this.acessos = new ArrayList<Acesso>();
		this.modulos = new ArrayList<Acesso>();
		this.acessosPessoa = new ArrayList<Acesso>();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Acesso> getAcessosPessoa() {
		return acessosPessoa;
	}

	public void setAcessosPessoa(List<Acesso> acessosPessoa) {
		this.acessosPessoa = acessosPessoa;
	}

	public List<Rotina> getRotinas() {
		return rotinas;
	}

	public void setRotinas(List<Rotina> rotinas) {
		this.rotinas = rotinas;
	}

	public List<Acesso> getModulos() {
		return modulos;
	}

	public void setModulos(List<Acesso> modulos) {
		this.modulos = modulos;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}
	
	

}
