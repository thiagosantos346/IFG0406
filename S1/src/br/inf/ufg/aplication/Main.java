package br.inf.ufg.aplication;

import br.inf.ufg.contabil.*;
import br.inf.ufg.contabil.model.pessoa.Fisica;

public class Main {

	public static void main(String[] args) {
		
		Fisica pessoaFisica = new Fisica();

		pessoaFisica.setId(1);
		pessoaFisica.setNome("Thiago Silva");
		pessoaFisica.setCpf("06638737199");

	}

}
