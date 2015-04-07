package com.module.enums;

public enum Menu {

	PF("PF", "Pessoa Física", "PF"),
    PJ("PJ", "Pessoa Jurídica", "PJ");

    private String nome;
    private String descricao;
    private String valor;
    
    Menu(String nome, String descricao, String valor){
        this.nome = nome;
        this.valor = valor;
    }

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}
}
