package br.com.labexame.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Exame;
import br.com.labexame.domain.Status;
import br.com.labexame.repository.exame.ExameRepositoryQuery;

/**
 * @author aishac
 *
 */
@Repository
public interface ExameRepository extends JpaRepository<Exame, Long>, ExameRepositoryQuery {

	/**
	 * Busca um exame pelo nome.
	 *
	 * @param nome
	 * @return Optional<Exame>
	 */
	Optional<Exame> findByNome(String nome);

	/**
	 * Inativando logicamente um exame.
	 *
	 * @param status
	 * @param id
	 */
	@Transactional
    @Modifying
    @Query("UPDATE Exame SET status = ?1 where id = ?2")
    void inativar(Status status, Long id);

}
