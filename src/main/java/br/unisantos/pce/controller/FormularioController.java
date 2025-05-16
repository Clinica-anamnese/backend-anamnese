package br.unisantos.pce.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unisantos.pce.model.Anamnese;
import br.unisantos.pce.model.Retorno;
import br.unisantos.pce.service.AnamneseService;
import br.unisantos.pce.service.FormularioService;
import br.unisantos.pce.service.RetornoService;
import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/formularios", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormularioController {

    private final AnamneseService anamneseService;
    private final RetornoService retornoService;
    private final FormularioService formularioService;

    @Autowired
    public FormularioController(AnamneseService anamneseService, RetornoService retornoService,
            FormularioService formularioService) {
        this.anamneseService = anamneseService;
        this.retornoService = retornoService;
        this.formularioService = formularioService;
    }

    // Retornando anamneses e retornos ordenados pela data de criacao
    @GetMapping
    public ResponseEntity<List<Anamnese>> listarFormularios(@RequestParam(required = false, defaultValue = "") String nome) {
        /*List<Object> formularios = new ArrayList<>(anamneseService.listarAnamneses());

        formularios.addAll(retornoService.listarRetornos());

        formularios.sort(Comparator.comparing(formulario -> {
            if (formulario instanceof Anamnese) {
                return ((Anamnese) formulario).getCriadoEm();
            } else if (formulario instanceof Retorno) {
                return ((Retorno) formulario).getCriadoEm();
            } else {
                return LocalDateTime.MIN;
            }
        }).reversed());*/

        List<Anamnese> anamneses = anamneseService.listarAnamnesesByPacienteNome(nome);

        for (var anamnese : anamneses) {
            anamnese.setRetornos(retornoService.listarRetornosByAnamneseId(anamnese.getId()));
        }

        return ResponseEntity.ok(anamneses);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<List<Object>> listarFormulariosDoPaciente(@PathVariable Integer id) {
        List<Object> formularios = new ArrayList<>(anamneseService.listarAnamneses());
        formularios.addAll(retornoService.listarRetornos());

        List<Object> formulariosDoPaciente = formularios.stream()
                .filter(formulario -> {
                    if (formulario instanceof Anamnese) {
                        return ((Anamnese) formulario).getPacienteId().equals(id);
                    } else if (formulario instanceof Retorno) {
                        return ((Retorno) formulario).getPacienteId().equals(id);
                    } else {
                        return false;
                    }
                })
                .sorted(Comparator.comparing(formulario -> {
                    if (formulario instanceof Anamnese) {
                        return ((Anamnese) formulario).getCriadoEm();
                    } else if (formulario instanceof Retorno) {
                        return ((Retorno) formulario).getCriadoEm();
                    } else {
                        return LocalDateTime.MIN;
                    }
                }).reversed())
                .collect(Collectors.toList());

        return ResponseEntity.ok(formulariosDoPaciente);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<List<Object>> listarFormulariosDoUsuario(@PathVariable Integer id) {
        List<Object> formularios = new ArrayList<>(anamneseService.listarAnamneses());
        formularios.addAll(retornoService.listarRetornos());

        List<Object> formulariosDoUsuario = formularios.stream()
                .filter(formulario -> {
                    if (formulario instanceof Anamnese) {
                        return ((Anamnese) formulario).getUsuarioId().equals(id);
                    } else if (formulario instanceof Retorno) {
                        return ((Retorno) formulario).getUsuarioId().equals(id);
                    } else {
                        return false;
                    }
                })
                .sorted(Comparator.comparing(formulario -> {
                    if (formulario instanceof Anamnese) {
                        return ((Anamnese) formulario).getCriadoEm();
                    } else if (formulario instanceof Retorno) {
                        return ((Retorno) formulario).getCriadoEm();
                    } else {
                        return LocalDateTime.MIN;
                    }
                }).reversed())
                .collect(Collectors.toList());

        return ResponseEntity.ok(formulariosDoUsuario);
    }

    @GetMapping("/export-anamnese")
    public void exportAnamnese(HttpServletResponse servletResponse) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=anamneses.csv");

        try {
            formularioService.exportAnamneseToCSV(servletResponse.getWriter());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @GetMapping("/export-retorno")
    public void exportRetorno(HttpServletResponse servletResponse) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=anamneses.csv");

        try {
            formularioService.exportRetornoToCSV(servletResponse.getWriter());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
