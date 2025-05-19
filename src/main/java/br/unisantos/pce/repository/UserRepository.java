package br.unisantos.pce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import br.unisantos.pce.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    UserDetails findByLogin(String login);

    List<User> findAllByOrderByCriadoEmDesc();

    @Query(value = "SELECT * FROM usuario WHERE UPPER(nome) ILIKE CONCAT('%', :nome, '%') OR UPPER(matricula) ILIKE CONCAT('%', :nome, '%') ORDER BY criado_em DESC", nativeQuery = true)
    List<User> findAllByNomeOrMatriculaOrderByCriadoEmDesc(@Param("nome") String nome);
}
