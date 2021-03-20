package br.inf.domain;

public class ContaPoupanca extends Conta {

	private Double txCorrecao;
	
	public ContaPoupanca(Pessoa cliente, Integer nrConta, Double saldo, Double txCorrecao) {
		super(cliente, nrConta, saldo);
		this.txCorrecao = txCorrecao;
	}

	public Double getTxCorrecao() {
		return txCorrecao;
	}

	public void setTxCorrecao(Double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}

	
	
}
