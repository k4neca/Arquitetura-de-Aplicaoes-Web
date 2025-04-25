# Projeto: Gerenciamento de Empresas e Colaboradores com Spring Boot

## Visão Geral

Este projeto é uma aplicação Spring Boot que gerencia as entidades **Empresa** e **Colaborador** com um relacionamento **um-para-muitos**, utilizando **MariaDB**, **Spring Data JPA**, **Lombok**, **Spring Web** e **DevTools**. A aplicação implementa operações CRUD expostas via endpoints REST e persiste os dados em um banco de dados relacional.

O cenário modela empresas que possuem múltiplos colaboradores, onde cada colaborador está associado a uma única empresa.

---

## Pré-requisitos

- Java 21  
- Maven  
- XAMPP (com MariaDB habilitado)  
- Postman ou Bruno (para testar os endpoints REST)  
- VS Code ou IntelliJ IDEA  

---

## Configuração do Ambiente

### 1. Configurar o MariaDB com XAMPP

- Instale o XAMPP via [site oficial](https://www.apachefriends.org).
- Inicie o serviço **MySQL** no painel de controle do XAMPP.
- (Opcional) Inicie o Apache para usar o phpMyAdmin via navegador.
- Crie o banco de dados:

```sql
CREATE DATABASE av1;
```

### 2. Configurar o Projeto

Verifique `src/main/resources/application.properties`:

```properties
spring.application.name=Av1
spring.datasource.url=jdbc:mariadb://localhost:3306/av1
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
```

### 3. Executar a Aplicação

```bash
mvn clean install
mvn spring-boot:run
```

Acesse: [http://localhost:8080](http://localhost:8080)

---

## Estrutura do Projeto

- `CaioAlmeida.Av1.Models`: Entidades JPA (`Empresa`, `Colaborador`)
- `CaioAlmeida.Av1.Repositories`: Interfaces de repositório (`JpaRepository`)
- `CaioAlmeida.Av1.Services`: Lógica de negócio
- `CaioAlmeida.Av1.Controllers`: Endpoints REST
- `CaioAlmeida.Av1`: Classe principal `Av1Application`

---

## Entidades e Relacionamento

### Empresa

- Atributos: `id`, `nome`, `colaboradores`
- Anotações:
  - `@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)`

### Colaborador

- Atributos: `id`, `nome`, `idade`, `cargo`, `empresa`
- Anotações:
  - `@ManyToOne`
  - `@JoinColumn(name = "empresa_id")`
  - `@JsonIgnore` (para evitar recursão infinita)

---

## Endpoints REST

### Empresa

| Método | Endpoint       | Descrição                | Corpo JSON                       | Resposta     |
|--------|----------------|--------------------------|----------------------------------|--------------|
| GET    | /empresas      | Lista todas as empresas  | -                                | 200 OK       |
| POST   | /empresas      | Cria nova empresa        | `{"nome": "Tech Corp"}`          | 201 Created  |
| PUT    | /empresas/{id} | Atualiza empresa         | `{"nome": "Tech Corp Atualizado"}` | 200 / 404 |
| DELETE | /empresas/{id} | Deleta empresa           | -                                | 204 / 404    |

### Colaborador

| Método | Endpoint             | Descrição                  | Corpo JSON                                                                 | Resposta     |
|--------|----------------------|----------------------------|----------------------------------------------------------------------------|--------------|
| GET    | /colaboradores       | Lista todos os colaboradores | -                                                                        | 200 OK       |
| POST   | /colaboradores       | Cria colaborador           | `{"nome": "João", "idade": 30, "cargo": "Desenvolvedor", "empresa": {"id": 1}}` | 201 Created  |
| PUT    | /colaboradores/{id}  | Atualiza colaborador       | `{"nome": "João Silva", "idade": 31, "cargo": "Senior Dev", "empresa": {"id": 1}}` | 200 / 404 |
| DELETE | /colaboradores/{id}  | Deleta colaborador         | -                                                                        | 204 / 404    |

---

## Exemplo de Requisições

### Criar Empresa

```http
POST /empresas
Content-Type: application/json

{
  "nome": "Tech Corp"
}
```

### Criar Colaborador

```http
POST /colaboradores
Content-Type: application/json

{
  "nome": "João",
  "idade": 30,
  "cargo": "Desenvolvedor",
  "empresa": {
    "id": 1
  }
}
```

---

## Verificação da Persistência

Acesse o MariaDB:

```sql
USE av1;
SHOW TABLES; -- Esperado: empresa, colaborador
SELECT * FROM empresa;
SELECT * FROM colaborador;

-- Consulta com JOIN:
SELECT c.nome, c.cargo, e.nome AS empresa_nome
FROM colaborador c
JOIN empresa e ON c.empresa_id = e.id;
```

---

## Boas Práticas Implementadas

- Uso de **Lombok** para reduzir boilerplate
- Arquitetura MVC com separação clara das responsabilidades
- Mapeamento JPA com `@OneToMany`, `@ManyToOne` e `@JoinColumn`
- Tratamento de respostas com códigos HTTP apropriados
- Casacateamento (`cascade = CascadeType.ALL`) e remoção de órfãos (`orphanRemoval = true`)
