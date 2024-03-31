package br.unisantos.pce.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import br.unisantos.pce.model.Usuario;
import br.unisantos.pce.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> consultarUsuario (@PathVariable Integer id) {
		Optional<Usuario> usuarioOptional = usuarioService.consultarUsuario(id);

		if (usuarioOptional.isPresent()) {
			return ResponseEntity.status(200).body(usuarioService.consultarUsuario(id));
		}

		return ResponseEntity.status(404).build();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(novoUsuario));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alterarUsuario (@PathVariable Integer id, @RequestBody Map<String, Object> atributos) {
		Optional<Usuario> usuarioOptional = usuarioService.consultarUsuario(id);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();

			if (atributos.containsKey("nome")) {
				usuario.setNome((String) atributos.get("nome"));
			}
			if (atributos.containsKey("matricula")) {
				usuario.setMatricula((int) atributos.get("matricula"));
			}

			Usuario usuarioAlterado = usuarioService.alterarUsuario(usuario);
			return ResponseEntity.status(200).body(usuarioAlterado);
		}

		return ResponseEntity.status(404).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuario (@PathVariable Integer id) {
		Optional<Usuario> usuarioOptional = usuarioService.consultarUsuario(id);

		if (usuarioOptional.isPresent()) {
			usuarioService.deletarUsuario(id);
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.status(404).build();
	}

}
