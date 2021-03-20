package br.inf.ufg.contabil.model.conta;

import br.inf.ufg.contabil.model.pessoa.Pessoa;
import java.time.LocalDateTime;

public class Conta {
	
	private Double saldo;
	private Integer numero;
	private LocalDateTime dataDeCriacao;
	private Pessoa cliente;
	
	public Conta() {
		super();
		setDataDeCriacao(LocalDateTime.now());
	}
	
	public Conta(Pessoa cliente, Integer numero, Double saldo) {
		super();
		this.cliente = cliente;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public boolean temSaldo() {
		return ( saldo > 0 );
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	private void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public int getDiaAniversario(){
		return this.dataDeCriacao.getDayOfMonth();
	}

}
