package com.module.faces;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.module.ejb.contract.IEmpresaEjb;
import com.module.ejb.contract.IPessoaEjb;
import com.module.faces.geral.EstrMenu;
import com.module.faces.geral.Menu;
import com.module.jpa.model.Empresa;
import com.module.jpa.model.Pessoa;


@ManagedBean
@SessionScoped
public class LoginMb extends BaseMb{

	@EJB
	private IPessoaEjb pessoaEjb;

	@EJB
	private IEmpresaEjb empresaEjb;
	
	private String login;
	private String pass;
	private Empresa empresa;
//	private List<Empresa> empresas;
	private Empresa filial;
	private List<Empresa> filiais;
	
	private List<EstrMenu> menu;
	
	public LoginMb() {
		super();
	}

	@PostConstruct
	private void limpar() {
		if (empresaEjb != null){
			this.empresa = empresaEjb.buscarEmpresaMaster();
			this.filiais = empresaEjb.listarFiliais(empresa);
			this.filial = new Empresa();
		}
	}

	public String executarLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.setAttribute("AUTHENTICATED", "True");
		String ret = "inicio";
        try {
			if (pessoaEjb.validarLogin(login, pass, empresa)){
				
				Pessoa pessoa = new Pessoa();
				pessoa.setLogin(login);
				pessoa.setPass(pass);
				pessoa = pessoaEjb.buscarPorLogin(login);
				
				session.setAttribute("userLog", pessoa);
				
				ret = "inicio";
			}else{
				setMsg("Login e/ou senha inválido(s).");
				ret = "login";
			}
		} catch (NoSuchAlgorithmException e) {
			addMsgError("Erro ao validar dados - "+e.getMessage());
			//e.printStackTrace();
		}
        return ret;
        
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
		Menu serv = new Menu("servico","Serviços","Cadastro de serviços");
		itemGeral.getSubmenus().add(empresa);
		itemGeral.getSubmenus().add(pessoas);
		itemGeral.getSubmenus().add(fornec);
		itemGeral.getSubmenus().add(cli);
		itemGeral.getSubmenus().add(serv);
		
		EstrMenu itemProdutos = new EstrMenu("Produtos");
		Menu produto = new Menu("produto","Produto","Cadastro de produto");
		Menu estoque = new Menu("estoque","Estoque","Controle de estoque");
		Menu entProd = new Menu("entradaEst","Entrada","Entrada de produtos");
		Menu saidaProd = new Menu("saidaEst","Saída","Saída de produtos");
		Menu pedido = new Menu("pedido","Pedidos","Pedidos de produtos");
		itemProdutos.getSubmenus().add(produto);
		itemProdutos.getSubmenus().add(estoque);
		itemProdutos.getSubmenus().add(entProd);
		itemProdutos.getSubmenus().add(saidaProd);
		itemProdutos.getSubmenus().add(pedido);
		
		EstrMenu itemCozinha = new EstrMenu("Cozinha");
		Menu receitas = new Menu("receita","Receita","Cadastro de receitas");
		Menu cardapio = new Menu("cadCardapio","Cardápio","Cadastro de cardápio");
		itemCozinha.getSubmenus().add(receitas);
		itemCozinha.getSubmenus().add(cardapio);
		
		EstrMenu itemFinanceiro = new EstrMenu("Financeiro");
		Menu contas = new Menu("nfentrada","Contas","Entrada de notas fiscais");
		Menu receitasFin = new Menu("nfentrada","Receitas","Entrada de notas fiscais");
		Menu despesas = new Menu("nfentrada","Despesas","Entrada de notas fiscais");
		Menu notasfiscais = new Menu("nfentrada","Notas Fiscais","Entrada de notas fiscais");
		itemFinanceiro.getSubmenus().add(contas);
		itemFinanceiro.getSubmenus().add(receitasFin);
		itemFinanceiro.getSubmenus().add(despesas);
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

//	public List<Empresa> getEmpresas() {
//		return empresas;
//	}
//
//	public void setEmpresas(List<Empresa> empresas) {
//		this.empresas = empresas;
//	}

	public Empresa getFilial() {
		return filial;
	}

	public void setFilial(Empresa filial) {
		this.filial = filial;
	}

	public List<Empresa> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Empresa> filiais) {
		this.filiais = filiais;
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
