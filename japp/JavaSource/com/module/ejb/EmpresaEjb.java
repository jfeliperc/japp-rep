package com.module.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IEmpresaEjb;
import com.module.jpa.dao.Dao;
import com.module.jpa.dao.EmpresaDao;
import com.module.jpa.model.Empresa;

@Stateless
public class EmpresaEjb implements IEmpresaEjb, Serializable {

	private static final long serialVersionUID = -1726009947698756447L;

	EmpresaDao dao;
	
	public EmpresaEjb() {
		this.dao = new EmpresaDao();
    }

	@Override
	public Empresa cadastrarEmpresa(Empresa empresa) {
		Dao<Empresa> dao = new Dao<Empresa>();
		if ((empresa.getEmpresaId() == null)||(empresa.getEmpresaId().intValue() == 0)){
			empresa.setEmpresaId(null);
			dao.add(empresa);
		}else{
			dao.update(empresa);
		}
		return empresa;
	}

	@Override
	public Empresa buscarEmpresa(Empresa empresa) {
		
		return null;
	}

	@Override
	public List<Empresa> listarEmpresas(Empresa empresa) {
		List<Empresa> retorno = new ArrayList<Empresa>();		
		retorno = this.dao.findByExample(empresa);
		return retorno;
	}

	@Override
	public List<Empresa> listarFiliais(Empresa empresa) {
		List<Empresa> retorno = new ArrayList<Empresa>();
		if ((empresa.getEmpresaId() != null)&&(empresa.getMatriz() != null)){
			retorno = this.dao.getFiliais(empresa);
		}
		return retorno;
	}

	@Override
	public void excluirEmpresa(Empresa empresa) {
		if (empresa.getEmpresaId() != null){
			this.dao.delete(empresa);
		}
	}

	@Override
	public void salvarEmpresa(Empresa empresa) {
		this.dao.add(empresa);		
	}

	@Override
	public Empresa buscarEmpresaMaster() {
		List<Empresa> retornoLst = new ArrayList<Empresa>();		
		Empresa exemplo = new Empresa();
		exemplo.setAtivo("A");		
		retornoLst = this.dao.findByExample(exemplo);
		
		Empresa retorno = new Empresa();
		for (Empresa empresa : retornoLst) {
			if (empresa.getMatriz() == null){
				retorno = empresa;
				break;
			}
		}
		
		return retorno;
	}


}