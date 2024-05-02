package br.unisantos.pce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.pce.repository.UsuarioRepository;
import br.unisantos.pce.user.User;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<User> listarUsuarios() {
		return (List<User>) usuarioRepository.findAll();
	}
	
	public Optional<User> consultarUsuario (Integer id) {
		return usuarioRepository.findById(id);
	}
	
	public User criarUsuario (User usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	public User alterarUsuario (User usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}

	public Boolean deletarUsuario (Integer id) {
		usuarioRepository.deleteById(id);
		return true;
	}

}
