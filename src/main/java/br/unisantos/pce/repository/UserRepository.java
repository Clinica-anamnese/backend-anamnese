package br.unisantos.pce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.unisantos.pce.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    UserDetails findByLogin(String login);
}
