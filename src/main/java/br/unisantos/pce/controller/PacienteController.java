package br.unisantos.pce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import br.unisantos.pce.model.Anamnese;
import br.unisantos.pce.model.Paciente;
import br.unisantos.pce.service.AnamneseService;
import br.unisantos.pce.service.PacienteService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/pacientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
    
    private final PacienteService pacienteService;
    private final AnamneseService anamneseService;

    @Autowired
    public PacienteController(PacienteService pacienteService, AnamneseService anamneseService) {
        this.pacienteService = pacienteService;
        this.anamneseService = anamneseService;
    }

    @GetMapping
	public ResponseEntity<List<Paciente>> listarPacientes() {
		return ResponseEntity.ok(pacienteService.listarPacientes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Paciente>> consultarPaciente (@PathVariable Integer id) {
		Optional<Paciente> paciente = pacienteService.consultarPaciente(id);

		if (paciente.isPresent()) {
			return ResponseEntity.ok(pacienteService.consultarPaciente(id));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Paciente> criarPaciente (@Valid @RequestBody Paciente novopaciente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.criarPaciente(novopaciente));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Paciente> alterarPaciente (@PathVariable Integer id, @RequestBody Paciente pacienteAtualizado) {
		Optional<Paciente> paciente = pacienteService.consultarPaciente(id);
		List<Anamnese> anamneses = anamneseService.listarAnamnesesByPacienteId(id);

		if (paciente.isPresent()) {
			paciente.get().setNome(pacienteAtualizado.getNome());
			paciente.get().setSexo(pacienteAtualizado.getSexo());
			paciente.get().setDataNascimento(pacienteAtualizado.getDataNascimento());
			
			if (!anamneses.isEmpty()) {
				for (Anamnese anamnese : anamneses) {
					anamnese.setPacienteId(id);
					anamnese.setPacienteNome(paciente.get().getNome());
					anamneseService.alterarAnamnese(anamnese);
				}
			}
			
			return ResponseEntity.ok(pacienteService.alterarPaciente(paciente.get()));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPaciente (@PathVariable Integer id) {
		Optional<Paciente> paciente = pacienteService.consultarPaciente(id);

		if (paciente.isPresent()) {
			pacienteService.deletarPaciente(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
