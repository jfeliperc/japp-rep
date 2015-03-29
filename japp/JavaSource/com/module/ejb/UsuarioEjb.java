package com.module.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.module.ejb.contract.IUsuarioEjb;
import com.module.jpa.dao.Dao;
import com.module.jpa.model.Usuario;

@Stateless
public class UsuarioEjb implements IUsuarioEjb {

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) {
		
		Dao<Usuario> dao = new Dao<Usuario>();
		if (usuario.getId() == null){
			dao.add(usuario);
		}else{
			dao.update(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarUsuarios(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validarLogin(String user, String pass, Integer empresaId) {
		// TODO Auto-generated method stub
		return false;
	}

}
