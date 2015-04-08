package com.module.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.module.ejb.contract.IPessoaEjb;
import com.module.faces.geral.EstrMenu;
import com.module.faces.geral.Menu;
import com.module.jpa.model.Pessoa;


@ManagedBean
@SessionScoped
public class LoginMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;
	
	private String login;
	private String pass;
	private Integer empresaId;
	
	private List<EstrMenu> menu;
	
	public String executarLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", "True");
		
        if (pessoaEjb.validarLogin(login, pass, empresaId)){
        	
        	Pessoa pessoa = new Pessoa();
        	pessoa.setLogin(login);
        	pessoa.setPass(pass);
        	pessoa = pessoaEjb.buscarPorLogin(login);
        	
        	session.setAttribute("userLog", pessoa);
        	
        	return "inicio";
        }else{
        	setMsg("Login e/ou senha invÃ¡lido(s).");
    		return "login";
        }
        
	}
	
	public String executarLogout(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", null);
		return "login";
	}
	
	public void montarMenu(){
		this.menu = new ArrayList<EstrMenu>();
		
		EstrMenu itemGeral = new EstrMenu("Geral");
		Menu empresa = new Menu("empresa","Empresa","Cadastro da empresa");
		Menu pessoas = new Menu("pessoa","Pessoas","Cadastro de pessoas/usuários");
		Menu fornec = new Menu("fornecedor","Fornecedores","Cadastro de fornecedores");
		Menu cli = new Menu("cliente","Clientes","Cadastro de clientes");
		itemGeral.getSubmenus().add(empresa);
		itemGeral.getSubmenus().add(pessoas);
		itemGeral.getSubmenus().add(fornec);
		itemGeral.getSubmenus().add(cli);
		
		EstrMenu itemProdutos = new EstrMenu("Produtos");
		Menu produto = new Menu("produto","Produto","Cadastro de produto");
		Menu estoque = new Menu("m20002","Estoque","Controle de estoque");
		Menu entProd = new Menu("m20003","Entrada","Entrada de produtos");
		Menu saidaProd = new Menu("m20004","Saída","Saída de produtos");
		Menu pedido = new Menu("pedido","Pedidos","Pedidos de produtos");
		itemProdutos.getSubmenus().add(produto);
		itemProdutos.getSubmenus().add(estoque);
		itemProdutos.getSubmenus().add(entProd);
		itemProdutos.getSubmenus().add(saidaProd);
		itemProdutos.getSubmenus().add(pedido);
		
		EstrMenu itemCozinha = new EstrMenu("Cozinha");
		Menu receitas = new Menu("m30001","Receitas","Cadastro de produto");
		Menu cardapio = new Menu("cadCardapio","Cardápio","Cadastro de cardápio");
		itemCozinha.getSubmenus().add(receitas);
		itemCozinha.getSubmenus().add(cardapio);
		
		EstrMenu itemFinanceiro = new EstrMenu("Financeiro");
		Menu notasfiscais = new Menu("m40001","Notas Fiscais","Entrada de notas fiscais");
		itemFinanceiro.getSubmenus().add(notasfiscais);
		
		this.menu.add(itemGeral);
		this.menu.add(itemProdutos);
		this.menu.add(itemCozinha);
		this.menu.add(itemFinanceiro);
	}
	
	public String navegarMenu(String opcao){
		return opcao;
	}
	
	public String encaminharSolicitaCadastro(){
		return "c_pessoa";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<EstrMenu> getMenu() {
		
		if ((menu == null)||(menu.isEmpty())){
			montarMenu();
		}
		
		return menu;
	}

	public void setMenu(List<EstrMenu> menu) {
		this.menu = menu;
	}
	
}
