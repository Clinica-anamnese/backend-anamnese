package br.unisantos.pce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisantos.pce.model.Anamnese;
import br.unisantos.pce.repository.AnamneseRepository;

@Service
public class AnamneseService {

    @Autowired
    private AnamneseRepository repository;

    public List<Anamnese> listarAnamneses() {
        return (List<Anamnese>) repository.findAll();
    }

    public Optional<Anamnese> consultarAnamnese(Integer id) {
        return repository.findById(id);
    }

    public Anamnese criarAnamnese(Anamnese anamnese) {
        repository.save(anamnese);
        return anamnese;
    }

    public Anamnese alterarAnamnese(Anamnese anamnese) {
        repository.save(anamnese);
        return anamnese;
    }

    public Boolean deletarAnamnese(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
