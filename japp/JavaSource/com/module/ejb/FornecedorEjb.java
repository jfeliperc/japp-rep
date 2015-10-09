package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IFornecedorEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.FornecedorDao;
import com.module.jpa.model.Fornecedor;

@Stateless
public class FornecedorEjb implements IFornecedorEjb {

	FornecedorDao dao; 
	
	public FornecedorEjb() {
		this.dao = new FornecedorDao();
    }
	
	@Override
	public Fornecedor cadastrarFornecedor(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();
		fornecedor.setDataalteracao(new Date());
		if (UtilsJapp.isNullOrZero(fornecedor.getId())){
			
			if ((fornecedor.getEmpresa() == null)||(UtilsJapp.isNullOrZero(fornecedor.getEmpresa().getId()))){
				fornecedor.setEmpresa(null);
			}
			
			fornecedor.setId(null);
			fornecedor.setTipo("F");
			fornecedor.setDatainclusao(new Date());
			dao.add(fornecedor);
		}else{
			
			if ((fornecedor.getEmpresa() == null)||(UtilsJapp.isNullOrZero(fornecedor.getEmpresa().getId()))){
				fornecedor.setEmpresa(null);
			}
			
			dao.update(fornecedor);
		}
		return fornecedor;
	}

	@Override
	public Fornecedor buscarFornecedor(Fornecedor fornecedor) {
		if ((fornecedor != null)&&(!UtilsJapp.isNullOrZero(fornecedor.getId()))){
			FornecedorDao dao = new FornecedorDao();
			fornecedor = dao.getById(fornecedor.getId());
			return fornecedor;
		}else{
			return null;
		}
	}

	@Override
	public List<Fornecedor> listarFornecedores(Fornecedor fornecedor) {
		FornecedorDao dao = new FornecedorDao();	
		fornecedor.setTipo("F");
		List<Fornecedor> result = dao.findByExample(fornecedor);		
		return result;
	}

	@Override
	public void excluirFornecedor(Fornecedor fornecedor) {
		Dao<Fornecedor> dao = new Dao<Fornecedor>();
		if (!UtilsJapp.isNullOrZero(fornecedor.getId())){
			fornecedor.setAtivo("0");
			dao.update(fornecedor);
		}
	}

	@Override
	public int buscarQtdFornecedor() {
		Dao<Fornecedor> daoFornecedor = new Dao<Fornecedor>();
		return daoFornecedor.count();
	}

}
