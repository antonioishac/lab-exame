package br.com.labexame.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.labexame.domain.Exame;
import br.com.labexame.domain.Status;
import br.com.labexame.repository.ExameRepository;
import br.com.labexame.service.exception.ExameInativoException;
import br.com.labexame.service.exception.ExameNaoExisteException;
import br.com.labexame.service.filter.ExameFilter;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private LaboratorioService laboratorioService;

	/**
	 * Servi\u00e7o para salvar um exame
	 *
	 * @param exame
	 * @return
	 */
	public Exame salvarExame(Exame exame) {
		exame.setStatus(Status.ATIVO);
		verificaLaboratoriosAtivos(exame);
		return exameRepository.save(exame);
	}

	/**
	 * M\u00e9todo para atualizar um exame, associar ou desassociar um exame.
	 *
	 * @param codigo
	 * @param laboratorio
	 * @return Laboratorio
	 */
	public Exame atualizarExame(Long codigo, Exame exame) {
		Optional<Exame> exameSalvo = exameRepository.findById(codigo);

		if (exame.getLaboratorios() != null) {
			exameSalvo.get().getLaboratorios().clear();
			exameSalvo.get().getLaboratorios().addAll(exame.getLaboratorios());
		}

		BeanUtils.copyProperties(exame, exameSalvo.get(), "id", "status", "laboratorios");

		return exameRepository.save(exameSalvo.get());
	}

	public Page<Exame> filtrarExame(ExameFilter exameFilter, Pageable pageable) {
		Page<Exame> exames = exameRepository.filtrar(exameFilter, pageable);
		return exames;
	}

	/**
	 * M\u00e9todo para inativar um exame logicamente.
	 *
	 * @param codigo
	 */
	public void inativarExame(Long codigo) {
		Optional<Exame> exameAtivo = exameRepository.findById(codigo);
		if (!exameAtivo.isPresent()) {
			throw new ExameNaoExisteException();
		}
		else if (exameAtivo.get().getStatus().equals(Status.INATIVO)) {
			throw new ExameInativoException();
		}
		exameRepository.inativar(Status.INATIVO, codigo);
	}

	/**
	 * M\u00e9todo para buscar um exame pelo c\u00f3digo.
	 *
	 * @param codigo
	 * @return Exame
	 */
	public Exame buscarExamePeloCodigo(Long codigo) {
		Optional<Exame> existeExame = exameRepository.findById(codigo);
		if (!existeExame.isPresent()) {
			throw new ExameNaoExisteException();
		}
		return existeExame.get();
	}

	/**
	 * M\u00e9todo para verificar se os laborat\u00f3rios est\u00e3o ativos.
	 *
	 * @param exame
	 */
	public void verificaLaboratoriosAtivos(Exame exame) {
		if (exame.getLaboratorios() != null) {
			exame.getLaboratorios().forEach(lab -> {
				laboratorioService.laboratorioAtivo(lab.getId());

			});
		}
	}

	/**
	 * Método que realiza a remoção em lote dos exames.
	 *
	 * @param codigo
	 */
	public void removerEmLote(Long codigo) {
		Optional<Exame> existeExame = exameRepository.findById(codigo);
		if (!existeExame.isPresent()) {
			throw new ExameNaoExisteException();
		}
		exameRepository.delete(existeExame.get());
	}
}
