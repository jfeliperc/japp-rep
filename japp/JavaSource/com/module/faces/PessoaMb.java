package com.module.faces;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IPessoaEjb;
import com.module.jpa.model.Contato;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Empresa> empresas;
	
	private Contato contatoTemp;
	
		
	public PessoaMb() {
		super();
		limpar();
	}

	public void solicitarCadastroPessoa(){
		pessoaEjb.solicitarCadastro(pessoa);
        addMsg("Solicitação de cadastro registrada.");
	}
		
	public void buscar(){
		try {
			this.pessoas = pessoaEjb.listarPessoas(this.pessoa);
			
			if ((this.pessoas != null)&&(!this.pessoas.isEmpty())&&(this.pessoas.size() == 1)){
				this.pessoa = this.pessoas.get(0);
				this.pessoas.clear();
			}else{
				setMostrarLista((this.pessoas != null)&&(!this.pessoas.isEmpty()));
			}
			
		} catch (Exception e) {
			addMsgError("Erro ao buscar pessoa(s) - "+e.getMessage());
		}
	}
	
	public void salvar(){
		if (validarSalvar()){
			try {
				this.pessoa = pessoaEjb.salvarPessoa(this.pessoa);
			} catch (NoSuchAlgorithmException e) {				
				addMsgError("Erro ao salvar dados - "+e.getMessage());
				//e.printStackTrace();
			}
			this.pessoas.clear();
			addMsg("Registro salvo com sucesso.");
		}
	}

	public void editar(Pessoa us){
		this.pessoa = us;
		alternaMostraLista();
	}

	
	private boolean validarSalvar() {
		boolean ret = true;
		if (StringUtils.isBlank(this.pessoa.getNomecompleto())){
			addMsgError("O campo Nome Completo ï¿½ obrigatï¿½rio");
			ret = false;
		}
		if (StringUtils.isBlank(this.pessoa.getCpf())){
			addMsgError("O campo CPF ï¿½ obrigatï¿½rio");
			ret = false;
		}
		return ret;
	}

	public void excluir(){
		String msgResult = this.pessoa.getId()+"-"+this.pessoa.getNomecompleto()+"-"+this.getPessoa().getCpf();		
		pessoaEjb.excluirPessoa(this.pessoa, true);
		addMsg("Processo de exclusão/inativação concluído. "+msgResult);
	}

	public void limpar(){
		this.pessoa = new Pessoa();
		this.contatoTemp = new Contato();
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Contato getContatoTemp() {
		return contatoTemp;
	}

	public void setContatoTemp(Contato contatoTemp) {
		this.contatoTemp = contatoTemp;
	}

}
