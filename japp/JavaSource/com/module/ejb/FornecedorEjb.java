package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IFornecedorEjb;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.AgenteExternoDao;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.FornecedorDao;
import com.module.jpa.model.AgenteExterno;

@Stateless
public class FornecedorEjb implements IFornecedorEjb {

	FornecedorDao dao; 
	
	public FornecedorEjb() {
		this.dao = new FornecedorDao();
    }
	
	@Override
	public AgenteExterno cadastrarFornecedor(AgenteExterno fornecedor) {
		AgenteExternoDao dao = new AgenteExternoDao();
		fornecedor.setDataalteracao(new Date());
		if (UtilsJapp.isNullOrZero(fornecedor.getId())){
			fornecedor.setTipo("F");
			fornecedor.setDatainclusao(new Date());
			dao.add(fornecedor);
		}else{
			dao.update(fornecedor);
		}
		return fornecedor;
	}

	@Override
	public AgenteExterno buscarFornecedor(AgenteExterno fornecedor) {
		if ((fornecedor != null)&&(!UtilsJapp.isNullOrZero(fornecedor.getId()))){
			AgenteExternoDao dao = new AgenteExternoDao();
			fornecedor = dao.getById(fornecedor.getId());
			return fornecedor;
		}else{
			return null;
		}
	}

	@Override
	public List<AgenteExterno> listarFornecedores(AgenteExterno fornecedor) {
		AgenteExternoDao dao = new AgenteExternoDao();		
		List<AgenteExterno> result = dao.findByExample(fornecedor);		
		return result;
	}

	@Override
	public void excluirFornecedor(AgenteExterno fornecedor) {
		Dao<AgenteExterno> dao = new Dao<AgenteExterno>();
		if (!UtilsJapp.isNullOrZero(fornecedor.getId())){
			fornecedor.setAtivo("0");
			dao.update(fornecedor);
		}
	}

	@Override
	public int buscarQtdFornecedor() {
		Dao<AgenteExterno> daoFornecedor = new Dao<AgenteExterno>();
		return daoFornecedor.count();
	}

}
