package br.unisantos.pce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unisantos.pce.model.Retorno;

public interface RetornoRepository extends JpaRepository<Retorno, Integer>{
    List<Retorno> findAllByPacienteId(Integer pacienteId);

    List<Retorno> findAllByUsuarioId(Integer usuarioId);

    List<Retorno> findAllByOrderByCriadoEmDesc();

    List<Retorno> findAllByAnamneseIdOrderByCriadoEmDesc(Integer anamneseId);

    @Query(value = "SELECT * FROM retorno WHERE UPPER(paciente_nome) ILIKE CONCAT('%', :nome, '%') ORDER BY criado_em DESC", nativeQuery = true)
    List<Retorno> findByPacienteNome(@Param("nome") String pacienteNome);
}
