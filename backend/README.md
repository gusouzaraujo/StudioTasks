StudioTasks API

Sistema de organização para estúdios musicais, voltado para controle de tarefas como gravações, mixagens e lançamentos. Desenvolvido com foco em boas práticas de desenvolvimento backend com Java.

---

Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA / Hibernate
- PostgreSQL
- Postman
- IntelliJ IDEA

Arquitetura do Projeto

- Controller → recebe requisições HTTP
- Service → regras de negócio
- Repository → acesso ao banco de dados
- Model → entidades JPA (mapeamento com tabelas)

---

Funcionalidades

- [x] Cadastro de tarefas
- [x] Listagem de todas as tarefas
- [x] Buscar tarefa por ID
- [x] Atualizar tarefa existente
- [x] Remover tarefa

---

Como Rodar Localmente:

	1.	Clone o repositório:

git clone https://github.com/gusouzaraujo/studiotasks-api.git
cd studiotasks-api


	2.	Configure o banco de dados PostgreSQL:
	•	Crie um banco chamado studiotasks
	•	Edite o arquivo src/main/resources/application.properties com suas credenciais:

spring.datasource.url=jdbc:postgresql://localhost:5432/studiotasks
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


	3.	Execute a aplicação:
	•	No IntelliJ IDEA:
	•	Importe o projeto como Maven Project
	•	Aguarde o carregamento das dependências
	•	Execute a classe StudioTasksApplication.java
	•	Via terminal (Linux/Mac):

./mvnw spring-boot:run


	•	Via terminal (Windows):

mvnw spring-boot:run


	4.	Testar a API (via Postman ou navegador):
	•	GET    /tarefas → Lista todas as tarefas
	•	POST   /tarefas → Cria nova tarefa
	•	GET    /tarefas/{id} → Busca tarefa por ID
	•	PUT    /tarefas/{id} → Atualiza tarefa existente
	•	DELETE /tarefas/{id} → Remove tarefa por ID
