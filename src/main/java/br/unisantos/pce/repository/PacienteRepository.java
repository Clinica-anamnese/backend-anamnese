package br.unisantos.pce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.unisantos.pce.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findAllByOrderByCriadoEmDesc();

    @Query(value = "SELECT * FROM paciente WHERE UPPER(nome) ILIKE CONCAT('%', :nome, '%') ORDER BY criado_em DESC", nativeQuery = true)
    List<Paciente> findByNomeOrderByCriadoEmDesc(@Param("nome") String pacienteNome);
    
}
