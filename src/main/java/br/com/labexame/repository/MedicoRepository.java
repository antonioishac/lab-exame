package br.com.labexame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.labexame.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

	/**
	 * Verifica se j\u00e1 existe um m\u00e9dico com a especialidade cadastrada.
	 *
	 * @param nome
	 * @param especialidade
	 * @return Optional<Medico>
	 */
	Optional<Medico> findByNomeAndEspecialidade(String nome, String especialidade);

}
