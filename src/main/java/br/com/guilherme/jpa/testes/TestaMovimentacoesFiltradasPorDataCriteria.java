package br.com.guilherme.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.guilherme.jpa.modelo.Movimentacao;
import br.com.guilherme.jpa.modelo.dao.MovimentacaoDao;

public class TestaMovimentacoesFiltradasPorDataCriteria {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
		List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDao.getMovimentacoesFiltradasPorData(12, null,
				2017);
		for (Movimentacao movimentacao : movimentacoesFiltradasPorData) {
			System.out.println("Descrição -> " + movimentacao.getDescricao());
			System.out.println("Valor -> " + movimentacao.getValor());
			System.out.println("----------------------------------------");
		}

	}
}
