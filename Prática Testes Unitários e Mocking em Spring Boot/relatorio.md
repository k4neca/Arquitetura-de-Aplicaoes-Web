# ✅ Relatório de Testes Unitários – Projeto Spring Boot

**Projeto:** Testes Unitários e Mocking em Spring Boot  
**Tecnologias Utilizadas:**
- Java 21  
- Spring Boot 3.5.0  
- Spring Web  
- Spring Data JPA  
- Spring Boot DevTools  
- MariaDB  
- JUnit 5  
- Mockito  
- Postman (para testes manuais da API)

---

## 🎯 Objetivo

O objetivo desta etapa foi implementar e validar testes unitários e de integração para os principais componentes de uma aplicação Spring Boot RESTful que gerencia entidades de usuários. A proposta visa garantir a confiabilidade do código, modularidade e facilidade de manutenção.

---

## 🛠️ Alterações realizadas

- **Criação da estrutura MVC da aplicação:**
  - `model/Usuario.java`
  - `repository/UsuarioRepository.java`
  - `service/UsuarioService.java`
  - `controller/UsuarioController.java`

- **Configuração do banco de dados MariaDB via `application.properties`.**

- **Implementação dos seguintes testes automatizados:**
  - `UsuarioServiceTest` (Mockito)
  - `UsuarioControllerTest` (`@WebMvcTest`, `MockMvc`)
  - `UsuarioRepositoryTest` (teste de integração real com MariaDB)

- **Validação manual dos endpoints no Postman:**
  - `GET /usuarios`
  - `POST /usuarios`

---

## ✅ Resultados dos Testes

| Teste                                 | Tipo           | Resultado |
|--------------------------------------|----------------|-----------|
| `deveRetornarListaDeUsuarios`        | Unitário       | ✅ Passou |
| `deveSalvarUsuario`                  | Unitário       | ✅ Passou |
| `deveRetornarListaDeUsuarios` (GET)  | MockMVC        | ✅ Passou |
| `deveCriarUsuario` (POST)            | MockMVC        | ✅ Passou |
| `deveSalvarERecuperarUsuario`        | Integração     | ✅ Passou |
| `GET /usuarios`                      | Teste manual   | ✅ Passou |
| `POST /usuarios`                     | Teste manual   | ✅ Passou |

---

## 📌 Conclusão

Todos os testes planejados foram implementados e executados com sucesso. As funcionalidades principais da aplicação foram validadas tanto por testes automatizados quanto por testes manuais via Postman. A cobertura contempla as camadas de serviço, controle e repositório, demonstrando que a API está funcionando conforme o esperado, com persistência e resposta corretas.

---
