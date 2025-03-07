# Projeto: Hello World com Spring Boot

Este projeto é uma aplicação simples em Java utilizando o framework Spring Boot. Ele expõe um endpoint que retorna a mensagem "Hello, World!" para demonstração de conceitos básicos de desenvolvimento web.

## Estrutura do Projeto

- **src/main/java/com/pratica1/controller**
  - `ControllerApplication.java`: Classe principal responsável por inicializar a aplicação Spring Boot.
  - `HelloController.java`: Classe responsável pelo controle REST, com o endpoint `/test` que retorna a mensagem "Hello, World!".

- **Dependências principais**:
  - Spring Boot Starter Web: Para criar aplicações web RESTful.
  - Spring Boot Starter: Ferramentas essenciais para executar a aplicação.
  - Spring Boot Devtools.

## Como Executar

1. **Pré-requisitos**:
   - Certifique-se de ter o [Java JDK 21](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows) instalado.
   - Ter a IDE [Visual Studio Code](https://code.visualstudio.com/) configurada conforme instruido nas aulas.

Acesse o endpoint: Abra o navegador ou utilize o Postman/cURL para acessar:

Ao acessar http://localhost:8080/test, o servidor irá retornar:

Hello, World!

Ao acessar http://localhost:8080/name, o servidor irá retornar:

Olá, meu nome é Caio César de Souza Almeida e meu RA é 12121045

