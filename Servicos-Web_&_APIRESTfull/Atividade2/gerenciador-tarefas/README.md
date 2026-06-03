[//]: # (
Querido Professoe Welber, esse trabalho foi como solicitado, mas sendo sincero...
Ja tinha tempo que não fazia um CRUD então não foi algo muito UAU
Foi usado um banco em cache pra não ter que criar um somente pra esse trabalho, sendo que está funcionando perfeitamente
Segue documentação com a forma de se utilizar os endpoints:
)

# Documentação da API de Tarefas

## Endpoints

### 1. Listar Todas as Tarefas
* **URL:** `/api/tarefas`
* **Método:** `GET`
* **Código de Resposta:** `200 OK`

### 2. Criar Nova Tarefa
* **URL:** `/api/tarefas`
* **Método:** `POST`
* **Corpo (JSON):**
  ```json
  {
    "titulo": "Estudar para a prova",
    "descricao": "Revisar a matéria de Spring Boot",
    "concluida": false
  }

### 3. Excluir Tarefa
* **URL:** `/api/tarefas/{id Desejado}`
* **Método:** `^DELETE`
* **Código de Resposta:** `200 No body returned for response`

### 4. Atualizar Tarefa
* **URL:** `/api/tarefas/{id Desejado}`
* **Método:** `PUT`
* **Corpo (JSON):**
  ```json
  {
    "titulo": "Estudar para a prova",
    "descricao": "Revisar a matéria de Spring Boot",
    "concluida": true
  }
  
