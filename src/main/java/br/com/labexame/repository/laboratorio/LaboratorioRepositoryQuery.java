package br.com.labexame.repository.laboratorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.labexame.domain.Laboratorio;
import br.com.labexame.service.filter.LaboratorioFilter;

public interface LaboratorioRepositoryQuery {

	public Page<Laboratorio> filtrar(LaboratorioFilter laboratorioFilter, Pageable pageable);

}
