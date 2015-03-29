package com.module.ejb.contract;

import java.util.List;

import com.module.jpa.model.Usuario;

public interface IUsuarioEjb {

	public Usuario cadastrarUsuario(Usuario usuario);
	
	public Usuario buscarUsuario(Usuario usuario);
	
	public List<Usuario> listarUsuarios(Usuario usuario);
	
	public void excluirUsuario(Usuario usuario);
	
	public boolean validarLogin(String user, String pass, Integer empresaId);
}
