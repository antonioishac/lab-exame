package br.com.labexame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.labexame.domain.Medico;
import br.com.labexame.repository.MedicoRepository;
import br.com.labexame.service.exception.MedicoExisteException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public Medico salvar(Medico medico) {
		Optional<Medico> existeMedico = repository.findByNomeAndEspecialidade(medico.getNome(), medico.getEspecialidade());

		if (existeMedico.isPresent()) {
			throw new MedicoExisteException();
		}

		return repository.save(medico);
	}

	public Medico buscarPeloCodigo(Long codigo) {
		Optional<Medico> medico = repository.findById(codigo);

		if (!medico.isPresent()) {
			throw new MedicoExisteException();
		}

		return medico.get();
	}

}
