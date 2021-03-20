package br.inf.ufg.contabil.model.conta;

import br.inf.ufg.contabil.model.pessoa.Pessoa;

public class Poupanca extends Conta {
	private Double taxaDeCorrecao;

	public Poupanca(Double taxaDeCorrecao) {
		super();
		this.taxaDeCorrecao = taxaDeCorrecao;
	}

	public Poupanca() {
		super();
	}

	public Poupanca(Pessoa cliente, Integer numero, Double saldo) {
		super(cliente, numero, saldo);
	}

	public Double getTaxaDeCorrecao() {
		return taxaDeCorrecao;
	}

	public void setTaxaDeCorrecao(Double taxaDeCorrecao) {
		this.taxaDeCorrecao = taxaDeCorrecao;
	}
	
	
}
