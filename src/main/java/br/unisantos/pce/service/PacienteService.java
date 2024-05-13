package br.unisantos.pce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.pce.model.Paciente;
import br.unisantos.pce.repository.PacienteRepository;

@Service
public class PacienteService {
    
	@Autowired
    private PacienteRepository repository;

    public List<Paciente> listarPacientes() {
		return (List<Paciente>) repository.findAll();
	}
	
	public Optional<Paciente> consultarPaciente (Integer id) {
		return repository.findById(id);
	}
	
	public Paciente criarPaciente (Paciente paciente) {
		repository.save(paciente);
		return paciente;
	}
	
	public Paciente alterarPaciente (Paciente paciente) {
		repository.save(paciente);
		return paciente;
	}

	public Boolean deletarPaciente (Integer id) {
		repository.deleteById(id);
		return true;
	}

}
