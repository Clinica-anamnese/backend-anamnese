package br.unisantos.pce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.pce.model.Usuario;
import br.unisantos.pce.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Optional<Usuario> consultarUsuario (Integer id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario criarUsuario (Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	public Usuario alterarUsuario (Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}

	public Boolean deletarUsuario (Integer id) {
		usuarioRepository.deleteById(id);
		return true;
	}

}
