package br.unisantos.pce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Paciente {

    private enum Sexo {
        masculino,
        feminino,
        nao_informado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = true)
    private String cpf;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "criado_em", nullable = false)
	private LocalDateTime criadoEm;

	@PrePersist
	protected void onCreate() {
		criadoEm = LocalDateTime.now();
	}

}
