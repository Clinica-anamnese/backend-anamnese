# CLÍNICA ANAMNESE - BACKEND 

<p>API desenvolvida na linguagem Java, com o framework Spring Boot.</p>

<br/>

## CONFIGURAÇÕES
<br/>

### INICIAR PROGRAMA LOCALMENTE

É necessário instalar o **JDK (versão 17+)** e o **Maven (versão 3.9+)** - para compilar e inciar localmente.

<br/>

**Comandos para Iniciar Programa:**
<p><strong>mvn clean</strong> <em>- (opcional, mas recomendado) limpa a solução de arquivos e artefatos gerados na compilação anterior.</em></p>
<p><strong>mvn spring-boot:run</strong> <em>- compila e inicia o programa.</em></p>

<br/>

### BANCO DE DADOS

<p>O Banco de Dados SQL padrão ao iniciar localmente (modo dev) é o H2 Database - banco local in-memory.</p>
<p>Após compilar e iniciar o programa novamente, os dados armazenados anteriormente são excluídos.</p>
<p>É possível alterar nos arquivos: <strong>application-dev.yaml</strong> e <strong>application-prod.yaml</strong></p>
