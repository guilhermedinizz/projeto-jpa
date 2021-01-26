package br.com.guilherme.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.guilherme.jpa.modelo.Movimentacao;

public class TestaSomasDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		System.out.println("Total: " + typedQuery.getSingleResult());
	}
}
