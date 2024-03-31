package br.unisantos.pce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.pce.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
