package br.com.labexame.repository.exame;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.labexame.domain.Exame;
import br.com.labexame.service.filter.ExameFilter;

public interface ExameRepositoryQuery {

	public Page<Exame> filtrar(ExameFilter exameFilter, Pageable pageable);

}
