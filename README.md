# 📝 **To-Do List API**  

Este repositório contém uma **API REST** para gerenciamento de tarefas (To-Do List) desenvolvida em **Java** com **Spring Boot**. A aplicação permite que os usuários gerenciem suas tarefas de forma eficiente, com funcionalidades completas de CRUD (Create, Read, Update, Delete).

---

## ✨ **Funcionalidades**
### 👤 **Usuários**
- ➕ **Criar conta**: Cadastro de novos usuários com nome, nome de usuário e senha.
- 🔒 **Autenticação**: Garantia de que cada usuário acesse apenas suas próprias tarefas.
- 🛠️ **Atualização de dados**: Atualize informações do usuário, como nome ou senha.

### ✅ **Tarefas**
- ➕ **Criar tarefa**: Adicione tarefas com título, descrição, data de início, data de término e prioridade.
- 📄 **Listar tarefas**: Veja todas as suas tarefas organizadas.
- 🖊️ **Atualizar tarefa**: Altere detalhes de uma tarefa existente.
- ❌ **Excluir tarefa**: Remova tarefas que não são mais necessárias.

---

## 📂 **Estrutura do Projeto**
O projeto segue uma arquitetura bem organizada, utilizando **Spring Boot** e **JPA** para o gerenciamento de banco de dados.  

### 🌟 **Principais Componentes**
- **Modelos**: Representam os dados do sistema (e.g., `UserModel`, `TaskModel`).
- **Controladores**: Gerenciam as requisições HTTP (e.g., `UserController`, `TaskController`).
- **Repositórios**: Fazem a conexão com o banco de dados para persistência (e.g., `ITaskRepository`).

---

## 🛠️ **Tecnologias Utilizadas**
- **Java** ☕  
- **Spring Boot** 🚀  
- **Hibernate** 🗂️  
- **Jakarta Persistence API (JPA)** 🛢️  
- **Lombok** 🔧  

---

## 🚀 **Como Executar**
1. **Clone o repositório**:  
   ```bash
   git clone https://github.com/seu-usuario/to-do-list-api.git
   ```
2. **Abra o projeto em sua IDE favorita**: Recomenda-se o uso do IntelliJ IDEA ou Eclipse.  
3. **Configure o banco de dados**: Atualize o arquivo `application.properties` com suas credenciais.  
4. **Execute a aplicação**: Rode o arquivo principal para iniciar o servidor.  

---

## 📋 **Modelos de Dados**
### 🧑‍💻 **Usuário (`UserModel`)**
- **id**: Identificador único.  
- **username**: Nome de usuário (único).  
- **password**: Senha do usuário.  
- **name**: Nome completo do usuário.  
- **createdAt**: Data de criação.  
- **updatedAt**: Data de última atualização.  

### 🗂️ **Tarefa (`TaskModel`)**
- **id**: Identificador único.  
- **title**: Título (até 50 caracteres).  
- **description**: Descrição detalhada.  
- **startAt**: Data de início.  
- **endAt**: Data de término.  
- **priority**: Nível de prioridade (e.g., alta, média, baixa).  
- **idUser**: ID do usuário que criou a tarefa.  
- **createdAt**: Data de criação.  

---

## 🛡️ **Validações**
- 🚨 O título da tarefa não pode ter mais de 50 caracteres.  
- 🚨 Datas de início e término devem ser futuras e coerentes (início antes do término).  

---

## 🤝 **Contribuição**
Contribuições são bem-vindas! Siga os passos:  
1. Faça um **fork** deste repositório.  
2. Crie um branch com sua funcionalidade:  
   ```bash
   git checkout -b minha-nova-funcionalidade
   ```  
3. Envie um pull request para revisão.  

