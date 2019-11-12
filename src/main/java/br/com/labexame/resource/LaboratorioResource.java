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

import br.com.labexame.domain.Laboratorio;
import br.com.labexame.domain.Status;
import br.com.labexame.event.RecursoCriadoEvent;
import br.com.labexame.service.LaboratorioService;
import br.com.labexame.service.filter.LaboratorioFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API referente a Laborat\u00f3rio")
@RestController
@RequestMapping("/api/laboratorio")
public class LaboratorioResource {

	@Autowired
	private LaboratorioService laboratorioService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	@ApiOperation(value = "Cadastrar Laborat\u00f3rio", response = Laboratorio.class,
	notes = "Essa opera\u00e7\u00e3o cadastra um laborat\u00f3rio e uma lista de endere\u00e7os")
	public ResponseEntity<Laboratorio> salvarLaboratorio(@Valid @RequestBody Laboratorio laboratorio, HttpServletResponse response) {
		Laboratorio laboratorioSalvo = laboratorioService.salvarLaboratorio(laboratorio);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, laboratorioSalvo.getId()));
		return ResponseEntity.ok(laboratorioSalvo);
	}

	@PutMapping("/{codigo}")
	@ApiOperation(value = "Atualizar um Laborat\u00f3rio", response = Laboratorio.class,
	notes = "Essa opera\u00e7\u00e3o atualiza um laborat\u00f3rio e uma lista de endere\u00e7os")
	public ResponseEntity<Laboratorio> atualizarLaboratorio(@PathVariable Long codigo, @RequestBody Laboratorio laboratorio) {
		Laboratorio laboratorioSalvo = laboratorioService.atualizarLaboratorio(codigo, laboratorio);
		return ResponseEntity.ok(laboratorioSalvo);
	}

	@GetMapping("/ativos")
	@ApiOperation(value = "Buscar laborat\u00f3rios ativos", response = Laboratorio.class,
	notes = "Essa opera\u00e7\u00e3o lista os laborat\u00f3rios com status ativo.")
	public ResponseEntity<Page<Laboratorio>> listarLaboratoriosAtivos(LaboratorioFilter filter, Pageable pageable) {
		filter.setStatus(Status.ATIVO);
		Page<Laboratorio> laboratorios = laboratorioService.filtrarLaboratorio(filter, pageable);
		return laboratorios == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(laboratorios);
	}

	@GetMapping("/{codigo}")
	@ApiOperation(value = "Buscar laborat\u00f3rio", response = Laboratorio.class,
	notes = "Essa opera\u00e7\u00e3o busca pelo c\u00f3digo do laborat\u00f3rio com status ativo.")
	public ResponseEntity<Laboratorio> buscarLaboratorioPeloCodigo(@PathVariable Long codigo) {
		Laboratorio laboratorio = laboratorioService.buscarLaboratorioPeloCodigo(codigo);
		return ResponseEntity.ok(laboratorio);
	}

	@DeleteMapping("/{codigo}")
	@ApiOperation(value = "Remove um laboratório", response = Laboratorio.class,
	notes = "Essa opera\u00e7\u00e3o remove um laboratório logicamente com status inativo.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativarLaboratorio(@PathVariable Long codigo) {
		laboratorioService.inativarLaboratorio(codigo);
	}

}
