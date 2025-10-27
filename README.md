# Game List
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Vitor247/dslist/blob/main/LICENSE) 

# Sobre o projeto

GameList é uma API REST desenvolvida com Java e Spring Boot durante o *Intensivão Java Spring*. evento organizado pela [DevSuperior](https://devsuperior.com.br "Site da DevSuperior").

A aplicação consiste na organização de listas de jogos. Ela permite consultar informações detalhadas sobre games e gerenciar sua ordenação dentro de listas personalizadas, como uma prateleira digital.

O backend foi estruturado seguindo boas práticas como:

- Arquitetura em camadas (controllers, services, repositories)
- DTOs para exposição segura dos dados
- Tratamento de exceções padronizado

## Modelo conceitual
![Modelo Conceitual](https://github.com/Vitor247/assets/blob/main/dsGameList/dslist-model.png)

## Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Docker / Postgresql (em desenvolvimento)

## Como executar o projeto

Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/Vitor247/dslist

# entrar na pasta do projeto back end
cd dslist

# executar o projeto
./mvnw spring-boot:run
```

## Endpoints da API

| Método | Endpoint      | Descrição                                              |
| :----: | ------------- | ------------------------------------------------------ |
|   GET  | `/games`      | Retorna todos os jogos cadastrados em formato resumido |
|   GET  | `/games/{id}` | Retorna detalhes completos de um jogo específico       |


| Método | Endpoint                      | Descrição                                                                                           |
| :----: | ----------------------------- | --------------------------------------------------------------------------------------------------- |
|   GET  | `/lists`                      | Lista todas as coleções de jogos disponíveis                                                        |
|   GET  | `/lists/{listId}/games`       | Retorna os jogos pertencentes a uma lista específica, preservando a ordem                           |
|  POST  | `/lists/{listId}/replacement` | Reorganiza a posição dos jogos dentro da lista, com base em índices enviados no corpo da requisição |


# Autor

Vitor Camilo Inácio

https://www.linkedin.com/in/vitorcamilo-dev
