package br.com.labexame.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.labexame.domain.Medico;
import br.com.labexame.event.RecursoCriadoEvent;
import br.com.labexame.repository.MedicoRepository;
import br.com.labexame.service.MedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API referente a M\u00e9dicos")
@RestController
@RequestMapping("/api/medico")
public class MedicoResource {

	@Autowired
	private MedicoRepository repository;

	@Autowired
	private MedicoService service;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	@ApiOperation(value = "Cadastrar M\u00e9dico", response = Medico.class,
	notes = "Essa opera\u00e7\u00e3o cadastra um m\u00e9dico")
	public ResponseEntity<Medico> salvarMedico(@Valid @RequestBody Medico medico, HttpServletResponse response) {
		Medico medicoSalvo = service.salvar(medico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, medicoSalvo.getId()));
		return ResponseEntity.ok(medicoSalvo);
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os m\u00e9dicos", response = Medico.class,
	notes = "Essa opera\u00e7\u00e3o lista todos os m\u00e9dicos.")
	public ResponseEntity<List<Medico>> listarTodosMedicos() {
		List<Medico> medicos = repository.findAll();
		return medicos == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(medicos);
	}

	@GetMapping("/{codigo}")
	@ApiOperation(value = "Busca o m\u00e9dico pelo c\u00f3digo", response = Medico.class,
	notes = "Essa opera\u00e7\u00e3o busca o m\u00e9dico pelo c\u00f3digo.")
	public ResponseEntity<Medico> listaMedicoPeloCodigo(@PathVariable Long codigo) {
		Medico medico = service.buscarPeloCodigo(codigo);
		return medico == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(medico);
	}
}
