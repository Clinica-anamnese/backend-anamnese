package br.unisantos.pce.controller;

import java.util.List;
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

import br.unisantos.pce.model.Anamnese;
import br.unisantos.pce.service.AnamneseService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/anamneses", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnamneseController {
    
       private final AnamneseService anamneseService;

    @Autowired
    public AnamneseController(AnamneseService anamneseService) {
        this.anamneseService = anamneseService;
    }

    @GetMapping
	public ResponseEntity<List<Anamnese>> listarAnamneses() {
		return ResponseEntity.status(200).body(anamneseService.listarAnamneses());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Anamnese>> consultarAnamnese (@PathVariable Integer id) {
		Optional<Anamnese> anamneseOptional = anamneseService.consultarAnamnese(id);

		if (anamneseOptional.isPresent()) {
			return ResponseEntity.status(200).body(anamneseService.consultarAnamnese(id));
		}

		return ResponseEntity.status(404).build();
	}
	
	@PostMapping
	public ResponseEntity<Anamnese> criarAnamnese (@Valid @RequestBody Anamnese novoanamnese) {
		return ResponseEntity.status(201).body(anamneseService.criarAnamnese(novoanamnese));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Anamnese> alterarAnamnese (@PathVariable Integer id, @RequestBody Anamnese anamneseAtualizado) {
		// Optional<Anamnese> anamnese = anamneseService.consultarAnamnese(id);

		/* if (anamnese.isPresent()) {
			anamnese.get().setNome(anamneseAtualizado.getNome());
			anamnese.get().setSexo(anamneseAtualizado.getSexo());
			anamnese.get().setDataNascimento(anamneseAtualizado.getDataNascimento());
			anamneseService.alterarAnamnese(anamnese.get());
			return ResponseEntity.status(204).build();
		} */

		return ResponseEntity.status(404).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarAnamnese (@PathVariable Integer id) {
		Optional<Anamnese> anamneseOptional = anamneseService.consultarAnamnese(id);

		if (anamneseOptional.isPresent()) {
			anamneseService.deletarAnamnese(id);
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.status(404).build();
	}

}
