package br.inf.ufg.contabil.model.pessoa;

import java.util.List;

import br.inf.ufg.contabil.model.conta.Conta;

public class Pessoa {
	
	private int         id;
	private String      nome;
	private String      endereco;
	private List<Conta> contas;
	
	
	
	public Pessoa() {
		super();
	}

	public Pessoa(int id, String nome, String endereco, List<Conta> contas) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contas = contas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}


	
	
}
