package br.com.labexame.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.labexame.domain.Operadora;
import br.com.labexame.domain.Prestador;
import br.com.labexame.domain.id.PrestadorPK;
import br.com.labexame.repository.OperadoraRepository;
import br.com.labexame.repository.PrestadorRepository;
import br.com.labexame.service.dto.PrestadorDTO;
import br.com.labexame.service.dto.UsuarioDTO;
import br.com.labexame.service.exception.OperadoraNaoExisteException;
import br.com.labexame.service.mapper.PrestadorMapper;

@Service
@Transactional
public class PrestadorService {

	@Autowired
	private PrestadorRepository repository;

	@Autowired
	private OperadoraRepository operadoraRepository;

	@Autowired
	private PrestadorMapper prestadorMapper;

	public PrestadorDTO salvarPrestador(PrestadorDTO prestadorDTO) {
		Optional<Operadora> operadora = operadoraRepository.findById(prestadorDTO.getOperadora().getCodigo());
		if (!operadora.isPresent()) {
			throw new OperadoraNaoExisteException();
		}
		//prestadorDTO.setOperadora(operadoraMapper.toDto(operadora.get()));
		prestadorDTO.setDataAlteracao(LocalDateTime.now());
		prestadorDTO.setUsuario(new UsuarioDTO(1L));

		Prestador prestadorSalvo = repository.save(prestadorMapper.toEntity(prestadorDTO));

		return prestadorMapper.toDto(prestadorSalvo);
	}

	public PrestadorDTO buscarPorId(Long codigoOperadora, String cpfCnpj) {
		Optional<Prestador> prestador = repository.findById(new PrestadorPK(codigoOperadora, cpfCnpj));
		return prestadorMapper.toDto(prestador.get());
	}

}
