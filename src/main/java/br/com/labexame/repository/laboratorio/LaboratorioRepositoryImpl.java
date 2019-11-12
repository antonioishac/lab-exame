package br.com.labexame.repository.laboratorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.labexame.domain.Laboratorio;
import br.com.labexame.domain.Laboratorio_;
import br.com.labexame.service.filter.LaboratorioFilter;

public class LaboratorioRepositoryImpl implements LaboratorioRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Laboratorio> filtrar(LaboratorioFilter laboratorioFilter, Pageable pageable) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Laboratorio> criteria = builder.createQuery(Laboratorio.class);
		Root<Laboratorio> root = criteria.from(Laboratorio.class);

		Predicate[] predicates = criarRestricoes(laboratorioFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Laboratorio> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(laboratorioFilter));
	}

	private Predicate[] criarRestricoes(LaboratorioFilter laboratorioFilter, CriteriaBuilder builder, Root<Laboratorio> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(laboratorioFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Laboratorio_.nome)), "%" + laboratorioFilter.getNome() + "%"));
		}

		if (laboratorioFilter.getStatus() != null) {
			predicates.add(builder.equal(root.get(Laboratorio_.status), laboratorioFilter.getStatus()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Laboratorio> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
	}

	private Long total(LaboratorioFilter laboratorioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Laboratorio> root = criteria.from(Laboratorio.class);

		Predicate[] predicates = criarRestricoes(laboratorioFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
