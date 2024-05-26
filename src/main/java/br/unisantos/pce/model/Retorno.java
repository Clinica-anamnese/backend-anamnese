package br.unisantos.pce.model;

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
public class Retorno {

    private enum Opcao {
        sim,
        nao,
        mais_ou_menos;
    }

    private enum atvFisica {
        manteve_o_que_ja_fazia,
        aumentei_a_frequencia_intensidade,
        ainda_nao_consegui_praticar,
        nao_iniciei_e_nao_pretendo_iniciar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "paciente_id", nullable = false)
    private Integer pacienteId;

    @Column(name = "paciente_nome", length = 60, nullable = false)
    private String pacienteNome;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "usuario_nome", length = 60, nullable = false)
    private String usuarioNome;

    @Column(name = "tipo_formulario", nullable = false)
	private String tipoFormulario = "Retorno";

    @Column(name = "retorno", nullable = true)
    private Integer retorno;

    @Column(name = "metas_ultima_consulta", nullable = true)
    private String metasUltimasConsultas;

    @Column(name = "comentarios_observacao", nullable = true)
    private String comentariosObservacao;

    @Column(name = "metas_foram_cumpridas", nullable = true)
    @Enumerated(EnumType.STRING)
    private Opcao metasForamCumpridas;

    @Column(name = "desempenho_cumprimento_metas", columnDefinition = "TINYINT", nullable = true)
    private Integer desempenhoCumprimentoMetas;

    @Column(name = "motivo_assinalado_cumprimento_metas", nullable = true)
    private String motivoAssinaladoCumprimentoMetas;

    @Column(name = "como_sentiu_mudanca_habitos", nullable = true)
    private String comoSentiuMudancaHabitos;

    @Column(name = "adaptacao_mudanca_habitos", nullable = true)
    private String adaptacaoMudancaHabitos;

    @Column(name = "motivos_dificuldade_adaptacao", nullable = true)
    private String motivosDificuldadeAdaptacao;

    @Column(name = "sente_precisa_melhorar_alimentacao", nullable = true)
    private String sentePrecisaMelhorarAlimentacao;

    @Column(name = "habito_intestinal", nullable = true)
    private String habitoIntestinal;

    @Column(name = "atv_fisica", nullable = true)
    @Enumerated(EnumType.STRING)
    private atvFisica atvFisica;

    @Column(name = "metas_proximo_retorno", nullable = true)
    private String metasProximoRetorno;

    // medidas corporais //

    @Column(name = "peso_atual")
	private Float pesoAtual;

	@Column(name = "imc")
	private Float imc;

    @Column(name = "circunferencia_abdominal")
	private Float circunferenciaAbdominal;

    // bioimpedancia //

    @Column(name = "valores_bioimpedancia", nullable = true)
    private String valoresBioimpedancia;

    @Column(name = "observacoes_bioimpedancia", nullable = true)
    private String observacoesBioimpedancia;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDateTime.now();
    }

}
