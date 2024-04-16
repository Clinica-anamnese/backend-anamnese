package br.unisantos.pce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.pce.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
}
