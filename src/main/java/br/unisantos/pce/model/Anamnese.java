package br.unisantos.pce.model;

import java.time.LocalDate;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Anamnese {

	private enum Escolaridade {
		fundamental_completo,
		ensino_medio_completo,
		ensino_superior_incompleto,
		ensino_superior_completo,
		outra;
	}

	private enum Periodo {
		manha,
		tarde,
		noite,
		NA;
	}

	/*
	 * private enum Opcao {
	 * sim,
	 * nao,
	 * as_vezes;
	 * }
	 * 
	 * private enum Companhia {
	 * sozinho,
	 * acompanhado;
	 * }
	 */

	private enum FaixaRenda {
		menos_de_1_salario_minimo,
		de_1_a_2_salarios_minimos,
		de_3_a_5_salarios_minimos,
		mais_de_5_salarios_minimos,
		nao_sei;
	}

	private enum FrequenciaEvacuacao {
		diaria,
		alternada,
		tres_vezes_por_semana,
		menos_de_3_vezes_por_semana;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "paciente_id", nullable = false)
    private Integer pacienteId;

	@Column(name = "escolaridade", nullable = false)
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;

	@Column(name = "periodo_estudo", nullable = false)
	@Enumerated(EnumType.STRING)
	private Periodo periodoEstudo;

	@Column(name = "lanche_estudo", nullable = false)
	private Boolean lancheEstudo;

	@Column(name = "periodo_trabalho", nullable = false)
	@Enumerated(EnumType.STRING)
	private Periodo periodoTrabalho;

	@Column(name = "lanche_trabalho", nullable = false)
	private Boolean lancheTrabalho;

	@Column(name = "profissao", length = 60, nullable = false)
	private String profissao;

	@Column(name = "renda_familiar", nullable = false)
	@Enumerated(EnumType.STRING)
	private FaixaRenda rendaFamiliar;

	@Column(name = "num_pessoas_domicilio", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	private Integer numPessoasDomicilio;

	@Column(name = "motivo", columnDefinition = "TEXT", nullable = false)
	private String motivo;

	@Column(name = "apresenta_doenca", columnDefinition = "TEXT")
	private String apresentaDoenca;

	@Column(name = "antecedentes_familiares", columnDefinition = "TEXT")
	private String antecedentesFamiliares;

	@Column(name = "medicamentos_continuos", columnDefinition = "TEXT")
	private String medicamentosContinuos;

	@Column(name = "suplementos_complementos")
	private String suplementosComplimentos;

	@Column(name = "frequencia_evacuacao", nullable = false)
	@Enumerated(EnumType.STRING)
	private FrequenciaEvacuacao frequenciaEvacuacao;

	@Column(name = "consistencia_evacuacao", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	private Integer consistenciaEvacuacao;

	@Column(name = "pratica_atv_fisica", nullable = false)
	private Boolean praticaAtvFisica;

	@Column(name = "atv_fisica")
	private String atvFisica;

	/*
	 * @Column(name = "cafe_da_manha")
	 * private String cafeDaManha;
	 * 
	 * @Column(name = "lanche_da_manha")
	 * private String lancheDaManha;
	 * 
	 * @Column(name = "almoco")
	 * private String almoco;
	 * 
	 * @Column(name = "lanche_da_tarde")
	 * private String lancheDaTarde;
	 * 
	 * @Column(name = "jantar")
	 * private String jantar;
	 * 
	 * @Column(name = "ceia")
	 * private String ceia;
	 * 
	 * @Column(name = "legumes_cenoura")
	 * private String legumesCenoura;
	 * 
	 * @Column(name = "legumes_beterraba")
	 * private String legumesBeterraba;
	 * 
	 * @Column(name = "legumes_berinjela")
	 * private String legumesBerinjela;
	 * 
	 * @Column(name = "legumes_pepino")
	 * private String legumesPepino;
	 * 
	 * @Column(name = "legumes_abobrinha")
	 * private String legumesAbobrinha;
	 * 
	 * @Column(name = "legumes_chuchu")
	 * private String legumesChuchu;
	 * 
	 * @Column(name = "legumes_tomate")
	 * private String legumesTomate;
	 * 
	 * @Column(name = "verduras_acelga")
	 * private String verdurasAcelga;
	 * 
	 * @Column(name = "verduras_agriao")
	 * private String verdurasAgriao;
	 * 
	 * @Column(name = "verduras_alface")
	 * private String verdurasAlface;
	 * 
	 * @Column(name = "verduras_brocolis")
	 * private String verdurasBrocolis;
	 * 
	 * @Column(name = "verduras_chicoria")
	 * private String verdurasChicoria;
	 * 
	 * @Column(name = "verduras_couve_manteiga")
	 * private String verdurasCouveManteiga;
	 * 
	 * @Column(name = "verduras_couve_flor")
	 * private String verdurasCouveFlor;
	 * 
	 * @Column(name = "verduras_espinafre")
	 * private String verdurasEspinafre;
	 * 
	 * @Column(name = "verduras_rucula")
	 * private String verdurasRucula;
	 * 
	 * @Column(name = "frutas_c_laranja")
	 * private String frutasCLaranja;
	 * 
	 * @Column(name = "frutas_c_tangerina")
	 * private String frutasCTangerina;
	 * 
	 * @Column(name = "frutas_c_limao")
	 * private String frutasCLimao;
	 * 
	 * @Column(name = "frutas_c_abacaxi")
	 * private String frutasCAbacaxi;
	 * 
	 * @Column(name = "frutas_c_acerola")
	 * private String frutasCAcerola;
	 * 
	 * @Column(name = "frutas_c_morango")
	 * private String frutasCMorango;
	 * 
	 * @Column(name = "frutas_c_kiwi")
	 * private String frutasCKiwi;
	 * 
	 * @Column(name = "frutas_c_maracuja")
	 * private String frutasCMaracuja;
	 * 
	 * @Column(name = "demais_frutas_banana")
	 * private String demaisFrutasBanana;
	 * 
	 * @Column(name = "demais_frutas_goiaba")
	 * private String demaisFrutasGoiaba;
	 * 
	 * @Column(name = "demais_frutas_maca")
	 * private String demaisFrutasMaca;
	 * 
	 * @Column(name = "demais_frutas_mamao")
	 * private String demaisFrutasMamao;
	 * 
	 * @Column(name = "demais_frutas_manga")
	 * private String demaisFrutasManga;
	 * 
	 * @Column(name = "demais_frutas_melancia")
	 * private String demaisFrutasMelancia;
	 * 
	 * @Column(name = "demais_frutas_melao")
	 * private String demaisFrutasMelao;
	 * 
	 * @Column(name = "demais_frutas_pera")
	 * private String demaisFrutasPera;
	 * 
	 * @Column(name = "demais_frutas_pessego")
	 * private String demaisFrutasPessego;
	 * 
	 * @Column(name = "demais_frutas_uva")
	 * private String demaisFrutasUva;
	 * 
	 * @Column(name = "leguminosas_feijao")
	 * private String leguminosasFeijao;
	 * 
	 * @Column(name = "leguminosas_lentilha")
	 * private String leguminosasLentilha;
	 * 
	 * @Column(name = "leguminosas_ervilha")
	 * private String leguminosasErvilha;
	 * 
	 * @Column(name = "leguminosas_soja")
	 * private String leguminosasSoja;
	 * 
	 * @Column(name = "leguminosas_grao_de_bico")
	 * private String leguminosasGraoDeBico;
	 * 
	 * @Column(name = "leguminosas_vagem")
	 * private String leguminosasVagem;
	 * 
	 * @Column(name = "carnes_bovina")
	 * private String carnesBovina;
	 * 
	 * @Column(name = "carnes_suina")
	 * private String carnesSuina;
	 * 
	 * @Column(name = "carnes_aves")
	 * private String carnesAves;
	 * 
	 * @Column(name = "carnes_peixe")
	 * private String carnesPeixe;
	 * 
	 * @Column(name = "frutos_do_mar")
	 * private String frutosDoMar;
	 * 
	 * @Column(name = "ovo")
	 * private String ovo;
	 * 
	 * @Column(name = "arroz_branco_polido")
	 * private String arrozBrancoPolido;
	 * 
	 * @Column(name = "arroz_integral")
	 * private String arrozIntegral;
	 * 
	 * @Column(name = "lacteos_leite_integral_desnatado_semi")
	 * private String lacteosLeiteIntegralDesnatadoSemi;
	 * 
	 * @Column(name = "lacteos_leite_sem_lactose")
	 * private String lacteosLeiteSemLactose;
	 * 
	 * @Column(name = "lacteos_queijos")
	 * private String lacteosQueijosPedacoOuFatia;
	 * 
	 * @Column(name = "lacteos_iogurtes")
	 * private String lacteosIogurtes;
	 * 
	 * @Column(name = "cereais_aveia")
	 * private String cereaisAveia;
	 * 
	 * @Column(name = "cereais_granola_in_natura")
	 * private String cereaisGranolaInNatura;
	 * 
	 * @Column(name = "cereais_quinoa")
	 * private String cereaisQuinoa;
	 * 
	 * @Column(name = "cereais_linhaca")
	 * private String cereaisLinhaca;
	 * 
	 * @Column(name = "cereais_chia")
	 * private String cereaisChia;
	 * 
	 * @Column(name = "paes_frances_media_normal")
	 * private String paesFrancesMediaNormal;
	 * 
	 * @Column(name = "paes_frances_media_integral")
	 * private String paesFrancesMediaIntegral;
	 * 
	 * @Column(name = "paes_forma")
	 * private String paesForma;
	 * 
	 * @Column(name = "paes_forma_integral")
	 * private String paesFormaIntegral;
	 * 
	 * @Column(name = "paes_cara")
	 * private String paesCara;
	 * 
	 * @Column(name = "pastas_requeijao")
	 * private String pastasRequeijao;
	 * 
	 * @Column(name = "pastas_margarina")
	 * private String pastasMargarina;
	 * 
	 * @Column(name = "pastas_manteiga")
	 * private String pastasManteiga;
	 * 
	 * @Column(name = "pastas_ricota")
	 * private String pastasRicota;
	 * 
	 * @Column(name = "pastas_cottage")
	 * private String pastasCottage;
	 * 
	 * @Column(name = "pastas_doce_de_leite")
	 * private String pastasDoceDeLeite;
	 * 
	 * @Column(name = "pastas_creme_de_avela")
	 * private String pastasCremeDeAvela;
	 * 
	 * @Column(name = "pastas_geleia")
	 * private String pastasGeleia;
	 * 
	 * @Column(name = "salgados_mistinho_esfiha")
	 * private String salgadosMistinhoEsfiha;
	 * 
	 * @Column(name = "salgados_coxinha_croquete")
	 * private String salgadosCoxinhaCroquete;
	 * 
	 * @Column(name = "salgados_empadas")
	 * private String salgadosEmpadas;
	 * 
	 * @Column(name = "salgados_pao_de_queijo")
	 * private String salgadosPaoDeQueijo;
	 * 
	 * @Column(name = "ultraprocessados_salgadinho_de_pacote")
	 * private String ultraprocessadosSalgadinhoDePacote;
	 * 
	 * @Column(name = "ultraprocessados_biscoito_salgado")
	 * private String ultraprocessadosBiscoitoSalgado;
	 * 
	 * @Column(name = "ultraprocessados_biscoito_doce")
	 * private String ultraprocessadosBiscoitoDoce;
	 * 
	 * @Column(name = "ultraprocessados_chocolate")
	 * private String ultraprocessadosChocolate;
	 * 
	 * @Column(name = "ultraprocessados_refrigerante")
	 * private String ultraprocessadosRefrigerante;
	 * 
	 * @Column(name = "ultraprocessados_suco_em_po_caixinha")
	 * private String ultraprocessadosSucoEmPoCaixinha;
	 * 
	 * @Column(name = "ultraprocessados_pratos_prontos_congelados")
	 * private String ultraprocessadosPratosProntosCongelados;
	 * 
	 * @Column(name = "ultraprocessados_macarrao_instantaneo")
	 * private String ultraprocessadosMacarraoInstantaneo;
	 * 
	 * @Column(name = "ultraprocessados_bolinho")
	 * private String ultraprocessadosBolinho;
	 * 
	 * @Column(name = "ultraprocessados_fast_food")
	 * private String ultraprocessadosFastFood;
	 * 
	 * @Column(name = "embutidos_salame")
	 * private String embutidosSalame;
	 * 
	 * @Column(name = "embutidos_presunto")
	 * private String embutidosPresunto;
	 * 
	 * @Column(name = "embutidos_apresuntado_mortadela")
	 * private String embutidosApresuntadoMortadela;
	 * 
	 * @Column(name = "embutidos_linguica_toscana_calabresa")
	 * private String embutidosLinguicaToscanaCalabresa;
	 * 
	 * @Column(name = "embutidos_salsicha")
	 * private String embutidosSalsicha;
	 * 
	 * @Column(name = "embutidos_peito_de_peru")
	 * private String embutidosPeitoDePeru;
	 * 
	 * @Column(name = "embutidos_rosbife")
	 * private String embutidosRosbife;
	 * 
	 * @Column(name = "embutidos_nuggets")
	 * private String embutidosNuggets;
	 * 
	 * @Column(name = "embutidos_hamburguer_tradicional")
	 * private String embutidosHamburguerTradicional;
	 * 
	 * @Column(name = "acucares_acucar")
	 * private String acucaresAcucar;
	 * 
	 * @Column(name = "acucares_adocante")
	 * private String acucaresAdocante;
	 * 
	 * @Column(name = "acucares_mel_melado")
	 * private String acucaresMelMelado;
	 * 
	 * @Column(name = "acucares_produtos_confeitaria")
	 * private String acucaresProdutosConfeitaria;
	 * 
	 * @Column(name = "acucares_guloseimas")
	 * private String acucaresGuloseimas;
	 * 
	 * @Column(name = "acucares_achocolatados")
	 * private String acucaresAchocolatados;
	 * 
	 * @Column(name = "molhos_ketchup")
	 * private String molhosKetchup;
	 * 
	 * @Column(name = "molhos_mostarda")
	 * private String molhosMostarda;
	 * 
	 * @Column(name = "molhos_shoyu")
	 * private String molhosShoyu;
	 * 
	 * @Column(name = "molhos_tare")
	 * private String molhosTare;
	 * 
	 * @Column(name = "molhos_maionese")
	 * private String molhosMaionese;
	 * 
	 * @Column(name = "quem_cozinha")
	 * private String quemCozinha;
	 * 
	 * @Column(name = "necessidade_comer_estressado_ansioso_triste")
	 * 
	 * @Enumerated(EnumType.STRING)
	 * private Opcao necessidadeComerEstressadoAnsiosoTriste;
	 * 
	 * @Column(name = "realiza_refeicoes_sozinho_acompanhado")
	 * 
	 * @Enumerated(EnumType.STRING)
	 * private Companhia realizaRefeicoesSozinhoAcompanhado;
	 * 
	 * @Column(name = "excesso_alimentos_nao_saudaveis_sintomas")
	 * private String excessoAlimentosNaoSaudaveisSintomas;
	 * 
	 * @Column(name = "dificuldade_rotina_alimentar_saudavel")
	 * private String dificuldadeRotinaAlimentarSaudavel;
	 * 
	 * @Column(name = "necessidade_consolo_alimentar")
	 * private Opcao necessidadeConsoloAlimentar;
	 * 
	 * @Column(name = "dificuldade_parar_de_comer")
	 * private Opcao dificuldadePararDeComer;
	 * 
	 * @Column(name = "frequencia_fome_fisiologica")
	 * private String frequenciaFomeFisiologica;
	 * 
	 * @Column(name = "frequencia_necessidade_emocional_comer")
	 * private String frequenciaNecessidadeEmocionalComer;
	 * 
	 * @Column(name = "nao_modificar_plano_alimentar")
	 * private String naoModificarPlanoAlimentar;
	 * 
	 * @Column(name = "aversao_alimentar")
	 * private String aversaoAlimentar;
	 * 
	 * @Column(name = "tolera_alimentos_proteina_animal")
	 * private boolean toleraAlimentosProteinaAnimal;
	 * 
	 * @Column(name = "alergia_intolerancias_alimentares")
	 * private String alergiaIntoleranciasAlimentares;
	 * 
	 * @Column(name = "nota_saciedade_pos_refeicoes", columnDefinition =
	 * "TINYINT UNSIGNED", nullable = false)
	 * private int notaSaciedadePosRefeicoes;
	 * 
	 * @Column(name = "nota_humor_pos_refeicoes", columnDefinition =
	 * "TINYINT UNSIGNED", nullable = false)
	 * private Integer notaHumorPosRefeicoes;
	 * 
	 * @Column(name = "peso_atual", nullable = false)
	 * private float pesoAtual;
	 * 
	 * @Column(name = "estatura", nullable = false)
	 * private float estaturaM;
	 * 
	 * @Column(name = "imc", nullable = false)
	 * private float imc;
	 * 
	 * @Column(name = "cb", nullable = false)
	 * private float cb;
	 * 
	 * @Column(name = "dct", nullable = false)
	 * private float dct;
	 * 
	 * @Column(name = "dcb", nullable = false)
	 * private float dcb;
	 * 
	 * @Column(name = "dcse", nullable = false)
	 * private float dcse;
	 * 
	 * @Column(name = "dcsi", nullable = false)
	 * private float dcsi;
	 * 
	 * @Column(name = "somatoria_4_dobras", nullable = false)
	 * private float somatoria4Dobras;
	 * 
	 * @Column(name = "porcentagem_gordura_corporal_somatoria_4_dobras", nullable =
	 * false)
	 * private float porcentagemGorduraCorporalSomatoria4Dobras;
	 * 
	 * @Column(name = "peso_gordura", nullable = false)
	 * private float pesoGordura;
	 * 
	 * @Column(name = "peso_massa_magra", nullable = false)
	 * private float pesoMassaMagra;
	 * 
	 * @Column(name = "total_agua", nullable = false)
	 * private float totalAgua;
	 * 
	 * @Column(name = "porcentagem_agua_massa_magra", nullable = false)
	 * private float porcentagemAguaMassaMagra;
	 * 
	 * @Column(name = "resistencia", nullable = false)
	 * private float resistencia;
	 * 
	 * @Column(name = "angulo_de_fase", nullable = false)
	 * private float AnguloDeFase;
	 * 
	 * @Column(name = "circunferencia_cintura", nullable = false)
	 * private float circunferenciaCintura;
	 * 
	 * @Column(name = "circunferencia_quadril", nullable = false)
	 * private float circunferenciaQuadril;
	 * 
	 * @Column(name = "circunferencia_panturrilha", nullable = false)
	 * private float circunferenciaPanturrilha;
	 * 
	 * @Column(name = "emap_direita", nullable = false)
	 * private float emapDireita;
	 * 
	 * @Column(name = "emap_esquerda", nullable = false)
	 * private float emapEsquerda;
	 * 
	 * @Column(name = "forca_preencao_manual_esquerda")
	 * private int forcaPreencaoManualEsquerda;
	 * 
	 * @Column(name = "metas")
	 * private String metas;
	 */

	@Column(name = "criado_em", nullable = false)
	private LocalDate criadoEm;

	@PrePersist
	protected void onCreate() {
		criadoEm = LocalDate.now();
	}

}