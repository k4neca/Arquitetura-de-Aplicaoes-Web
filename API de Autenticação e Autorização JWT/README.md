# API de Autenticação e Autorização JWT

Este projeto é uma API RESTful desenvolvida com **Spring Boot 3.5.3** que implementa autenticação e autorização por **JWT (JSON Web Token)**, com documentação interativa gerada pelo **Swagger/OpenAPI**. 

## 📁 Clonando o Repositório da Disciplina 

```bash
git clone https://github.com/k4neca/Arquitetura-de-Aplicaoes-Web.git
cd authserver
```

## ⚙️ Requisitos

- Java 21
- Maven 3.9+
- IntelliJ IDEA ou VS Code

## ⚡ Executando a Aplicação

No IntelliJ:
1. Abra o projeto.
2. Localize a classe `AuthserverApplication.java`.
3. Clique com o botão direito e escolha **Run** ou use `Shift + F10`.

No terminal:
```bash
./mvnw spring-boot:run
```

## 🌐 Endpoints Disponíveis

| Tipo  | Endpoint               | Protegido? | Descrição |
|-------|------------------------|------------|-------------|
| POST  | `/auth/login`         | Não        | Gera token JWT com credenciais |
| POST  | `/auth/validate`      | Não        | Valida um token JWT manualmente |
| GET   | `/api/hello`          | Sim        | Acessível por qualquer usuário logado |
| GET   | `/api/admin`          | Sim (ADMIN)| Acessível apenas por ADMIN |

## 🔐 Acessando com Token JWT

1. Use `/auth/login` com `username=admin` e `password=123456`.
2. Copie o token JWT retornado.
3. No Swagger UI, clique em **Authorize** e cole:
   ```
   Bearer SEU_TOKEN_AQUI
   ```
4. Agora você pode testar os endpoints protegidos diretamente pela interface Swagger.

## 📃 Documentação com Swagger UI

Acesse via navegador:
```text
http://localhost:8080/swagger-ui/index.html
```

## 📊 Console do Banco H2 (Desenvolvimento)

Acesse via navegador:
```text
http://localhost:8080/h2-console
```
Configuração:
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(em branco)*

## 📊 Testes de Carga com JMeter

1. Baixe o Apache JMeter: https://jmeter.apache.org/download_jmeter.cgi
2. Extraia e execute o `jmeter.bat` (Windows) ou `jmeter.sh` (Linux/macOS)
3. Abra o arquivo `login_stress_test.jmx` na pasta `/jmeter-tests`
4. Configure:
   - URL: `localhost`
   - Porta: `8080`
   - Caminho: `/auth/login`
   - Parâmetros: `username=admin`, `password=123456`
5. Execute o teste clicando no botão **Start**
6. Visualize os relatórios em:
   - **Summary Report**
   - **View Results Tree**

## ✅ Testes Automatizados (JUnit + MockMvc)

Para executar os testes:
```bash
./mvnw test
```
Ou pelo IntelliJ, clique com o botão direito na classe `AuthIntegrationTests.java` e selecione **Run**.

## 📖 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com.example.authserver
│   │       ├── config          # Configurações de segurança e Swagger
│   │       ├── controller      # Controladores REST
│   │       ├── model           # Entidade User
│   │       ├── repository      # Repositório JPA
│   │       └── service         # Lógica de negócio e JWT
│   └── resources
│       ├── application.yml     # Configuração da aplicação
├── test
│   └── com.example.authserver
│       └── AuthIntegrationTests.java
```

## 📄 Licença
Este projeto utiliza a licença Apache 2.0. Veja o arquivo LICENSE para mais detalhes.

---
Desenvolvido por Caio Almeida para fins acadêmicos 🎓
