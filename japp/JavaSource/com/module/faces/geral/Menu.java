package com.module.faces.geral;

public class Menu {

    private String id;
    private String label;
    private String descricao;
    	
	public Menu(String id, String label, String descricao) {
		super();
		this.id = id;
		this.label = label;
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
}
