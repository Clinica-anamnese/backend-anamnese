package br.unisantos.pce.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Anamnese {

    public Anamnese(String pergunta, Integer pacienteId) {
        this.pergunta = pergunta;
        this.pacienteId = pacienteId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pergunta", nullable = false)
    private String pergunta;

    @Column(name = "paciente_id", nullable = false)
    private Integer pacienteId;

    @Column(name = "criado_em", nullable = false)
    private LocalDate criadoEm;

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDate.now();
    }
}
