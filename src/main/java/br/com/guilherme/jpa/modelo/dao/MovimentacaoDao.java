package br.com.guilherme.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.guilherme.jpa.modelo.Conta;
import br.com.guilherme.jpa.modelo.MediaComData;
import br.com.guilherme.jpa.modelo.Movimentacao;

public class MovimentacaoDao {
	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);

		Root<Movimentacao> root = query.from(Movimentacao.class);

		List<Predicate> predicates = new ArrayList<>();

		if (dia != null) {
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			predicates.add(predicate);
		}
		if (mes != null) {
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			predicates.add(predicate);
		}
		if (ano != null) {
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			predicates.add(predicate);
		}

		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

		return typedQuery.getResultList();
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "select sum(m.valor) from Movimentacao m";

		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();

		return somaDasMovimentacoes;
	}

	public List<Conta> getRelatorioDasMovimentacoes() {
		String jpql = "select c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

		return query.getResultList();
	}
}
