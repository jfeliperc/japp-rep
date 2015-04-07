package com.module.faces;

import java.util.List;

import com.module.enums.Menu;

public class EstrMenu {

	private String menu;
	private List<Menu> submenus;
	
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
