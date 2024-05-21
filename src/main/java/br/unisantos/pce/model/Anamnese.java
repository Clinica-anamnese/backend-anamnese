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
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
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

	private enum Opcao {
		sim,
		nao,
		as_vezes;
	}

	private enum Companhia {
		sozinho,
		acompanhado;
	}

	private enum FaixaRenda {
		menos_de_1_salario_minimo,
		de_1_a_2_salarios_minimos,
		de_3_a_5_salarios_minimos,
		mais_de_5_salarios_minimos,
		nao_sei;
	}

	private enum Frequencia {
		diario,
		semanal,
		mensal,
		nao;
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

	@Column(name = "paciente_nome", length = 60, nullable = false)
	private String pacienteNome;

	@Column(name = "usuario_id", nullable = false)
	private Integer usuarioId;

	@Column(name = "usuario_nome", length = 60, nullable = false)
	private String usuarioNome;

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

	@Column(name = "profissao", length = 60)
	private String profissao;

	// caracteristicas socioeconomicas //

	@Column(name = "renda_familiar", nullable = false)
	@Enumerated(EnumType.STRING)
	private FaixaRenda rendaFamiliar;

	@Column(name = "num_pessoas_domicilio", columnDefinition = "TINYINT", nullable = false)
	private Integer numPessoasDomicilio;

	// hirtoria clinica //

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

	@Column(name = "consistencia_evacuacao", columnDefinition = "TINYINT", nullable = false)
	private Integer consistenciaEvacuacao;

	@Column(name = "pratica_atv_fisica", nullable = false)
	private Boolean praticaAtvFisica;

	@Column(name = "atv_fisica")
	private String atvFisica;

	@Column(name = "cafe_da_manha")
	private String cafeDaManha;

	@Column(name = "lanche_da_manha")
	private String lancheDaManha;

	@Column(name = "almoco")
	private String almoco;

	@Column(name = "lanche_da_tarde")
	private String lancheDaTarde;

	@Column(name = "jantar")
	private String jantar;

	@Column(name = "ceia")
	private String ceia;

	// recordatorio alimentar //

	@Column(name = "legumes_cenoura", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesCenoura;

	@Column(name = "legumes_beterraba", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesBeterraba;

	@Column(name = "legumes_berinjela", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesBerinjela;

	@Column(name = "legumes_pepino", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesPepino;

	@Column(name = "legumes_abobrinha", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesAbobrinha;

	@Column(name = "legumes_chuchu", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesChuchu;

	@Column(name = "legumes_tomate", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia legumesTomate;

	@Column(name = "verduras_acelga", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasAcelga;

	@Column(name = "verduras_agriao", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasAgriao;

	@Column(name = "verduras_alface", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasAlface;

	@Column(name = "verduras_brocolis", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasBrocolis;

	@Column(name = "verduras_chicoria", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasChicoria;

	@Column(name = "verduras_couve_manteiga", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasCouveManteiga;

	@Column(name = "verduras_couve_flor", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasCouveFlor;

	@Column(name = "verduras_espinafre", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasEspinafre;

	@Column(name = "verduras_rucula", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia verdurasRucula;

	@Column(name = "frutas_c_laranja", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCLaranja;

	@Column(name = "frutas_c_tangerina", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCTangerina;

	@Column(name = "frutas_c_limao", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCLimao;

	@Column(name = "frutas_c_abacaxi", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCAbacaxi;

	@Column(name = "frutas_c_acerola", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCAcerola;

	@Column(name = "frutas_c_morango", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCMorango;

	@Column(name = "frutas_c_kiwi", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCKiwi;

	@Column(name = "frutas_c_maracuja", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutasCMaracuja;

	@Column(name = "demais_frutas_banana", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasBanana;

	@Column(name = "demais_frutas_goiaba", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasGoiaba;

	@Column(name = "demais_frutas_maca", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasMaca;

	@Column(name = "demais_frutas_mamao", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasMamao;

	@Column(name = "demais_frutas_manga", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasManga;

	@Column(name = "demais_frutas_melancia", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasMelancia;

	@Column(name = "demais_frutas_melao", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasMelao;

	@Column(name = "demais_frutas_pera", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasPera;

	@Column(name = "demais_frutas_pessego", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasPessego;

	@Column(name = "demais_frutas_uva", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia demaisFrutasUva;

	@Column(name = "leguminosas_feijao", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasFeijao;

	@Column(name = "leguminosas_lentilha", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasLentilha;

	@Column(name = "leguminosas_ervilha", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasErvilha;

	@Column(name = "leguminosas_soja", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasSoja;

	@Column(name = "leguminosas_grao_de_bico", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasGraoDeBico;

	@Column(name = "leguminosas_vagem", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia leguminosasVagem;

	@Column(name = "carnes_bovina", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia carnesBovina;

	@Column(name = "carnes_suina", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia carnesSuina;

	@Column(name = "carnes_aves", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia carnesAves;

	@Column(name = "carnes_peixe", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia carnesPeixe;

	@Column(name = "frutos_do_mar", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia frutosDoMar;

	@Column(name = "ovo", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ovo;

	@Column(name = "arroz_branco_polido", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia arrozBrancoPolido;

	@Column(name = "arroz_integral", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia arrozIntegral;

	@Column(name = "lacteos_leite_integral_desnatado_semi", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia lacteosLeiteIntegralDesnatadoSemi;

	@Column(name = "lacteos_leite_sem_lactose", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia lacteosLeiteSemLactose;

	@Column(name = "lacteos_queijos", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia lacteosQueijosPedacoOuFatia;

	@Column(name = "lacteos_iogurtes", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia lacteosIogurtes;

	@Column(name = "cereais_aveia", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia cereaisAveia;

	@Column(name = "cereais_granola_in_natura", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia cereaisGranolaInNatura;

	@Column(name = "cereais_quinoa", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia cereaisQuinoa;

	@Column(name = "cereais_linhaca", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia cereaisLinhaca;

	@Column(name = "cereais_chia", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia cereaisChia;

	@Column(name = "paes_frances_media_normal", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia paesFrancesMediaNormal;

	@Column(name = "paes_frances_media_integral", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia paesFrancesMediaIntegral;

	@Column(name = "paes_forma", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia paesForma;

	@Column(name = "paes_forma_integral", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia paesFormaIntegral;

	@Column(name = "paes_cara", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia paesCara;

	@Column(name = "pastas_requeijao", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasRequeijao;

	@Column(name = "pastas_margarina", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasMargarina;

	@Column(name = "pastas_manteiga", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasManteiga;

	@Column(name = "pastas_ricota", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasRicota;

	@Column(name = "pastas_cottage", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasCottage;

	@Column(name = "pastas_doce_de_leite", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasDoceDeLeite;

	@Column(name = "pastas_creme_de_avela", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasCremeDeAvela;

	@Column(name = "pastas_geleia", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia pastasGeleia;

	@Column(name = "salgados_mistinho_esfiha", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia salgadosMistinhoEsfiha;

	@Column(name = "salgados_coxinha_croquete", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia salgadosCoxinhaCroquete;

	@Column(name = "salgados_empadas", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia salgadosEmpadas;

	@Column(name = "salgados_pao_de_queijo", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia salgadosPaoDeQueijo;

	@Column(name = "ultraprocessados_salgadinho_de_pacote", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosSalgadinhoDePacote;

	@Column(name = "ultraprocessados_biscoito_salgado", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosBiscoitoSalgado;

	@Column(name = "ultraprocessados_biscoito_doce", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosBiscoitoDoce;

	@Column(name = "ultraprocessados_chocolate", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosChocolate;

	@Column(name = "ultraprocessados_refrigerante", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosRefrigerante;

	@Column(name = "ultraprocessados_suco_em_po_caixinha", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosSucoEmPoCaixinha;

	@Column(name = "ultraprocessados_pratos_prontos_congelados", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosPratosProntosCongelados;

	@Column(name = "ultraprocessados_macarrao_instantaneo", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosMacarraoInstantaneo;

	@Column(name = "ultraprocessados_bolinho", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosBolinho;

	@Column(name = "ultraprocessados_fast_food", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia ultraprocessadosFastFood;

	@Column(name = "embutidos_salame", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosSalame;

	@Column(name = "embutidos_presunto", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosPresunto;

	@Column(name = "embutidos_apresuntado_mortadela", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosApresuntadoMortadela;

	@Column(name = "embutidos_linguica_toscana_calabresa", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosLinguicaToscanaCalabresa;

	@Column(name = "embutidos_salsicha", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosSalsicha;

	@Column(name = "embutidos_peito_de_peru", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosPeitoDePeru;

	@Column(name = "embutidos_rosbife", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosRosbife;

	@Column(name = "embutidos_nuggets", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosNuggets;

	@Column(name = "embutidos_hamburguer_tradicional", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia embutidosHamburguerTradicional;

	@Column(name = "acucares_acucar", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia acucaresAcucar;

	@Column(name = "acucares_adocante", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia acucaresAdocante;

	@Column(name = "acucares_mel_melado", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia acucaresMelMelado;

	@Column(name = "acucares_produtos_confeitaria", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia acucaresProdutosConfeitaria;

	@Column(name = "acucares_guloseimas", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia acucaresGuloseimas;

	@Column(name = "acucares_achocolatados", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia acucaresAchocolatados;

	@Column(name = "molhos_ketchup", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia molhosKetchup;

	@Column(name = "molhos_mostarda", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia molhosMostarda;

	@Column(name = "molhos_shoyu", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia molhosShoyu;

	@Column(name = "molhos_tare", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia molhosTare;

	@Column(name = "molhos_maionese", nullable = true)
	@Enumerated(EnumType.STRING)
	private Frequencia molhosMaionese;

	// comportamento alimentar //

	@Column(name = "quem_cozinha")
	private String quemCozinha;

	@Column(name = "necessidade_comer_estressado_ansioso_triste")
	@Enumerated(EnumType.STRING)
	private Opcao necessidadeComerEstressadoAnsiosoTriste;

	@Column(name = "realiza_refeicoes_sozinho_acompanhado")
	@Enumerated(EnumType.STRING)
	private Companhia realizaRefeicoesSozinhoAcompanhado;

	@Column(name = "excesso_alimentos_nao_saudaveis_sintomas")
	private String excessoAlimentosNaoSaudaveisSintomas;

	@Column(name = "dificuldade_rotina_alimentar_saudavel")
	private String dificuldadeRotinaAlimentarSaudavel;

	@Column(name = "necessidade_consolo_alimentar")
	@Enumerated(EnumType.STRING)
	private Opcao necessidadeConsoloAlimentar;

	@Column(name = "dificuldade_parar_de_comer")
	@Enumerated(EnumType.STRING)
	private Opcao dificuldadePararDeComer;

	@Column(name = "frequencia_fome_fisiologica")
	private String frequenciaFomeFisiologica;

	@Column(name = "frequencia_necessidade_emocional_comer")
	private String frequenciaNecessidadeEmocionalComer;

	@Column(name = "nao_modificar_plano_alimentar")
	private String naoModificarPlanoAlimentar;

	@Column(name = "aversao_alimentar")
	private String aversaoAlimentar;

	@Column(name = "tolera_alimentos_proteina_animal")
	private String toleraAlimentosProteinaAnimal;

	@Column(name = "alergia_intolerancias_alimentares")
	private String alergiaIntoleranciasAlimentares;

	@Column(name = "nota_saciedade_pos_refeicoes", columnDefinition = "TINYINT", nullable = false)
	private Integer notaSaciedadePosRefeicoes;

	@Column(name = "nota_humor_pos_refeicoes", columnDefinition = "TINYINT", nullable = false)
	private Integer notaHumorPosRefeicoes;

	// avaliacao antropometria //

	@Column(name = "peso_atual")
	private float pesoAtual;

	@Column(name = "estatura")
	private float estaturaM;

	@Column(name = "imc")
	private float imc;

	@Column(name = "cb")
	private float cb;

	@Column(name = "dct")
	private float dct;

	@Column(name = "dcb")
	private float dcb;

	@Column(name = "dcse")
	private float dcse;

	@Column(name = "dcsi")
	private float dcsi;

	@Column(name = "somatoria_4_dobras")
	private float somatoria4Dobras;

	@Column(name = "porcentagem_gordura_corporal_somatoria_4_dobras")
	private float porcentagemGorduraCorporalSomatoria4Dobras;

	@Column(name = "peso_gordura")
	private float pesoGordura;

	@Column(name = "peso_massa_magra")
	private float pesoMassaMagra;

	@Column(name = "total_agua")
	private float totalAgua;

	@Column(name = "porcentagem_agua_massa_magra")
	private float porcentagemAguaMassaMagra;

	@Column(name = "resistencia")
	private float resistencia;

	@Column(name = "reactancia")
	private float reactancia;

	@Column(name = "angulo_de_fase")
	private float anguloDeFase;

	@Column(name = "circunferencia_cintura")
	private float circunferenciaCintura;

	@Column(name = "circunferencia_quadril")
	private float circunferenciaQuadril;

	@Column(name = "circunferencia_panturrilha")
	private float circunferenciaPanturrilha;

	@Column(name = "emap_direita")
	private float emapDireita;

	@Column(name = "emap_esquerda")
	private float emapEsquerda;

	@Column(name = "forca_preencao_manual_direita")
	private Integer forcaPreencaoManualDireita;

	@Column(name = "forca_preencao_manual_esquerda")
	private Integer forcaPreencaoManualEsquerda;

	// metas para retorno //

	@Column(name = "metas")
	private String metas;

	@Column(name = "criado_em", nullable = false)
	private LocalDate criadoEm;

	@PrePersist
	protected void onCreate() {
		criadoEm = LocalDate.now();
	}

}