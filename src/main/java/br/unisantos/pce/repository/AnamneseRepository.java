package br.unisantos.pce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unisantos.pce.model.Anamnese;

public interface AnamneseRepository extends JpaRepository<Anamnese, Integer>{

    @Query(value = "SELECT * FROM anamnese WHERE paciente_id = id ORDER BY criado_em DESC", nativeQuery = true)
    List<Anamnese> findAllByPacienteId(@Param("id") Integer pacienteId);
    
    List<Anamnese> findAllByUsuarioId(Integer usuarioId);
    
    List<Anamnese> findAllByOrderByCriadoEmDesc();

    @Query(value = "SELECT * FROM anamnese WHERE UPPER(paciente_nome) ILIKE CONCAT('%', :nome, '%') ORDER BY criado_em DESC", nativeQuery = true)
    List<Anamnese> findByPacienteNome(@Param("nome") String pacienteNome);

}
