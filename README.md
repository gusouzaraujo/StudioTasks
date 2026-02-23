# StudioTasks

Aplicação full stack para gerenciamento de tarefas, desenvolvida com **Java (Spring Boot)** no back-end e **Angular** no front-end.

O projeto foi inspirado na organização de tarefas em estúdios musicais, mas pode ser utilizado em qualquer contexto que exija controle e gerenciamento de atividades.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Angular
- PostgreSQL
- Maven
- TypeScript

---

## 📂 Estrutura do Projeto

```
StudioTasks/
├── backend/   → API REST em Spring Boot
└── frontend/  → Interface em Angular
```

---

## 🔧 Funcionalidades

- CRUD completo de tarefas
- Integração front-end e back-end via API REST
- Persistência com PostgreSQL
- Modal de confirmação para exclusão
- Atualização dinâmica da interface

---

## ▶️ Como Executar o Projeto

### 1️⃣ Banco de Dados

Instale o PostgreSQL e crie um banco:

```sql
CREATE DATABASE studiotasks;
```

No arquivo:

```
backend/src/main/resources/application.properties
```

Configure suas próprias credenciais de acesso ao banco de dados.

---

### 2️⃣ Executar o Back-end

Dentro da pasta `backend`:

```bash
mvnw spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

### 3️⃣ Executar o Front-end

Dentro da pasta `frontend`:

```bash
npm install
ng serve
```

A aplicação será iniciada em:

```
http://localhost:4200
```

---

## 🧱 Arquitetura

```
Angular (Frontend)
        ↓ HTTP
Spring Boot (Backend)
        ↓ JPA / Hibernate
PostgreSQL (Banco de Dados)
```

---

## 🔮 Próximos Passos (Roadmap)

- Implementação de DTO
- Validações customizadas
- Tratamento global de exceções
- Autenticação com JWT
- Deploy em ambiente de produção

---

Projeto desenvolvido como consolidação prática em desenvolvimento full stack.