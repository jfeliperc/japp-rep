package com.module.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import com.module.ejb.contract.IClienteEjb;
import com.module.enums.TipoPessoa;
import com.module.faces.geral.UtilsJapp;
import com.module.jpa.dao.ClienteDao;
import com.module.jpa.dao.ClienteServicoDao;
import com.module.jpa.model.Cliente;
import com.module.jpa.model.ClienteServico;
import com.module.jpa.model.Servico;

@Stateless
public class ClienteEjb implements IClienteEjb {

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		ClienteDao daoCliente = new ClienteDao();
		
		cliente.setDataalteracao(new Date());	
		if (StringUtils.isBlank(cliente.getTipoPessoa())){
			if (!StringUtils.isBlank(cliente.getCpf())){
				cliente.setTipoPessoa(TipoPessoa.PF.getValor());
			}else{
				cliente.setTipoPessoa(TipoPessoa.PJ.getValor());
			}
		}
		
		

		if (UtilsJapp.isNullOrZero(cliente.getId())){
			cliente.setId(null);
			cliente.setDatainclusao(new Date());
			cliente.setTipo("C");

			if ((cliente.getEmpresa() == null)||(UtilsJapp.isNullOrZero(cliente.getEmpresa().getId()))){
				cliente.setEmpresa(null);
			}
						
			daoCliente.add(cliente);
		}else{
			daoCliente.update(cliente);
		}
		return cliente;
	}

	@Override
	public Cliente buscarCliente(Cliente cliente) {
		ClienteDao daoCliente = new ClienteDao();
		return daoCliente.getById(cliente.getId());
	}

	@Override
	public List<Cliente> listarClientes(Cliente cliente) {
		ClienteDao daoCliente = new ClienteDao();
		cliente.setTipo("C");
		List<Cliente> res = daoCliente.findByExample(cliente);
		return res;
	}

	@Override
	public void excluirCliente(Cliente cliente) {
		if (cliente.getId() != null){
			ClienteDao daoCliente = new ClienteDao();
			cliente.setAtivo("0");
			daoCliente.update(cliente);
		}
		
	}

	@Override
	public int buscarQtdCliente() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente buscarServicoCliente(Cliente cliente) {
		ClienteServicoDao dao = new ClienteServicoDao();
		List<ClienteServico> servicos = dao.findByCliente(cliente);
		cliente.setServicos(new ArrayList<Servico>());
		
		for (ClienteServico clienteServico : servicos) {
			cliente.getServicos().add(clienteServico.getServico());
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> buscarAllClientes() {
		ClienteDao daoCliente = new ClienteDao();
		return daoCliente.buscarTodosClientes();
	}

	

}
