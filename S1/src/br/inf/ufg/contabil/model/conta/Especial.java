package br.inf.ufg.contabil.model.conta;

import br.inf.ufg.contabil.model.pessoa.Pessoa;

public class Especial extends Conta {
	private Double limite;
	
	public Especial() {
		super();
	}

	public Especial(Pessoa cliente, Integer numero, Double saldo) {
		super(cliente, numero, saldo);
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Especial(Double limite) {
		super();
		this.limite = limite;
	}
	
}
