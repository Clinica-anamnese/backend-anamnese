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
public class AnamneseAdulto {

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

/* 	private enum Opcao {
		sim,
		nao,
		as_vezes;
	}

	private enum Companhia {
		sozinho,
		acompanhado;
	} */

	public enum FaixaRenda {
		menos_de_1_salario_minimo,
		de_1_a_2_salarios_minimos,
		de_3_a_5_salarios_minimos,
		mais_de_5_salarios_minimos,
		nao_sei;
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

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

	@Column(name = "renda_familiar", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	@Enumerated(EnumType.STRING)
	private FaixaRenda rendaFamiliar;

	@Column(name = "num_pessoas_domicilio", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	private Integer numPessoasDomicilio;

	@Column(name = "motivo", length = 60, nullable = false)
	private String motivo;

	@Column(name = "apresenta_doenca", length = 60)
	private String apresentaDoenca;

	@Column(name = "antecedentes_familiares", length = 60)
	private String antecedentesFamiliares;

	@Column(name = "medicamentos_continuos", length = 60)
	private String medicamentosContinuos;

	@Column(name = "suplementos_complementos", length = 60)
	private String suplementosComplimentos;

	@Column(name = "frequencia_evacuacao", nullable = false, length = 60)
	private String frequenciaEvacuacao;

	@Column(name = "consistencia_evacuacao", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	private Integer consistenciaEvacuacao;

	@Column(name = "pratica_atv_fisica", nullable = false)
	private Boolean praticaAtvFisica;

	@Column(name = "atv_fisica", nullable = false, length = 60)
	private String atvFisica;

/* 	@Column(name = "cafe_da_manha", length = 60)
	private String cafeDaManha;

	@Column(name = "lanche_da_manha", length = 60)
	private String lancheDaManha;

	@Column(name = "almoco", length = 60)
	private String almoco;

	@Column(name = "lanche_da_tarde", length = 60)
	private String lancheDaTarde;

	@Column(name = "jantar", length = 60)
	private String jantar;

	@Column(name = "ceia", length = 60)
	private String ceia;

	@Column(name = "legumes_cenoura", length = 60)
	private String legumesCenoura;

	@Column(name = "legumes_beterraba", length = 60)
	private String legumesBeterraba;

	@Column(name = "legumes_berinjela", length = 60)
	private String legumesBerinjela;

	@Column(name = "legumes_pepino", length = 60)
	private String legumesPepino;

	@Column(name = "legumes_abobrinha", length = 60)
	private String legumesAbobrinha;

	@Column(name = "legumes_chuchu", length = 60)
	private String legumesChuchu;

	@Column(name = "legumes_tomate", length = 60)
	private String legumesTomate;

	@Column(name = "verduras_acelga", length = 60)
	private String verdurasAcelga;

	@Column(name = "verduras_agriao", length = 60)
	private String verdurasAgriao;

	@Column(name = "verduras_alface", length = 60)
	private String verdurasAlface;

	@Column(name = "verduras_brocolis", length = 60)
	private String verdurasBrocolis;

	@Column(name = "verduras_chicoria", length = 60)
	private String verdurasChicoria;

	@Column(name = "verduras_couve_manteiga", length = 60)
	private String verdurasCouveManteiga;

	@Column(name = "verduras_couve_flor", length = 60)
	private String verdurasCouveFlor;

	@Column(name = "verduras_espinafre", length = 60)
	private String verdurasEspinafre;

	@Column(name = "verduras_rucula", length = 60)
	private String verdurasRucula;

	@Column(name = "frutas_c_laranja", length = 60)
	private String frutasCLaranja;

	@Column(name = "frutas_c_tangerina", length = 60)
	private String frutasCTangerina;

	@Column(name = "frutas_c_limao", length = 60)
	private String frutasCLimao;

	@Column(name = "frutas_c_abacaxi", length = 60)
	private String frutasCAbacaxi;

	@Column(name = "frutas_c_acerola", length = 60)
	private String frutasCAcerola;

	@Column(name = "frutas_c_morango", length = 60)
	private String frutasCMorango;

	@Column(name = "frutas_c_kiwi", length = 60)
	private String frutasCKiwi;

	@Column(name = "frutas_c_maracuja", length = 60)
	private String frutasCMaracuja;

	@Column(name = "demais_frutas_banana", length = 60)
	private String demaisFrutasBanana;

	@Column(name = "demais_frutas_goiaba", length = 60)
	private String demaisFrutasGoiaba;

	@Column(name = "demais_frutas_maca", length = 60)
	private String demaisFrutasMaca;

	@Column(name = "demais_frutas_mamao", length = 60)
	private String demaisFrutasMamao;

	@Column(name = "demais_frutas_manga", length = 60)
	private String demaisFrutasManga;

	@Column(name = "demais_frutas_melancia", length = 60)
	private String demaisFrutasMelancia;

	@Column(name = "demais_frutas_melao", length = 60)
	private String demaisFrutasMelao;

	@Column(name = "demais_frutas_pera", length = 60)
	private String demaisFrutasPera;

	@Column(name = "demais_frutas_pessego", length = 60)
	private String demaisFrutasPessego;

	@Column(name = "demais_frutas_uva", length = 60)
	private String demaisFrutasUva;

	@Column(name = "leguminosas_feijao", length = 60)
	private String leguminosasFeijao;

	@Column(name = "leguminosas_lentilha", length = 60)
	private String leguminosasLentilha;

	@Column(name = "leguminosas_ervilha", length = 60)
	private String leguminosasErvilha;

	@Column(name = "leguminosas_soja", length = 60)
	private String leguminosasSoja;

	@Column(name = "leguminosas_grao_de_bico", length = 60)
	private String leguminosasGraoDeBico;

	@Column(name = "leguminosas_vagem", length = 60)
	private String leguminosasVagem;

	@Column(name = "carnes_bovina", length = 60)
	private String carnesBovina;

	@Column(name = "carnes_suina", length = 60)
	private String carnesSuina;

	@Column(name = "carnes_aves", length = 60)
	private String carnesAves;

	@Column(name = "carnes_peixe", length = 60)
	private String carnesPeixe;

	@Column(name = "frutos_do_mar", length = 60)
	private String frutosDoMar;

	@Column(name = "ovo", length = 60)
	private String ovo;

	@Column(name = "arroz_branco_polido", length = 60)
	private String arrozBrancoPolido;

	@Column(name = "arroz_integral", length = 60)
	private String arrozIntegral;

	@Column(name = "lacteos_leite_integral_desnatado_semi", length = 60)
	private String lacteosLeiteIntegralDesnatadoSemi;

	@Column(name = "lacteos_leite_sem_lactose", length = 60)
	private String lacteosLeiteSemLactose;

	@Column(name = "lacteos_queijos", length = 60)
	private String lacteosQueijosPedacoOuFatia;

	@Column(name = "lacteos_iogurtes", length = 60)
	private String lacteosIogurtes;

	@Column(name = "cereais_aveia", length = 60)
	private String cereaisAveia;

	@Column(name = "cereais_granola_in_natura", length = 60)
	private String cereaisGranolaInNatura;

	@Column(name = "cereais_quinoa", length = 60)
	private String cereaisQuinoa;

	@Column(name = "cereais_linhaca", length = 60)
	private String cereaisLinhaca;

	@Column(name = "cereais_chia", length = 60)
	private String cereaisChia;

	@Column(name = "paes_frances_media_normal", length = 60)
	private String paesFrancesMediaNormal;

	@Column(name = "paes_frances_media_integral", length = 60)
	private String paesFrancesMediaIntegral;

	@Column(name = "paes_forma", length = 60)
	private String paesForma;

	@Column(name = "paes_forma_integral", length = 60)
	private String paesFormaIntegral;

	@Column(name = "paes_cara", length = 60)
	private String paesCara;

	@Column(name = "pastas_requeijao", length = 60)
	private String pastasRequeijao;

	@Column(name = "pastas_margarina", length = 60)
	private String pastasMargarina;

	@Column(name = "pastas_manteiga", length = 60)
	private String pastasManteiga;

	@Column(name = "pastas_ricota", length = 60)
	private String pastasRicota;

	@Column(name = "pastas_cottage", length = 60)
	private String pastasCottage;

	@Column(name = "pastas_doce_de_leite", length = 60)
	private String pastasDoceDeLeite;

	@Column(name = "pastas_creme_de_avela", length = 60)
	private String pastasCremeDeAvela;

	@Column(name = "pastas_geleia", length = 60)
	private String pastasGeleia;

	@Column(name = "salgados_mistinho_esfiha", length = 60)
	private String salgadosMistinhoEsfiha;

	@Column(name = "salgados_coxinha_croquete", length = 60)
	private String salgadosCoxinhaCroquete;

	@Column(name = "salgados_empadas", length = 60)
	private String salgadosEmpadas;

	@Column(name = "salgados_pao_de_queijo", length = 60)
	private String salgadosPaoDeQueijo;

	@Column(name = "ultraprocessados_salgadinho_de_pacote", length = 60)
	private String ultraprocessadosSalgadinhoDePacote;

	@Column(name = "ultraprocessados_biscoito_salgado", length = 60)
	private String ultraprocessadosBiscoitoSalgado;

	@Column(name = "ultraprocessados_biscoito_doce", length = 60)
	private String ultraprocessadosBiscoitoDoce;

	@Column(name = "ultraprocessados_chocolate", length = 60)
	private String ultraprocessadosChocolate;

	@Column(name = "ultraprocessados_refrigerante", length = 60)
	private String ultraprocessadosRefrigerante;

	@Column(name = "ultraprocessados_suco_em_po_caixinha", length = 60)
	private String ultraprocessadosSucoEmPoCaixinha;

	@Column(name = "ultraprocessados_pratos_prontos_congelados", length = 60)
	private String ultraprocessadosPratosProntosCongelados;

	@Column(name = "ultraprocessados_macarrao_instantaneo", length = 60)
	private String ultraprocessadosMacarraoInstantaneo;

	@Column(name = "ultraprocessados_bolinho", length = 60)
	private String ultraprocessadosBolinho;

	@Column(name = "ultraprocessados_fast_food", length = 60)
	private String ultraprocessadosFastFood;

	@Column(name = "embutidos_salame", length = 60)
	private String embutidosSalame;

	@Column(name = "embutidos_presunto", length = 60)
	private String embutidosPresunto;

	@Column(name = "embutidos_apresuntado_mortadela", length = 60)
	private String embutidosApresuntadoMortadela;

	@Column(name = "embutidos_linguica_toscana_calabresa", length = 60)
	private String embutidosLinguicaToscanaCalabresa;

	@Column(name = "embutidos_salsicha", length = 60)
	private String embutidosSalsicha;

	@Column(name = "embutidos_peito_de_peru", length = 60)
	private String embutidosPeitoDePeru;

	@Column(name = "embutidos_rosbife", length = 60)
	private String embutidosRosbife;

	@Column(name = "embutidos_nuggets", length = 60)
	private String embutidosNuggets;

	@Column(name = "embutidos_hamburguer_tradicional", length = 60)
	private String embutidosHamburguerTradicional;

	@Column(name = "acucares_acucar", length = 60)
	private String acucaresAcucar;

	@Column(name = "acucares_adocante", length = 60)
	private String acucaresAdocante;

	@Column(name = "acucares_mel_melado", length = 60)
	private String acucaresMelMelado;

	@Column(name = "acucares_produtos_confeitaria", length = 60)
	private String acucaresProdutosConfeitaria;

	@Column(name = "acucares_guloseimas", length = 60)
	private String acucaresGuloseimas;

	@Column(name = "acucares_achocolatados", length = 60)
	private String acucaresAchocolatados;

	@Column(name = "molhos_ketchup", length = 60)
	private String molhosKetchup;

	@Column(name = "molhos_mostarda", length = 60)
	private String molhosMostarda;

	@Column(name = "molhos_shoyu", length = 60)
	private String molhosShoyu;

	@Column(name = "molhos_tare", length = 60)
	private String molhosTare;

	@Column(name = "molhos_maionese", length = 60)
	private String molhosMaionese;

	@Column(name = "quem_cozinha", length = 60)
	private String quemCozinha;

	@Column(name = "necessidade_comer_estressado_ansioso_triste")
	@Enumerated(EnumType.STRING)
	private Opcao necessidadeComerEstressadoAnsiosoTriste;

	@Column(name = "realiza_refeicoes_sozinho_acompanhado")
	@Enumerated(EnumType.STRING)
	private Companhia realizaRefeicoesSozinhoAcompanhado;

	@Column(name = "excesso_alimentos_nao_saudaveis_sintomas", length = 60)
	private String excessoAlimentosNaoSaudaveisSintomas;

	@Column(name = "dificuldade_rotina_alimentar_saudavel", length = 60)
	private String dificuldadeRotinaAlimentarSaudavel;

	@Column(name = "necessidade_consolo_alimentar")
	private Opcao necessidadeConsoloAlimentar;

	@Column(name = "dificuldade_parar_de_comer")
	private Opcao dificuldadePararDeComer;

	@Column(name = "frequencia_fome_fisiologica", length = 60)
	private String frequenciaFomeFisiologica;

	@Column(name = "frequencia_necessidade_emocional_comer", length = 60)
	private String frequenciaNecessidadeEmocionalComer;

	@Column(name = "nao_modificar_plano_alimentar", length = 60)
	private String naoModificarPlanoAlimentar;

	@Column(name = "aversao_alimentar", length = 60)
	private String aversaoAlimentar;

	@Column(name = "tolera_alimentos_proteina_animal")
	private boolean toleraAlimentosProteinaAnimal;

	@Column(name = "alergia_intolerancias_alimentares", length = 60)
	private String alergiaIntoleranciasAlimentares;

	@Column(name = "nota_saciedade_pos_refeicoes", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	private int notaSaciedadePosRefeicoes;

	@Column(name = "nota_humor_pos_refeicoes", columnDefinition = "TINYINT UNSIGNED", nullable = false)
	private Integer notaHumorPosRefeicoes;

	@Column(name = "peso_atual", nullable = false)
	private float pesoAtual;

	@Column(name = "estatura", nullable = false)
	private float estaturaM;

	@Column(name = "imc", nullable = false)
	private float imc;

	@Column(name = "cb", nullable = false)
	private float cb;

	@Column(name = "dct", nullable = false)
	private float dct;

	@Column(name = "dcb", nullable = false)
	private float dcb;

	@Column(name = "dcse", nullable = false)
	private float dcse;

	@Column(name = "dcsi", nullable = false)
	private float dcsi;

	@Column(name = "somatoria_4_dobras", nullable = false)
	private float somatoria4Dobras;

	@Column(name = "porcentagem_gordura_corporal_somatoria_4_dobras", nullable = false)
	private float porcentagemGorduraCorporalSomatoria4Dobras;

	@Column(name = "peso_gordura", nullable = false)
	private float pesoGordura;

	@Column(name = "peso_massa_magra", nullable = false)
	private float pesoMassaMagra;

	@Column(name = "total_agua", nullable = false)
	private float totalAgua;

	@Column(name = "porcentagem_agua_massa_magra", nullable = false)
	private float porcentagemAguaMassaMagra;

	@Column(name = "resistencia", nullable = false)
	private float resistencia;

	@Column(name = "angulo_de_fase", nullable = false)
	private float AnguloDeFase;

	@Column(name = "circunferencia_cintura", nullable = false)
	private float circunferenciaCintura;

	@Column(name = "circunferencia_quadril", nullable = false)
	private float circunferenciaQuadril;

	@Column(name = "circunferencia_panturrilha", nullable = false)
	private float circunferenciaPanturrilha;

	@Column(name = "emap_direita", nullable = false)
	private float emapDireita;

	@Column(name = "emap_esquerda", nullable = false)
	private float emapEsquerda;

	@Column(name = "forca_preencao_manual_esquerda")
	private int forcaPreencaoManualEsquerda;

	@Column(name = "metas", length = 60)
	private String metas; */

	@Column(name = "criado_em", nullable = false)
	private LocalDate criadoEm;

	@PrePersist
	protected void onCreate() {
		criadoEm = LocalDate.now();
	}

}