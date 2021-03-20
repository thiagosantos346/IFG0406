package br.inf.domain;

import br.inf.application.TransactionException;

public class Conta {

	private Pessoa cliente;
	private Integer nrConta;
	private Categoria categoria;
	protected Double saldo;
	
	public Conta() {
		this.saldo = 0.0;
	}	

	public Conta(Pessoa cliente, Integer nrConta, Double saldo) {
		super();
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}

	public Conta(Pessoa cliente, Integer nrConta, Categoria categoria, Double saldo) {
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.categoria = categoria;
		this.saldo = saldo;
	}
	

	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Integer getNrConta() {
		return nrConta;
	}
	public void setNrConta(Integer nrConta) {
		this.nrConta = nrConta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	protected Boolean temSaldo(Double valor) {
		return (valor <= this.saldo);
	}
	
	private void debitar(Double valor) {
		this.saldo -= valor;
	}
	private void acrescentar(Double valor) {
		this.saldo += valor;
	}
	
	public void sacar(Double valor) throws TransactionException {
		if(this.temSaldo(valor)) {
			this.debitar(valor);
			System.out.println("Saque realizado com sucesso! Novo Saldo: "+this.saldo);
		}else {
			throw new TransactionException("Saldo Insuficiente");
		}
	}
	
	public void depositar(Double valor) throws TransactionException {
		if(valor <= 0 ){
			throw new TransactionException("Valor do depoisto deve ser maior que zero");
		}

		this.acrescentar(valor);
		System.out.println("Dep�sito realizado com sucesso!");
		System.out.println("Novo Saldo: "+this.saldo);
	}
	
	public void transferir(Double valor, Conta destino) throws TransactionException{
		if(this.temSaldo(valor)) {
			this.debitar(valor);
			destino.acrescentar(valor);
			System.out.println("Transfer�ncia com sucesso! Novo Saldo: "+this.saldo);
		}else {
			throw new TransactionException("Saldo Insuficiente");
		}
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
		
}













