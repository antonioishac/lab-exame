package br.com.labexame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.labexame.domain.Operadora;

@Repository
public interface OperadoraRepository extends JpaRepository<Operadora, Long> {

}
