
# Desafio Klok - Automação Web e Consulta SQL

Este repositório contém a solução para o desafio proposto pela Klok na vaga de estágio em QA, que envolve a criação de um teste automatizado para um fluxo de ponta a ponta de um cliente em um portal de comércio online e uma consulta SQL.

## Objetivo - Automação Web 

O objetivo deste desafio é automatizar os seguintes passos:

1. Acessar um grande portal de comércio online (Portal usado: [Magazine Luiza](https://www.magazineluiza.com.br/)).
2. Realizar uma busca por um produto.
3. Validar o retorno da busca.

## Ferramentas Utilizadas

- **Selenium**: Para automação da navegação e interação com a interface web.
- **JUnit**: Para execução dos testes e validação dos resultados.
- **Maven**: Para gerenciamento das dependências e execução do projeto.
- **Java**: Como linguagem de programação escolhida.

## Estrutura do Projeto

A arquitetura do projeto segue um padrão com as seguintes pastas:

- **pages**: Contém a página de interação com o site da Magazine Luiza (como a página de busca).
- **utils**: Contém o utilitário geral de configuração do WebDriver para o Selenium.
- **test**: Contém os testes propriamente ditos, organizados de acordo com a abordagem de teste do JUnit.
- **drive**: Contém o  WebDriver do Selenium para executar as ações no Google Chrome.

## Cenários de Testes

Os seguintes cenários de testes foram implementados:

### 1. Busca com Nome Válido
- **Objetivo**: Validar se os produtos exibidos correspondem ao termo de busca.
- **Passos**:
  - Buscar por um nome de produto válido (ex: "Notebook").
  - Verificar se produtos são exibidos.
  - Verificar se os produtos exibidos são relevantes.

### 2. Busca com Nome Parcial
- **Objetivo**: Validar se a busca por nome parcial retorna produtos relevantes.
- **Passos**:
  - Buscar por um termo parcial do produto (ex: "Noteb").
  - Verificar se produtos são exibidos.
  - Verificar se os produtos exibidos são relevantes.

### 3. Busca com Nome Incorreto
- **Objetivo**: Validar se uma busca com nome com letra incorreta exibe produtos relevantes.
- **Passos**:
  - Buscar por um nome de produto com uma letra errada (ex: "Notebiok").
   - Verificar se produtos são exibidos.
  - Verificar se os produtos exibidos são relevantes.

### 4. Busca Inválida e Exibição de Mensagem
- **Objetivo**: Validar se a busca de um produto completamente irrelevante exibe a mensagem correta.
- **Passos**:
  - Buscar por um nome que não corresponda a nenhum produto (ex: "testeDesafioKlokProdutoInválido").
  - Verificar se a mensagem de produtos não encontrados é exibida: "sua busca por 'testeDesafioKlokProdutoInválido' não encontrou resultado algum :(".

## Execução dos Testes

### Pré-requisitos

1. **Java**: Instalar o Java (versão 11 ou superior).
2. **Maven**: Instalar o Maven para gerenciar as dependências do projeto.
3. **WebDriver**: O código está configurado para usar o ChromeDriver (win64). Certifique-se de que o [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)  que está no projeto é compatível com seu SO.

### Como Rodar os Testes

 **Clone este repositório**:
   ```bash
   git clone https://github.com/seu-usuario/desafio-klok-estagio-qa.git
   ```
   ```bash
   cd desafio-klok-estagio-qa
   ```

   **execute:**:
   
   ```bash
   mvn clean test
   ```
   
 **Ou execute em uma IDE compatível com JDK**: Se você estiver utilizando uma IDE, como IntelliJ IDEA, Eclipse ou VS Code, você pode rodar os testes diretamente pela interface da IDE.

## Objetivo Consulta SQL

Uma seguradora, "SeguraTudo", possui duas tabelas em seu banco de dados: uma tabela chamada "clientes" que armazena informações sobre os clientes, como nome, endereço e número de telefone, e outra tabela chamada "apólices" que registra informações sobre as apólices de seguro dos clientes, incluindo o número da apólice, tipo de seguro e valor do prêmio. A empresa gostaria de saber quais clientes possuem apólices de seguro ativas e quais são os detalhes dessas apólices. 

 - **Pergunta**: Quais são os detalhes das apólices de seguro de todos os clientes da "SeguraTudo" que possuem apólices de seguro ativas, incluindo o nome do cliente, número da apólice, tipo de seguro e valor do prêmio?

**O código da consulta está presente no arquivo [SeguraTudo-Consulta.txt](./SeguraTudo-Consulta.txt) na raiz do projeto**

Este código SQL recupera, para cada cliente que tem uma apólice ativa, o nome do cliente, o número da apólice, o tipo do seguro e o valor do prêmio a ser pago. A consulta combina dados de duas tabelas (clientes e apólices), filtrando para que somente as apólices com status 'ativa' sejam exibidas.





