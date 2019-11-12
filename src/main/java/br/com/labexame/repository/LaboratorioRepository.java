package br.com.labexame.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Laboratorio;
import br.com.labexame.domain.Status;
import br.com.labexame.repository.laboratorio.LaboratorioRepositoryQuery;

/**
 * @author aishac
 *
 */
@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long>, LaboratorioRepositoryQuery {

	/**
	 * Busca um determinado laborat\u00f3rio pelo nome.
	 *
	 * @param nome
	 * @return Optional<Laboratorio>
	 */
	Optional<Laboratorio> findByNome(String nome);

	/**
	 * Inativa\u00e7\u00e3o l\u00f3gica de um laborat\u00f3rio.
	 *
	 * @param status
	 * @param id
	 */
	@Transactional
    @Modifying
    @Query("UPDATE Laboratorio SET status = ?1 where id = ?2")
    void inativar(Status status, Long id);

}
