package br.unisantos.pce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.pce.model.Anamnese;

public interface AnamneseRepository extends JpaRepository<Anamnese, Integer>{
    
}
