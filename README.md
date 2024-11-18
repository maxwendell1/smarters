# Plataforma de Gerenciamento de Cursos Online

## Descrição do Projeto
Esta é uma aplicação desenvolvida em **Java** utilizando **Spring Boot** e **Hibernate** para gerenciar uma plataforma de cursos online. A aplicação permite:
- Cadastrar alunos e cursos.
- Inscrever alunos em cursos.
- Consultar cursos associados a alunos e vice-versa.

A aplicação utiliza um banco de dados **H2 em memória** para armazenar os dados.

---

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Hibernate (JPA)
- Banco de Dados H2
- Maven

---

## Configuração

### Pré-requisitos
- Java 17 ou superior instalado.
- Maven instalado.

## Endpoints Disponíveis

### **Aluno**

#### **POST /alunos**
**Descrição:** Cadastrar um novo aluno.  
**Request Body:**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com"
}
```

## Endpoints Disponíveis

### **Aluno**

#### **GET /alunos**
**Descrição:** Listar todos os alunos.

---

### **Curso**

#### **POST /cursos**
**Descrição:** Cadastrar um novo curso.  
**Request Body:**
```json
{
  "nome": "Curso de Java",
  "descricao": "Aprenda Java do básico ao avançado"
}
```
#### GET /cursos
**Descrição:** Listar todos os cursos.

---

### Inscrição

#### POST /inscricoes
**Descrição:** Inscrever um aluno em um curso.
**Request Body:**

```json
{
  "alunoId": 1,
  "cursoId": 2
}
```
#### GET /inscricoes/aluno/{id}
**Descrição:** Listar todos os cursos em que um aluno está inscrito.
Exemplo de URL: /inscricoes/aluno/1

#### GET /inscricoes/curso/{id}
**Descrição:** Listar todos os alunos inscritos em um curso.
Exemplo de URL: /inscricoes/curso/2

