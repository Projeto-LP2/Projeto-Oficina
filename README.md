# Sistema de Oficina Mecânica
Sistema desenvolvido em **Java Swing** para gerenciamento de veículos de uma oficina mecânica.

Projeto desenvolvido para a disciplina de **Linguagem de Programação II (LP2)**.

**Cenário:** Oficina Mecânica

**Ano:** 2026

## Funcionalidades

* Cadastrar veículos
* Consultar veículos
* Alterar veículos
* Excluir veículos
* Listar veículos em tabela (`JTable`)

### Dados do veículo

* Código
* Placa
* Modelo
* Marca
* Ano
* Proprietário
* Telefone
* Descrição

## Interface
* **SDI** - utilizando `JFrame`
* **MDI** - utilizando `JInternalFrame`

## Tecnologias
* Java
* Java Swing
* PostgreSQL 
  
## Integrantes
* **Breno Souza**
* **Caio Simão**
* **Cleyton Ferreira**
* **Hitaro Ramos**
* **Ricardo Roque**

## Configuração do Banco de Dados

Para executar o sistema localmente, você deve configurar suas credenciais a partir do arquivo de modelo fornecido.

Siga os passos abaixo:

1. Navegue até o diretório `src/main/resources`.
2. Localize o arquivo de template `application.properties.example`.
3. Renomeie o arquivo (ou crie uma cópia) removendo o sufixo `.example`, deixando-o estritamente como `application.properties`.
4. Abra o arquivo `application.properties` recém-criado e preencha as informações de acordo com as configurações do seu banco de dados PostgreSQL local (endereço, usuário e senha).