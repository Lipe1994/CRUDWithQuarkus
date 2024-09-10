# Projeto CRUD com Quarkus

Este projeto é uma implementação básica de um CRUD (Create, Read, Update, Delete) utilizando o framework Quarkus. Ele foi desenvolvido como uma experiência de aprendizagem e segue a abordagem apresentada no vídeo do canal [Build & RUM](https://www.youtube.com/watch?v=osGxaQ8ekTE).

## Funcionalidades

O CRUD implementa operações básicas para gerenciar usuários. Os seguintes endpoints estão disponíveis:

### 1. Listar Usuários

- **Endpoint:** `GET /users`
- **Descrição:** Retorna uma lista paginada de usuários.
- **Parâmetros:**
    - `page` (opcional): Número da página para paginamento (padrão é 0).
    - `pageSize` (opcional): Número de usuários por página (padrão é 10).
- **Resposta:** Lista de usuários.

```http
GET /users?page=0&pageSize=10
```

### 2. Buscar Usuário por ID

- **Endpoint:** `GET /users/{id}`
- **Descrição:** Retorna um usuário específico com base no ID fornecido.
- **Parâmetros:**
    - `id`: ID do usuário a ser buscado.
- **Resposta:** Detalhes do usuário.

```http
GET /users/{id}
```

### 3. Criar Novo Usuário

- **Endpoint:** `POST /users`
- **Descrição:** Cria um novo usuário com base nas informações fornecidas.
- **Corpo da Requisição:** Dados do novo usuário.
- **Resposta:** Usuário criado.

```http
POST /users
Content-Type: application/json

{
  "username": "Nome do Usuário"
}
```

### 4. Atualizar Usuário

- **Endpoint:** `PUT /users/{id}`
- **Descrição:** Atualiza as informações de um usuário existente.
- **Parâmetros:**
    - `id`: ID do usuário a ser atualizado.
- **Corpo da Requisição:** Dados atualizados do usuário.
- **Resposta:** Usuário atualizado.

```http
PUT /users/{id}
Content-Type: application/json

{
  "username": "Novo Nome do Usuário"
}
```

### 5. Excluir Usuário

- **Endpoint:** `DELETE /users/{id}`
- **Descrição:** Exclui um usuário com base no ID fornecido.
- **Parâmetros:**
    - `id`: ID do usuário a ser excluído.
- **Resposta:** Status da operação.

```http
DELETE /users/{id}
```

## Como Executar o Projeto

1. **Clonar o Repositório:**

   ```bash
   git clone https://github.com/Lipe1994/CRUDWithQuarkus.git
   cd CRUDWithQuarkus
   ```

2. **Compilar e Executar o Projeto:**

   Certifique-se de ter o quarkus configurado

   ```bash
   quarkus dev
   ```

3. **Acessar a Aplicação:**

   A aplicação estará disponível em `http://localhost:8080`.