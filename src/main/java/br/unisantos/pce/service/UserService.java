package br.unisantos.pce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.pce.repository.UserRepository;
import br.unisantos.pce.user.User;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listarUsuarios() {
		return (List<User>) userRepository.findAll();
	}
	
	public Optional<User> consultarUsuario (Integer id) {
		return userRepository.findById(id);
	}
	
	public User criarUsuario (User usuario) {
		userRepository.save(usuario);
		return usuario;
	}
	
	public User alterarUsuario (User usuario) {
		userRepository.save(usuario);
		return usuario;
	}

	public Boolean deletarUsuario (Integer id) {
		userRepository.deleteById(id);
		return true;
	}

}
