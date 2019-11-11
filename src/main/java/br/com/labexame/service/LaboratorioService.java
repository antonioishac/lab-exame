package br.com.labexame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.labexame.domain.Laboratorio;
import br.com.labexame.domain.Status;
import br.com.labexame.repository.LaboratorioRepository;
import br.com.labexame.service.exception.LaboratorioExisteException;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	/**
	 * Serviço para realizar o cadastro de um laboratório.
	 *
	 * @param laboratorio
	 * @return Laboratorio
	 */
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio) {
		Optional<Laboratorio> existeLaboratorio = laboratorioRepository.findByNome(laboratorio.getNome());

		if (existeLaboratorio.isPresent()) {
			throw new LaboratorioExisteException();
		}

		laboratorio.setStatus(Status.ATIVO);

		return laboratorioRepository.save(laboratorio);
	}
}
