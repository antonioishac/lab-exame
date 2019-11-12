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

@RestController
@RequestMapping("/api/exame")
public class ExameResource {

	@Autowired
	private ExameService exameService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Exame> salvarExame(@Valid @RequestBody Exame exame, HttpServletResponse response) {
		Exame exameSalvo = exameService.salvarExame(exame);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, exameSalvo.getId()));
		return ResponseEntity.ok(exameSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Exame> atualizarExame(@PathVariable Long codigo, @RequestBody Exame exame) {
		Exame exameSalvo = exameService.atualizarExame(codigo, exame);
		return ResponseEntity.ok(exameSalvo);
	}

	@GetMapping("/ativos")
	public ResponseEntity<Page<Exame>> listarExamesAtivos(ExameFilter filter, Pageable pageable) {
		filter.setStatus(Status.ATIVO);
		Page<Exame> laboratorios = exameService.filtrarExame(filter, pageable);
		return laboratorios == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(laboratorios);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Exame> buscarExamePeloCodigo(@PathVariable Long codigo) {
		Exame exame = exameService.buscarExamePeloCodigo(codigo);
		return ResponseEntity.ok(exame);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativarExame(@PathVariable Long codigo) {
		exameService.inativarExame(codigo);
	}

	@DeleteMapping("/remover/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerEmLote(@PathVariable Long codigo) {
		exameService.removerEmLote(codigo);
	}

}
