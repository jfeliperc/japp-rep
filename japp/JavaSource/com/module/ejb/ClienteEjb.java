package com.module.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IClienteEjb;
import com.module.enums.TipoPessoa;
import com.module.jpa.dao.Dao;
import com.module.jpa.model.AgenteExterno;

@Stateless
public class ClienteEjb implements IClienteEjb {

	@Override
	public AgenteExterno cadastrarCliente(AgenteExterno cliente) {
		Dao<AgenteExterno> daoAgenteExterno = new Dao<AgenteExterno>();
		
		cliente.setDataalteracao(new Date());
		cliente.setAtivo("A");		
		if (!StringUtils.isBlank(cliente.getCpf())){
			cliente.setTipoPessoa(TipoPessoa.PF.getValor());
		}else{
			cliente.setTipoPessoa(TipoPessoa.PJ.getValor());
		}
		
		if (cliente.getId() == null){
			cliente.setDatainclusao(new Date());
			
			daoAgenteExterno.add(cliente);
		}else{
			daoAgenteExterno.update(cliente);
		}
		return cliente;
	}

	@Override
	public AgenteExterno buscarCliente(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgenteExterno> listarClientes(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirCliente(AgenteExterno cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int buscarQtdCliente() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
