package br.com.labexame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Prestador;
import br.com.labexame.domain.id.PrestadorPK;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, PrestadorPK> {

}
