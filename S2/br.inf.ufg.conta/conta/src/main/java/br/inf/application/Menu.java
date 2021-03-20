package br.inf.application;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import javax.swing.Action;

import br.inf.domain.Categoria;
import br.inf.domain.Conta;
import br.inf.domain.Pessoa;
import br.inf.domain.PessoaFisica;
import br.inf.domain.PessoaJuridica;

public class Menu {

	public void menuPrincipal(Scanner sc) {
		Integer escolha = 1;
		Conta conta;
		int vi;
		do {
			this.showMenuPrincipal();
			try {
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					System.out.println("Informe o número do cliente");
					vi = sc.nextInt();
					if ( vi <= Main.clientes.size()  && vi >= 0 ){
						cadastrarConta(sc, Main.clientes.get(vi) );
					}else{
						
						this.cadatrarCliente(sc);
						
						cadastrarConta(
							sc,
							Main.clientes.get(
								Main.clientes.size() - 1
							)  
						);

					}
					

					break;

				case 2:
					conta = this.buscarConta(sc);
					this.menuConta(sc, conta);
					break;

				case 3:
					this.cadatrarCliente(sc);
					break;

				case 4:
					relatorios(sc);
					break;

				case 5:
					System.out.println("5 - Sair");
					break;

				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 5;
			}
		} while (escolha != 5);

	}

	private void cadatrarCliente(Scanner sc) {

		System.out.println("--- Novo Cliente-----");
		System.out.println("Selecione o tipo de Pessoa");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurúdica");
		
		Integer tipo = sc.nextInt();
		
		
		System.out.println("--- Informe o ID -----");
		Integer id = sc.nextInt();

		System.out.println("--- Informe o Nome -----");
		String nome = sc.nextLine();
		
		System.out.println("--- Informe o Endereço -----");
		String endereco = sc.nextLine();
		
		if(tipo == 1) {
			System.out.println("--- Informe o CPF -----");
			String cpf = sc.nextLine();
			
			System.out.println("--- Informe a Data de Nascimento -----");
			String[] dtAux = sc.next().trim().split("/");
			
			Date dtNascimento = Date.from(Instant.parse(dtAux[2]+"-"+dtAux[2]+"-"+dtAux[0]+"T00:00:00Z"));

			
					
			System.out.println("--- Informe o Genero (M/F) -----");
			String genero = sc.next();
			
			Main.clientes.add(new PessoaFisica(id, nome, endereco, id, dtNascimento, genero));
			
		}else {
			System.out.println("--- Informe o Nome -----");
			String cnpj = sc.nextLine();
			
			System.out.println("--- Informe o Endereço -----");
			String atividade = sc.nextLine();
			
			Main.clientes.add(new PessoaJuridica(id, nome, endereco, id, atividade));
		}

	}

	private void menuConta(Scanner sc, Conta conta) {
		
		Integer escolha = 1;
		do {
			this.showMenuConta(conta);
			try {
				escolha = sc.nextInt();
				Double vr;
				Integer vi;
				switch (escolha) {
				case 1: 
				System.out.println("Escolha uma nova categoria");
					conta.setCategoria(
						SelecionarCategoria(sc)
					);
					break;
				case 2: 
					System.out.println("Informe o Valor do Depósito");
					vr = sc.nextDouble();
					try {
						conta.depositar(vr);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3: 
					System.out.println("Informe o Valor para Saque");
					vr = sc.nextDouble();
					try {
						conta.sacar(vr);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4: 
					Conta dest = this.buscarConta(sc);
					System.out.println("Informe o Valor para Transferência");
					vr = sc.nextDouble();
					try {
						conta.transferir(vr, dest);	
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("-------------------------");
					System.out.println("--- SALDO: R$ "+conta.getSaldo());
					System.out.println("-------------------------");
					
					break;
				}

			}  catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 6;
			}
		}while (escolha != 6);
	}

	private void showMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 - Abrir Nova Conta");
		System.out.println("2 - Selecionar Conta");
		System.out.println("3 - Cadastrar Cliente");
		System.out.println("4 - Relatórios");
		System.out.println("5 - Sair");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta conta) {
		System.out.println("-------------------------");
		System.out.println("Cliente: " + conta.getCliente().getNome());
		System.out.println("Nr Conta: " + conta.getNrConta());
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 - Alterar Conta");
		System.out.println("2 - Deposito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Saldo");
		System.out.println("6 - Sair");
		System.out.println("-------------------------");
	}

	public Conta buscarConta(Scanner sc) {

		Conta conta = null;
		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o número da Conta---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Conta c : Main.contas) {

				if (c.getNrConta().equals(escolha)) {
					conta = c;
					break;
				}
			}
			if (conta == null) {
				System.out.println("------------------------------");
				System.out.println("-----Conta Não Encontrada-----");
				System.out.println("------------------------------");				
			}

		} while (conta == null);

		return conta;
	}

	public void cadastrarConta(Scanner sc, Pessoa titular){
		Conta novaConta = new Conta(); 
		int nrConta = Main.contas.size() + 1;
		String nomeDoTitular = titular.getNome();

		System.out.printf("O Número da conta é: %d.\n", nrConta);
		novaConta.setNrConta(
			nrConta
		);

		System.out.printf("O nome do Titular da Conta é: %s.\n", nomeDoTitular);
		novaConta.setCliente(
			titular
		);
    
		novaConta.setCategoria(
			SelecionarCategoria(sc)
		);

	}

	public Categoria SelecionarCategoria( Scanner sc){
		
		final String label = "%d - %s\n";

		Categoria categoria;
		int escolha;
		
		System.out.printf( 
			label, Categoria.SIMPLES.ordinal(), Categoria.SIMPLES.name()
		);

		System.out.printf( 
			label, Categoria.EXECUTIVA.ordinal(), Categoria.EXECUTIVA.name()
		);
		System.out.printf( 
			label, Categoria.PREMIUN.ordinal(), Categoria.PREMIUN.name()
		);
		System.out.printf( 
			label, Categoria.PERSONALITE.ordinal(), Categoria.PERSONALITE.name()
		);
		
		escolha = sc.nextInt();

		switch (escolha) {
			case 1:
					categoria =  Categoria.EXECUTIVA;
				break;
			
			case 2:
					categoria =  Categoria.PERSONALITE;
				break;

			case 3:
					categoria =  Categoria.PREMIUN;
				break;

			case 4:
					categoria =  Categoria.SIMPLES;
				break;
		
			default:
					categoria =  Categoria.SIMPLES;
				break;
		}

		return categoria;

	}

	public void relatorios(Scanner sc){
		Integer escolha = 1;

		do {

			System.out.println("-------------------------");
			System.out.println("---Selecione Uma Opção---");
			System.out.println("-------------------------");
			System.out.println("1 - Saldo das Contas");
			System.out.println("2 - Total das Contas");
			System.out.println("3 - Sair");
			System.out.println("-------------------------");

			try {
				escolha = sc.nextInt();
				switch (escolha) {
				case 1: 
					SaldoContas();
					break;
				case 2: 
					SaldoTotalContas();					
					break;
				}

			}  catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 3;
			}
		}while (escolha != 3);

	}

	public void SaldoContas(){
		final String lindaDeSaldo = "Nome : %s | Saldo : %f\n";
		
		for(int i = 0; i < Main.contas.size(); ++i){
			System.out.printf(
				lindaDeSaldo,
				Main.contas.get(i).getCliente().getNome(),
				Main.contas.get(i).getSaldo()
			);
		}

	}

	public void SaldoTotalContas(){
		final String lindaDeSaldo = "Saldo total das contas: %f\n";
		Double total = 0.0;
		
		for(int i = 0; i < Main.contas.size(); ++i){
			total += Main.contas.get(i).getSaldo();
		}

		System.out.printf(
			lindaDeSaldo,
			total
		);

	}

}



