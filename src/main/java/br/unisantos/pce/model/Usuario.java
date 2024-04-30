package br.unisantos.pce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "matricula", nullable = false)
	private int matricula;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "adm", nullable = false)
	private boolean adm;

	@Column(name = "ativo", nullable = false)
	private boolean ativo;

}
