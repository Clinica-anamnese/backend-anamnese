package br.unisantos.pce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.pce.model.Paciente;
import br.unisantos.pce.repository.PacienteRepository;

@Service
public class PacienteService {
    
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarpacientes() {
		return (List<Paciente>) pacienteRepository.findAll();
	}
	
	public Optional<Paciente> consultarpaciente (Integer id) {
		return pacienteRepository.findById(id);
	}
	
	public Paciente criarpaciente (Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	}
	
	public Paciente alterarpaciente (Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	}

	public Boolean deletarpaciente (Integer id) {
		pacienteRepository.deleteById(id);
		return true;
	}

}
