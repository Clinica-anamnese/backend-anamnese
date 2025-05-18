package br.unisantos.pce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.pce.model.Retorno;

public interface RetornoRepository extends JpaRepository<Retorno, Integer>{
    List<Retorno> findAllByPacienteId(Integer pacienteId);
    List<Retorno> findAllByUsuarioId(Integer usuarioId);
    List<Retorno> findAllByOrderByCriadoEmDesc();
    List<Retorno> findAllByAnamneseIdOrderByCriadoEmDesc(Integer anamneseId);

}
