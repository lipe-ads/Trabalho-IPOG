# Melhoria p/ Atividade 4 - Gerenciador de Tarefas 

Esta é a evolução contínua da API de tarefas, para seguir padrões corporativos escaláveis e documentada de forma automatizada.

## Arquitetura
Para separar as responsabilidades e garantir a escalabilidade, o projeto foi reestruturado incluindo o Service, segue breve explicação de cada pasta:
* `model`: Representação e validação da entidade no banco.
* `repository`: Camada de persistência (Spring Data JPA).
* `service`: Concentra toda a lógica de negócios e validações complexas.
* `controller`: Responsável única e exclusivamente pela recepção de requisições e retornos HTTP.
* `exception`: Interceptador global de falhas da API.

## O Versionament
Adotei a estratégia de Versionamento por URI/URL, adicionei o prefixo `/v1/` nos caminhos das requisições. Isso protege em caso de futuras evoluções na aplicação.

* **Listar:** `GET /api/v1/tarefas`
* **Criar:** `POST /api/v1/tarefas`
* **Atualizar:** `PUT /api/v1/tarefas/{id}`
* **Deletar:** `DELETE /api/v1/tarefas/{id}`

## Documentação Automatizada
Substitui o mapeamento manual pelo ecossistema Swagger UI. Assim que a aplicação é iniciada localmente, a documentação completa, interativa e com exemplos de JSON e códigos de resposta pode ser acessada na rota:

** Segue a Interface do Swagger:** `http://localhost:8080/swagger-ui/index.html`

Essas atividades me fizeram relembrar muitas coisas sobre projetos e como é importante a padronização e o versionamento correto pra caso eu queira aprimorar futuramente, muito divertido fazer elas.