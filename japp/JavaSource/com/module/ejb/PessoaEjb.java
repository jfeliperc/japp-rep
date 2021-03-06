package com.module.ejb;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IPessoaEjb;
import com.module.enums.TipoPessoa;
import com.module.enums.TipoUsuario;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.ContatoDao;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.PessoaDao;
import com.module.jpa.model.Contato;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Pessoa;

@Stateless
public class PessoaEjb implements IPessoaEjb {

		
	@Override
	public Pessoa cadastrarPessoa(Pessoa pessoa) {		
		PessoaDao dao = new PessoaDao();
		if (UtilsJapp.isNullOrZero(pessoa.getId())){
			dao.add(pessoa);
		}else{
			dao.update(pessoa);
		}
		return pessoa;
	}

	@Override
	public Pessoa buscarPessoa(Pessoa pessoa) {
		if ((pessoa != null)&&(!UtilsJapp.isNullOrZero(pessoa.getId()))){
			PessoaDao dao = new PessoaDao();
			pessoa = dao.getById(pessoa.getId());

			pessoa.setContatos(dao.getContatosPessoa(pessoa));

			return pessoa;
		}else{
			return null;
		}
	}

	@Override
	public List<Pessoa> listarPessoas(Pessoa pessoa) {
		PessoaDao dao = new PessoaDao();		
		List<Pessoa> result = dao.findByExample(pessoa);		
		return result;
	}

	@Override
	public void excluirPessoa(Pessoa pessoa) {
		Dao<Pessoa> dao = new Dao<Pessoa>();
		if (pessoa.getId() != null){
			pessoa.setTipo("I");
			dao.update(pessoa);
		}
	}
	

	@Override
	public void excluirPessoa(Pessoa pessoa, boolean exclusaoFisica) {		
		if (!exclusaoFisica){			
			excluirPessoa(pessoa);
		}else{
			try{
				Dao<Pessoa> dao = new Dao<Pessoa>();
				if (pessoa.getId() != null){
					dao.delete(pessoa);
				}
			}catch (Exception ex){
				excluirPessoa(pessoa);
			}
		}
	}

	@Override
	public void solicitarCadastro(Pessoa pessoa) {
		Dao<Pessoa> daoPessoa = new Dao<Pessoa>();
		
		pessoa.setDataalteracao(new Date());
		pessoa.setTipo("1");		
		pessoa.setTipoPessoa(TipoPessoa.PF.getValor());
		pessoa.setTipoUsuario(TipoUsuario.USER_PDN.getValor());
		
		if (!StringUtils.isBlank(pessoa.getNomecompleto())){
			StringBuilder nomeRes = new StringBuilder();
			String[] partes = pessoa.getNomecompleto().split(" ");
			for (int i = 0; i < partes.length; i++) {
				if (i == 0){
					nomeRes.append(partes[0]);
				}else if (i == partes.length-1){
					nomeRes.append(" "+partes[i]);
				}else{
					nomeRes.append(" "+partes[i].substring(0,1));
				}
			}
			pessoa.setNome(nomeRes.toString());
		}
		
		if (pessoa.getId() == null){
			pessoa.setDatainclusao(new Date());
			pessoa.setEmpresa(null);
			daoPessoa.add(pessoa);
		}else{
			daoPessoa.update(pessoa);
		}
		
	}

	@Override
	public int buscarQtdPessoa() {
		Dao<Pessoa> daoPessoa = new Dao<Pessoa>();
		return daoPessoa.count();
	}
	
	@Override
	public Pessoa buscarPorLogin(String login){
		PessoaDao dao = new PessoaDao();
		Pessoa retorno = null;
		if (login != null){
//			List<Pessoa> res = dao.getByLogin(login);
//			if (res != null){
//				retorno = res.get(0);
//			}
			retorno = dao.getByLogin(login);
		}else{
			retorno = null;
		}
		return retorno;
	}

	@Override
	public boolean validarLogin(String login, String pass, Empresa empresaId) throws NoSuchAlgorithmException {
		boolean ret = false;
		
		String criptPass = GeralEjb.convertPasswordToMD5(pass);
		
		Pessoa pessoa = buscarPorLogin(login);
		
		if ((pessoa != null)&&(pessoa.getPass() != null)){
			ret = pessoa.getPass().equals(criptPass);
		}
		
		return ret;
	}

	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) throws NoSuchAlgorithmException {
		Dao<Pessoa> daoPessoa = new Dao<Pessoa>();
		
		pessoa.setDataalteracao(new Date());
		pessoa.setTipo("1");		
		pessoa.setTipoPessoa(TipoPessoa.PF.getValor());
		pessoa.setTipoUsuario(TipoUsuario.USER_PDN.getValor());
		
		if (!StringUtils.isBlank(pessoa.getPass())){
			pessoa.setPass(GeralEjb.convertPasswordToMD5(pessoa.getPass()));
		}
		
		if (UtilsJapp.isNullOrZero(pessoa.getId())){
			pessoa.setId(null);
			pessoa.setDatainclusao(new Date());
			
			if ((pessoa.getEmpresa() == null)||(UtilsJapp.isNullOrZero(pessoa.getEmpresa().getId()))){
				pessoa.setEmpresa(null);
			}
			
			daoPessoa.add(pessoa);
		}else{
			if ((pessoa.getEmpresa() == null)||(UtilsJapp.isNullOrZero(pessoa.getEmpresa().getId()))){
				pessoa.setEmpresa(null);
			}
			daoPessoa.update(pessoa);
		}
		return pessoa;
	}

	@Override
	public List<Pessoa> listarPessoasAcesso(Pessoa pessoa) {
		List<Pessoa> pessoas = listarPessoas(pessoa);
		
		
		return pessoas;
	}

	@Override
	public void salvarContatoPessoa(Contato contato) {
		Dao<Contato> dao = new Dao<Contato>();
		if (contato.getPessoa() != null){
			if (UtilsJapp.isNullOrZero(contato.getId())){
				dao.add(contato);
			}else{
				dao.update(contato);
			}
		}
	}

	@Override
	public void removeAllContatos(Pessoa pessoa) {
		ContatoDao dao = new ContatoDao();
		if (!UtilsJapp.isNullOrZero(pessoa.getId())){
			dao.removeAllByPessoa(pessoa);
		}
	}

	@Override
	public void salvarListContatoPessoa(Pessoa pessoa,List<Contato> contatosTemp) {
		ContatoDao dao = new ContatoDao();
		if ((!UtilsJapp.isNullOrZero(pessoa.getId()))&&(contatosTemp != null)){
			for (Contato contato : contatosTemp) {
				contato.setId(null);
				contato.setPessoa(pessoa);
				dao.add(contato);
			}
		}
	}

	@Override
	public List<Contato> buscarContatos(Pessoa pessoa) {
		ContatoDao dao = new ContatoDao();
		if (!UtilsJapp.isNullOrZero(pessoa.getId())){
			return dao.getContatosPessoa(pessoa);
		}
		return null;
		
	}
	
	


}
