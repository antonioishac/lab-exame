package br.com.labexame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Exame;

/**
 * @author aishac
 *
 */
@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

}
