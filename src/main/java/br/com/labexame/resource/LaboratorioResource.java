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

@RestController
@RequestMapping("/api/laboratorio")
public class LaboratorioResource {

	@Autowired
	private LaboratorioService laboratorioService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Laboratorio> salvarLaboratorio(@Valid @RequestBody Laboratorio laboratorio, HttpServletResponse response) {
		Laboratorio laboratorioSalvo = laboratorioService.salvarLaboratorio(laboratorio);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, laboratorioSalvo.getId()));
		return ResponseEntity.ok(laboratorioSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Laboratorio> atualizarLaboratorio(@PathVariable Long codigo, @RequestBody Laboratorio laboratorio) {
		Laboratorio laboratorioSalvo = laboratorioService.atualizarLaboratorio(codigo, laboratorio);
		return ResponseEntity.ok(laboratorioSalvo);
	}

	@GetMapping("/ativos")
	public ResponseEntity<Page<Laboratorio>> listarLaboratoriosAtivos(LaboratorioFilter filter, Pageable pageable) {
		filter.setStatus(Status.ATIVO);
		Page<Laboratorio> laboratorios = laboratorioService.filtrarLaboratorio(filter, pageable);
		return laboratorios == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(laboratorios);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Laboratorio> buscarLaboratorioPeloCodigo(@PathVariable Long codigo) {
		Laboratorio laboratorio = laboratorioService.buscarLaboratorioPeloCodigo(codigo);
		return ResponseEntity.ok(laboratorio);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerLaboratorio(@PathVariable Long codigo) {
		laboratorioService.removerLaboratorio(codigo);
	}

}
