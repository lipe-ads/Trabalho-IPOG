# Melhora do Projeto Gerenciador de Tarefas Personais

Hi professor. Essa é a melhora do projeto anterior (atividade 2 no caso) e com ele trouxe os pontos que o senhor pediu com foco nos erros e sinceramente eu tive que dar uma pesquisada e com isso veio umas melhorias bacanas até

O link direto da atividade que eu usei como base:
https://github.com/lipe-ads/Trabalho-IPOG/tree/main/Servicos-Web_%26_APIRESTfull/Atividade2

---

## O que o projeto faz de especial? (Além de rodar)

Na primeira fase, a gente fez o CRUD básico (criar, ler, atualizar e deletar). Só que agora:
1. **Blindei os dados:** Não é possivel criar tarefas sem título ou com descrição em branco. Adicionei regras de validação no coração do Model tambem profesor.
2. **Criei uma Central de Erros (usando como base um crud antigo meu):** Se o usuário digitar um ID que não existe ou mandar um JSON todo torto, a API intercepta o erro no ar com o `@RestControllerAdvice` e responde um JSON bonitinho explicando o que deu errado, em vez de estourar aquele textão vermelho feio no console.

---

## Tecnologias e Dependências Utilizadas
* **Java 17/21** 