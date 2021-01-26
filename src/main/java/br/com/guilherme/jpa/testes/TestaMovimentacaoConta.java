package br.com.guilherme.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guilherme.jpa.modelo.Conta;
import br.com.guilherme.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		 Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
		 Conta conta = movimentacao.getConta();
		 
		 int quantidade = conta.getMovimentacoes().size();
		 
		 System.out.println("Quantidade de movimentações: " + quantidade);
		 System.out.println("Titular da conta: " + conta.getTitular());
	}
}
