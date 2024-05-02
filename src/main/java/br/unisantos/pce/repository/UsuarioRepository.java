package br.unisantos.pce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisantos.pce.user.User;

public interface UsuarioRepository extends JpaRepository<User, Integer>{

}
