package com.module.faces.geral;

import java.util.ArrayList;
import java.util.List;

public class EstrMenu {

	private String menu;
	private List<Menu> submenus;
	
	public EstrMenu(String opcao) {
		setMenu(opcao);
		setSubmenus(new ArrayList<Menu>());
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public List<Menu> getSubmenus() {
		return submenus;
	}
	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}
	
}
