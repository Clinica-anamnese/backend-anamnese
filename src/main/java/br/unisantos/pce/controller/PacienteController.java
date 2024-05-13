package br.unisantos.pce.controller;

import java.util.List;
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
	public ResponseEntity<List<Paciente>> listarPacientes() {
		return ResponseEntity.status(200).body(pacienteService.listarPacientes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Paciente>> consultarPaciente (@PathVariable Integer id) {
		Optional<Paciente> pacienteOptional = pacienteService.consultarPaciente(id);

		if (pacienteOptional.isPresent()) {
			return ResponseEntity.status(200).body(pacienteService.consultarPaciente(id));
		}

		return ResponseEntity.status(404).build();
	}
	
	@PostMapping
	public ResponseEntity<Paciente> criarPaciente (@Valid @RequestBody Paciente novopaciente) {
		return ResponseEntity.status(201).body(pacienteService.criarPaciente(novopaciente));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Paciente> alterarPaciente (@PathVariable Integer id, @RequestBody Paciente pacienteAtualizado) {
		Optional<Paciente> paciente = pacienteService.consultarPaciente(id);

		if (paciente.isPresent()) {
			paciente.get().setNome(pacienteAtualizado.getNome());
			paciente.get().setSexo(pacienteAtualizado.getSexo());
			paciente.get().setDataNascimento(pacienteAtualizado.getDataNascimento());
			pacienteService.alterarPaciente(paciente.get());
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.status(404).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPaciente (@PathVariable Integer id) {
		Optional<Paciente> pacienteOptional = pacienteService.consultarPaciente(id);

		if (pacienteOptional.isPresent()) {
			pacienteService.deletarPaciente(id);
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.status(404).build();
	}

}
