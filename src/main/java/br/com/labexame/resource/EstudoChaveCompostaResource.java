package br.com.labexame.resource;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.labexame.service.EstipulanteService;
import br.com.labexame.service.PrestadorService;
import br.com.labexame.service.dto.EstipulanteDTO;
import br.com.labexame.service.dto.PrestadorDTO;

@RestController
@RequestMapping("/api/chave-composta")
public class EstudoChaveCompostaResource {

	@Autowired
	private EstipulanteService estipulanteService;

	@Autowired
	private PrestadorService prestadorService;

	//@Autowired
	//private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<EstipulanteDTO> salvarEstipulante(@RequestBody EstipulanteDTO estipulante, HttpServletResponse response) {
		estipulante.setFlagAtivo("S");
		estipulante.setDataAlteracao(LocalDateTime.now());
		EstipulanteDTO estipulanteSalvo = estipulanteService.salvar(estipulante);
		return ResponseEntity.ok(estipulanteSalvo);
	}

	@PostMapping("/prestador")
	public ResponseEntity<PrestadorDTO> salvarPrestador(@RequestBody PrestadorDTO prestador, HttpServletResponse response) {
		PrestadorDTO prestadorSalvo = prestadorService.salvarPrestador(prestador);
		return ResponseEntity.ok(prestadorSalvo);
	}

	@GetMapping("/{codigoOperadora}/{codigoEstipulante}")
	public ResponseEntity<EstipulanteDTO> buscarPelaChaveDoEstipulante(@PathVariable Long codigoOperadora, @PathVariable Long codigoEstipulante) {
		EstipulanteDTO estipulante = estipulanteService.buscarPorId(codigoOperadora, codigoEstipulante);
		return estipulante == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(estipulante);
	}

	@GetMapping("/prestador/{codigoOperadora}/{cpfCnpj}")
	public ResponseEntity<PrestadorDTO> buscarPelaChaveDoPrestador(@PathVariable Long codigoOperadora, @PathVariable String cpfCnpj) {
		PrestadorDTO prestador = prestadorService.buscarPorId(codigoOperadora, cpfCnpj);
		return prestador == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(prestador);
	}
}
