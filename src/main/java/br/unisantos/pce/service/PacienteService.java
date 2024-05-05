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

    public List<Paciente> listarpacientes() {
		return (List<Paciente>) repository.findAll();
	}
	
	public Optional<Paciente> consultarpaciente (Integer id) {
		return repository.findById(id);
	}
	
	public Paciente criarpaciente (Paciente paciente) {
		repository.save(paciente);
		return paciente;
	}
	
	public Paciente alterarpaciente (Paciente paciente) {
		repository.save(paciente);
		return paciente;
	}

	public Boolean deletarpaciente (Integer id) {
		repository.deleteById(id);
		return true;
	}

}
