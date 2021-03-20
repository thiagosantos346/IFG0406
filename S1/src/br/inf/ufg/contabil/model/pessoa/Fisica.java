package br.inf.ufg.contabil.model.pessoa;

import java.util.List;
import java.time.LocalDateTime;

import br.inf.ufg.contabil.model.conta.Conta;

public class Fisica extends Pessoa {
	
	private String cpf;
	private String genero;
	private LocalDateTime dataDeNascimento;
	
	public Fisica() {
		super();
	}
	
	public Fisica(int id, String nome, String endereco, List<Conta> contas) {
		super(id, nome, endereco, contas);
	}
	
	public Fisica(String cpf, String genero) {
		super();
		this.cpf = cpf;
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDateTime getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDateTime dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	

}
