package br.inf.ufg.contabil.model.pessoa;

import java.util.List;

import br.inf.ufg.contabil.model.conta.Conta;

public class Juridica extends Pessoa {
	
	private String cnpj;
	private String atividade;
	
	public Juridica() {
		super();
	}
	
	public Juridica(int id, String nome, String endereco, List<Conta> contas) {
		super(id, nome, endereco, contas);
	}

	public Juridica(String cnpj, String atividade) {
		super();
		this.cnpj = cnpj;
		this.atividade = atividade;
	}
	
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
