package br.inf.ufg.contabil.controller.conta;

import br.inf.ufg.contabil.controller.Util;
import br.inf.ufg.contabil.model.conta.Conta;
import br.inf.ufg.contabil.model.conta.Especial;
import br.inf.ufg.contabil.model.conta.Poupanca;

public class GestaoDeLancamento {
	
	public static boolean efetuarSaqueEm( Conta conta, Double valor ) {
		
		if( conta instanceof Especial ) {
			return saqueDoTipoEspecial((Especial) conta, valor);
		}
		else if(conta instanceof Poupanca ) {
			return saqueDoTipoPoupanca((Poupanca) conta, valor);
		}
				
		return false;
		
	}
	
	public static boolean efetuarDeposito(Conta conta, Double valor) {
		
		if( conta instanceof Especial ) {
			return depositoDoTipoEspecial((Especial) conta, valor);
		}
		else if(conta instanceof Poupanca ) {
			return depositoDoTipoPoupanca((Poupanca) conta, valor);
		}
		
		return false;
	}
	
	public static boolean efetuarTransferencia(Conta origem, Conta destino, Double valor) {
		
		if( efetuarSaqueEm(origem, valor ) ) {
			efetuarDeposito(destino, valor);
		}
		
		return false;
	}
	
	private static boolean depositoDoTipoPoupanca(Poupanca conta, Double valor) {
		
		Double valorAplicadaATaxa;
		Double saldoAplicadoValorTaxado;
		
		if( conta.temSaldo() ) {
			
			valorAplicadaATaxa = valor - conta.getTaxaDeCorrecao(); 			
			saldoAplicadoValorTaxado = conta.getSaldo()  + valorAplicadaATaxa;
			
			conta.setSaldo(saldoAplicadoValorTaxado);
			
		}
		
		return false;
	}

	private static boolean depositoDoTipoEspecial(Especial conta, Double valor) {
		
		Double saldoAcredidoDodeposito;
		
		if( valor > 0 ){
			saldoAcredidoDodeposito = conta.getSaldo() + valor;
			
			conta.setSaldo(saldoAcredidoDodeposito);
			return true;
		}
		return false;
	}

	private static boolean saqueDoTipoEspecial(Especial conta, Double valor) {
		
		Double saldoAplicadoValor;
		
		if(conta.temSaldo() ) {
			saldoAplicadoValor= conta.getSaldo() - valor;
			if( conta.getSaldo() > 0) {
				conta.setSaldo(saldoAplicadoValor);
				return true;
			}
		}
		else {
			
			saldoAplicadoValor =  (conta.getSaldo() - valor) ;
			if( conta.getLimite() >= saldoAplicadoValor) {
				conta.setSaldo(saldoAplicadoValor);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	private static boolean saqueDoTipoPoupanca(Poupanca conta, Double valor) {
		Double saldoAplicadoValorETaxa;
		Double saldoTaxado;

		/*
		 * se a data atual(mes e dia)
		 * for maior ou igual a data de criação
		 * então somamos a taxa de correção.
		 */



		if( conta.getDiaAniversario() >= Util.getDiaAtual()  ){
			saldoTaxado = conta.getSaldo() + conta.getTaxaDeCorrecao();
		}else{
			saldoTaxado = conta.getSaldo();
		}
		
		if( conta.temSaldo() ) {
			if( conta.getSaldo() > 0.0) {
				saldoAplicadoValorETaxa= (saldoTaxado  - valor );
				conta.setSaldo(saldoAplicadoValorETaxa);
				return true;
			}
		}

		return false;
		
	}
	

}
