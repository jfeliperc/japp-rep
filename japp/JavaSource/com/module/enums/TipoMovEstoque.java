package com.module.enums;

public enum TipoMovEstoque {

	SSD("SSD", "Saída sem documentação", "SSD"),
	SNF("SNF", "Saída Nota Fiscal", "SNF"),
	STF("STF", "Saída Transferência Filial", "STF"),
	ETF("ETF", "Entrada Transferência Filial", "ETF"),	
	ESD("ESD", "Entrada sem documentação", "ESD"),	
	ECF("ECF", "Entrada Cupom Fiscal", "ECF"),
	ENF("ENF", "Entrada Nota Fiscal", "ENF");

    private String nome;
    private String descricao;
    private String valor;
    
    TipoMovEstoque(String nome, String descricao, String valor){
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
