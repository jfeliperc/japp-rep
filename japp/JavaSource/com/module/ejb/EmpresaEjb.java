package com.module.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IEmpresaEjb;
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
		
		return null;
	}

	@Override
	public Empresa buscarEmpresa(Empresa empresa) {
		
		return null;
	}

	@Override
	public List<Empresa> listarEmpresas(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> listarFiliais(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvarEmpresa(Empresa empresa) {
		this.dao.add(empresa);		
	}


}