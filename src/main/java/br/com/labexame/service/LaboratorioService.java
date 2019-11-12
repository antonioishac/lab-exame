package br.com.labexame.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.labexame.domain.Laboratorio;
import br.com.labexame.domain.Status;
import br.com.labexame.repository.LaboratorioRepository;
import br.com.labexame.service.exception.LaboratorioExisteException;
import br.com.labexame.service.exception.LaboratorioInativoException;
import br.com.labexame.service.exception.LaboratorioNaoExisteException;
import br.com.labexame.service.filter.LaboratorioFilter;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	/**
	 * M\u00e9todo para realizar o cadastro de um laborat\u00f3rio.
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
		if (laboratorio.getEnderecos() != null) {
			laboratorio.getEnderecos().forEach(e -> e.setLaboratorio(laboratorio));
		}

		return laboratorioRepository.save(laboratorio);
	}

	/**
	 * M\u00e9todo para atualiza um laborat\u00f3rio.
	 *
	 * @param codigo
	 * @param laboratorio
	 * @return Laboratorio
	 */
	public Laboratorio atualizarLaboratorio(Long codigo, Laboratorio laboratorio) {
		Optional<Laboratorio> laboratorioSalvo = laboratorioRepository.findById(codigo);

		if (laboratorio.getEnderecos() != null) {
			laboratorioSalvo.get().getEnderecos().clear();
			laboratorioSalvo.get().getEnderecos().addAll(laboratorio.getEnderecos());
			laboratorioSalvo.get().getEnderecos().forEach(c -> c.setLaboratorio(laboratorioSalvo.get()));
		}

		BeanUtils.copyProperties(laboratorio, laboratorioSalvo.get(), "id", "status", "enderecos");

		return laboratorioRepository.save(laboratorioSalvo.get());
	}

	/**
	 * M\u00e9todo que retorna uma lista de laborat\u00f3rios conforme os par\u00e2metros do filtro.
	 *
	 * @param laboratorioFilter
	 * @param pageable
	 * @return Page<Laboratorio>
	 */
	public Page<Laboratorio> filtrarLaboratorio(LaboratorioFilter laboratorioFilter, Pageable pageable) {
		Page<Laboratorio> laboratorios = laboratorioRepository.filtrar(laboratorioFilter, pageable);
		return laboratorios;
	}

	/**
	 * M\u00e9todo para inativar um laborat\u00f3rio logicamente.
	 *
	 * @param codigo
	 */
	public void inativarLaboratorio(Long codigo) {
		Optional<Laboratorio> laboratorioAtivo = laboratorioRepository.findById(codigo);
		if (!laboratorioAtivo.isPresent()) {
			throw new LaboratorioNaoExisteException();
		}
		else if (laboratorioAtivo.get().getStatus().equals(Status.INATIVO)) {
			throw new LaboratorioInativoException();
		}
		laboratorioRepository.inativar(Status.INATIVO, codigo);
	}

	/**
	 * M\u00e9todo para buscar um Laboratorio pelo c\u00f3digo
	 *
	 * @param codigo
	 * @return Laboratorio
	 */
	public Laboratorio buscarLaboratorioPeloCodigo(Long codigo) {
		Optional<Laboratorio> existeLaboratorio = laboratorioRepository.findById(codigo);
		if (!existeLaboratorio.isPresent()) {
			throw new LaboratorioNaoExisteException();
		}
		return existeLaboratorio.get();
	}

	/**
	 * M\u00e9todo que verifica se um laborat\u00f3rio existe e est\u00e1 ativo.
	 *
	 * @param codigo
	 * @return Boolean
	 */
	public void laboratorioAtivo(Long codigo) {
		Optional<Laboratorio> laboratorioAtivo = laboratorioRepository.findById(codigo);
		if (laboratorioAtivo.isPresent()) {
			if (Status.INATIVO.equals(laboratorioAtivo.get().getStatus())) {
				throw new LaboratorioInativoException(laboratorioAtivo.get().getId());
			}
			return;
		}
		throw new LaboratorioNaoExisteException();
	}

}
