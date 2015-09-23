package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Empresa;

public interface IEmpresaEjb {

	public Empresa cadastrarEmpresa(Empresa empresa);
	
	public Empresa buscarEmpresa(Empresa empresa);
	
	public List<Empresa> listarEmpresas(Empresa empresa);
	
	public List<Empresa> listarFiliais(Empresa empresa);
	
	public void excluirEmpresa(Empresa empresa);

	public void salvarEmpresa(Empresa empresa);

	public Empresa buscarEmpresaMaster();

	public List<Empresa> listarAllEmpresas();
	
}
