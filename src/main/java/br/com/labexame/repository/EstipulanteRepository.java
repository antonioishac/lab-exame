package br.com.labexame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Estipulante;
import br.com.labexame.domain.Operadora;
import br.com.labexame.domain.id.EstipulantePK;

@Repository
public interface EstipulanteRepository extends JpaRepository<Estipulante, EstipulantePK> {

	//Estipulante findById(Operadora operadora, Long codigoEstipulante);

}
