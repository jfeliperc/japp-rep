package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IPessoaEjb;
import com.module.enums.TipoPessoa;
import com.module.enums.TipoUsuario;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.PessoaDao;
import com.module.jpa.model.Pessoa;

@Stateless
public class PessoaEjb implements IPessoaEjb {

	@Override
	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		
		Dao<Pessoa> dao = new Dao<Pessoa>();
		if (pessoa.getId() == null){
			dao.add(pessoa);
		}else{
			dao.update(pessoa);
		}
		return pessoa;
	}

	@Override
	public Pessoa buscarPessoa(Pessoa pessoa) {
		Dao<Pessoa> dao = new Dao<Pessoa>();
		return dao.getById(pessoa.getId());
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
			dao.delete(pessoa);
		}
	}

	@Override
	public void solicitarCadastro(Pessoa pessoa) {
		Dao<Pessoa> daoPessoa = new Dao<Pessoa>();
		
		pessoa.setDataalteracao(new Date());
		pessoa.setTipo("1");		
		pessoa.setTipoPessoa(TipoPessoa.PF.getValor());
		pessoa.setTipoUsuario(TipoUsuario.USER_PDN.getValor());
		
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
	public boolean validarLogin(String login, String pass, Integer empresaId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

}
