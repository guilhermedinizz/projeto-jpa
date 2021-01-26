package br.com.guilherme.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guilherme.jpa.modelo.Conta;
import br.com.guilherme.jpa.modelo.dao.MovimentacaoDao;

public class TestaRelatorioDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		List<Conta> contas = new MovimentacaoDao(em).getRelatorioDasMovimentacoes();
		
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Numero: " + conta.getNumero());
			System.out.println("Movimentações: " + conta.getMovimentacoes().size());
			System.out.println("================================");
		}
	}
}
