# 🛒 Projeto CRUD de Loja - Sistema de Gerenciamento de Produtos

Este projeto implementa um sistema CRUD (Cadastro, Listagem, Consulta, Alteração e Exclusão) completo para gerenciamento de produtos, utilizando uma arquitetura moderna de microserviços e persistência de dados real.

---

## 🛠️ 1. Visão Geral e Tecnologias

| Critério | Tecnologia / Padrão | Detalhes |
| :--- | :--- | :--- |
| **Linguagem** | Java 17+ | Linguagem de programação principal. |
| **Framework** | Spring Boot (v4.0.0) | Utilizado para criar o servidor web e a API REST. |
| **Banco de Dados** | **MySQL** | Persistência de dados real. |
| **Persistência** | Spring Data JPA / Hibernate | ORM (Mapeamento Objeto-Relacional) para manipulação de dados. |
| **Design Pattern** | **Arquitetura em Camadas (Layered)** | Separação de responsabilidades (Controller, Service, Repository). |
| **Ferramenta de Teste**| Postman | Utilizado para testar os EndPoints HTTP. |

---

## 🏗️ 2. Arquitetura e Design Pattern

O projeto é organizado seguindo o **Design Pattern em Camadas (Layered Architecture)**. Esta estrutura garante a separação clara de responsabilidades entre as funcionalidades.

| Camada | Pacote de Exemplo | Responsabilidade Principal |
| :--- | :--- | :--- |
| **Controller** | `com.suauniversidade.lojas.controller` | **API/Comunicação:** Recebe as requisições HTTP (EndPoints) e retorna as respostas. |
| **Service** | `com.suauniversidade.lojas.service` | **Regra de Negócio:** Contém a lógica de validação e processamento. Orquestra as operações. |
| **Repository** | `com.suauniversidade.lojas.repository` | **Acesso a Dados:** Comunicação direta com o MySQL (via métodos JPA). |

---

## 🚀 3. Guia de Execução e Teste

### A. Configuração de Banco de Dados

1.  **MySQL Server:** Certifique-se de que o servidor MySQL esteja instalado e **ativo** (porta padrão `3306`).
2.  **Criar o BD:** O banco de dados **`loja_db`** deve ser criado previamente no servidor MySQL.
    ```sql
    CREATE DATABASE loja_db;
    ```
3.  **Credenciais:** Abra o arquivo **`src/main/resources/application.properties`** e insira as credenciais corretas do seu usuário MySQL:
    ```properties
    spring.datasource.username=SEU_USUARIO_AQUI
    spring.datasource.password=SUA_SENHA_AQUI
    server.port=8081 
    ```

### B. Como Rodar a Aplicação

1.  **Clone o Repositório:** Baixe o código do GitHub.
2.  **Abra no IntelliJ:** O IDE irá instalar as dependências automaticamente (verifique o `pom.xml`).
3.  **Executar:** Execute a classe principal **`LojaCrudApplication.java`**. O log deve confirmar que o Tomcat iniciou na porta **8081**.

### C. Teste com Postman

1.  **Importe a Coleção:** Importe o arquivo **`Loja_CRUD_Collection.json`** no Postman.
2.  **Ajuste de Porta:** O arquivo da coleção pode vir configurado para `8080`. **Ajuste a porta para `8081`** em todas as requisições.
3.  Execute os testes na ordem (Cadastro, Listagem, Alteração, Exclusão) utilizando a URL base: **`http://localhost:8081/api/produtos`**.

---

## 🎯 4. EndPoints da API (CRUD)

| Ação | Método HTTP | URL de Exemplo | Status de Sucesso |
| :--- | :--- | :--- | :--- |
| **Cadastro** | `POST` | `/api/produtos` | `201 Created` |
| **Listagem** | `GET` | `/api/produtos` | `200 OK` |
| **Consulta** | `GET` | `/api/produtos/{id}` | `200 OK` (ou 404) |
| **Alteração** | `PUT` | `/api/produtos/1` | `200 OK` |
| **Exclusão** | `DELETE` | `/api/produtos/1` | `204 No Content` |

---
