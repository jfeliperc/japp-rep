package com.module.enums;

public enum TipoUsuario {
	
	USER_PDN("USER-PDN", "Usuário pendente", "UP"),
    ADM_GER("ADM-GER", "Administrador Geral", "AG"),
    ADM_EMP("ADM-EMP", "Administrador empresa", "AE"),
    ADM_FIL("ADM-FIL", "Administrador filial", "AF"),
	USER_EMP("USER-EMP", "Usuário empresa", "UE"),
	USER_FIL("USER-FIL", "Usuário filial", "UF"),
	USER_TMP("USER-TMP", "Usuário temporário", "UT");

    private String nome;
    private String descricao;
    private String valor;
    
    TipoUsuario(String nome, String descricao, String valor){
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
