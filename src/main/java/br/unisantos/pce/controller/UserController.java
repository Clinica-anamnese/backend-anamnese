package br.unisantos.pce.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import br.unisantos.pce.service.UserService;
import br.unisantos.pce.user.User;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
	public ResponseEntity<List<User>> listarUsuarios() {
		return ResponseEntity.ok(userService.listarUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> consultarUsuario (@PathVariable Integer id) {
		Optional<User> usuarioOptional = userService.consultarUsuarioPorId(id);

		if (usuarioOptional.isPresent()) {
			return ResponseEntity.ok(userService.consultarUsuarioPorId(id));
		}

		return ResponseEntity.status(404).build();
	}
	
	@PostMapping
	public ResponseEntity<User> criarUsuario (@Valid @RequestBody User user) {
		 if(userService.consultarUsuarioPorLogin(user.getLogin()) != null) return ResponseEntity.badRequest().build();
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User newUser = new User(user.getNome(), user.getLogin(), encryptedPassword, user.getRole());

        userService.criarUsuario(newUser);

        return ResponseEntity.status(201).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> alterarUsuario (@PathVariable Integer id, @RequestBody Map<String, Object> atributos) {
		Optional<User> usuarioOptional = userService.consultarUsuarioPorId(id);

		if (usuarioOptional.isPresent()) {
			User usuario = usuarioOptional.get();

			if (atributos.containsKey("nome")) {
				usuario.setNome((String) atributos.get("nome"));
			}
			if (atributos.containsKey("matricula")) {
				usuario.setLogin((String) atributos.get("matricula"));
			}

			User usuarioAlterado = userService.alterarUsuario(usuario);
			return ResponseEntity.status(200).body(usuarioAlterado);
		}

		return ResponseEntity.status(404).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuario (@PathVariable Integer id) {
		Optional<User> usuarioOptional = userService.consultarUsuarioPorId(id);

		if (usuarioOptional.isPresent()) {
			userService.deletarUsuario(id);
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.status(404).build();
	}

}
