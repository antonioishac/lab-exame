package br.com.labexame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.labexame.domain.Estipulante;
import br.com.labexame.domain.Operadora;
import br.com.labexame.domain.id.EstipulantePK;
import br.com.labexame.repository.EstipulanteRepository;
import br.com.labexame.repository.OperadoraRepository;
import br.com.labexame.service.dto.EstipulanteDTO;
import br.com.labexame.service.exception.OperadoraNaoExisteException;
import br.com.labexame.service.mapper.EstipulanteMapper;
import br.com.labexame.service.mapper.OperadoraMapper;

@Service
public class EstipulanteService {

	@Autowired
	private EstipulanteRepository repository;

	@Autowired
	private OperadoraRepository operadoraRepository;

	@Autowired
	private EstipulanteMapper estipulanteMapper;

	@Autowired
	private OperadoraMapper operadoraMapper;

	public EstipulanteDTO salvar(EstipulanteDTO estipulanteDTO) {
		Optional<Operadora> operadora = operadoraRepository.findById(estipulanteDTO.getOperadora().getCodigo());
		if (!operadora.isPresent()) {
			throw new OperadoraNaoExisteException();
		}
		// estipulanteDTO.setOperadora(operadoraMapper.toDto(operadora.get()));
		Estipulante estipulanteSalvo = repository.save(estipulanteMapper.toEntity(estipulanteDTO));
		return estipulanteMapper.toDto(estipulanteSalvo);
	}

	public EstipulanteDTO buscarPorId(Long codigoOperadora, Long codigoEstipulante) {
		Optional<Estipulante> estipulante = repository.findById(new EstipulantePK(codigoOperadora, codigoEstipulante));
		return estipulanteMapper.toDto(estipulante.get());
	}
}
