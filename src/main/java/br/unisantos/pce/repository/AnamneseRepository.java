package br.unisantos.pce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.pce.model.Anamnese;

public interface AnamneseRepository extends JpaRepository<Anamnese, Integer>{
    List<Anamnese> findAllByPacienteId(Integer pacienteId);
    List<Anamnese> findAllByUsuarioId(Integer usuarioId);
}
