package br.com.labexame.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.labexame.domain.Exame;
import br.com.labexame.domain.Status;
import br.com.labexame.event.RecursoCriadoEvent;
import br.com.labexame.service.ExameService;
import br.com.labexame.service.filter.ExameFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API referente a exames")
@RestController
@RequestMapping("/api/exame")
public class ExameResource {

	@Autowired
	private ExameService exameService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	@ApiOperation(value = "Cadastrar exame", response = Exame.class,
	notes = "Essa opera\u00e7\u00e3o cadastra um exame, no ato do cadastro temos a possibilidade de realizar a associa\u00e7\u00e3o a um ou mais laborat\u00f3rios ativos")
	public ResponseEntity<Exame> salvarExame(@Valid @RequestBody Exame exame, HttpServletResponse response) {
		Exame exameSalvo = exameService.salvarExame(exame);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, exameSalvo.getId()));
		return ResponseEntity.ok(exameSalvo);
	}

	@PutMapping("/{codigo}")
	@ApiOperation(value = "Atualizar exame", response = Exame.class,
	notes = "Essa opera\u00e7\u00e3o atualiza um exame, possibilidade de inclus\u00e3o de novos laborat\u00f3rios a este exame ou remover algum laborat\u00f3rio j\u00e1 associado a este exame")
	public ResponseEntity<Exame> atualizarExame(@PathVariable Long codigo, @RequestBody Exame exame) {
		Exame exameSalvo = exameService.atualizarExame(codigo, exame);
		return ResponseEntity.ok(exameSalvo);
	}

	@GetMapping("/ativos")
	@ApiOperation(value = "Listar exames", response = Exame.class,
	notes = "Essa opera\u00e7\u00e3o lista todos os laborat\u00f3rios ativos")
	public ResponseEntity<Page<Exame>> listarExamesAtivos(ExameFilter filter, Pageable pageable) {
		filter.setStatus(Status.ATIVO);
		Page<Exame> laboratorios = exameService.filtrarExame(filter, pageable);
		return laboratorios == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(laboratorios);
	}

	@GetMapping("/{codigo}")
	@ApiOperation(value = "Buscar exame", response = Exame.class,
	notes = "Essa opera\u00e7\u00e3o busca por um exame ativo, listando todos os laborat\u00f3rio associados a este exame.")
	public ResponseEntity<Exame> buscarExamePeloCodigo(@PathVariable Long codigo) {
		Exame exame = exameService.buscarExamePeloCodigo(codigo);
		return ResponseEntity.ok(exame);
	}

	@DeleteMapping("/{codigo}")
	@ApiOperation(value = "Inativar exame", response = Exame.class,
	notes = "Essa opera\u00e7\u00e3o inativa um exame espec\u00edfico.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativarExame(@PathVariable Long codigo) {
		exameService.inativarExame(codigo);
	}

	@DeleteMapping("/remover/{codigo}")
	@ApiOperation(value = "Cadastrar exame", response = Exame.class,
	notes = "Essa opera\u00e7\u00e3o remove fisicamente um exame e a associa\u00e7\u00e3o com os laborat\u00f3rios.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerEmLote(@PathVariable Long codigo) {
		exameService.removerEmLote(codigo);
	}

}
