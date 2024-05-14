package br.unisantos.pce.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Anamnese {

    public Anamnese(String pergunta, Paciente paciente) {
        this.pergunta1 = pergunta;
        this.paciente = paciente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pergunta1", nullable = false)
    private String pergunta1;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente paciente;

    @Column(name = "criado_em", nullable = false)
    private LocalDate criadoEm;

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDate.now();
    }
}
