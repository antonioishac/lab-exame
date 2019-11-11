package br.com.labexame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Laboratorio;

/**
 * @author aishac
 *
 */
@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

	/**
	 * Busca um determinado laborat\u00f3rio pelo nome.
	 *
	 * @param nome
	 * @return Optional<Laboratorio>
	 */
	Optional<Laboratorio> findByNome(String nome);

}
