package br.unisantos.pce.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.unisantos.pce.model.Paciente;
import br.unisantos.pce.service.PacienteService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/pacientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {
    
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
	public ResponseEntity<List<Paciente>> listarpacientes() {
		return ResponseEntity.status(200).body(pacienteService.listarpacientes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Paciente>> consultarpaciente (@PathVariable Integer id) {
		Optional<Paciente> pacienteOptional = pacienteService.consultarpaciente(id);

		if (pacienteOptional.isPresent()) {
			return ResponseEntity.status(200).body(pacienteService.consultarpaciente(id));
		}

		return ResponseEntity.status(404).build();
	}
	
	@PostMapping
	public ResponseEntity<Paciente> criarpaciente (@Valid @RequestBody Paciente novopaciente) {
		return ResponseEntity.status(201).body(pacienteService.criarpaciente(novopaciente));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Paciente> alterarpaciente (@PathVariable Integer id, @RequestBody Map<String, Object> atributos) {
		Optional<Paciente> pacienteOptional = pacienteService.consultarpaciente(id);

		if (pacienteOptional.isPresent()) {
			Paciente paciente = pacienteOptional.get();

			if (atributos.containsKey("nome")) {
				paciente.setNome((String) atributos.get("nome"));
			}

			Paciente pacienteAlterado = pacienteService.alterarpaciente(paciente);
			return ResponseEntity.status(200).body(pacienteAlterado);
		}

		return ResponseEntity.status(404).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarpaciente (@PathVariable Integer id) {
		Optional<Paciente> pacienteOptional = pacienteService.consultarpaciente(id);

		if (pacienteOptional.isPresent()) {
			pacienteService.deletarpaciente(id);
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.status(404).build();
	}

}
