# Desafio ESIG

Este repositório contém a resolução de um desafio de criação de uma aplicação CRUD (Create, Read, Update, Delete) utilizando Java.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal utilizada na aplicação.
- **JSF (JavaServer Faces)**: Framework utilizado no front-end para renderizar as páginas.
- **Spring Boot**: Framework utilizado no back-end da API RESTful nível 3, responsável pelas funcionalidades de negócio e operações no banco de dados.
- **JPA (Java Persistence API)**: API utilizada para persistência e gerenciamento de dados.
- **JavaScript (JS)**: Linguagem utilizada para comunicação entre a interface e a API.
- **PostgreSQL**: Banco de dados utilizado, rodando em um container Docker.

## Estrutura do Projeto

## Ativar Front-end

### Front-end (JSF)

A interface é responsável por exibir as tarefas cadastradas, além de possibilitar a edição, o cadastro e a exclusão dessas tarefas.

#### Dependências:
- **WildFly**: Versão 34.0.0 ou superior.
- **Apache Maven**: Versão 3.9.9 ou superior.

Clone o repositorio
 ```bash
https://github.com/FellipePatrick/TaskEsig.git
````
Após clonar o projeto, execute o comando para atualizar as dependências:
 ```bash
    mvn clean install
  ````
Após isso, rode e a aplicação que estará na porta: http://localhost:8080/


## Ativar back-end
Back-end (Spring Boot)
O back-end é responsável por gerenciar os dados da aplicação e os serviços associados.

Dependências:
Java JDK: Versão 21 ou superior.
Spring Boot: Framework para gerenciamento de dados e lógica de negócio.
Banco de Dados
O banco de dados utilizado é o PostgreSQL, rodando em um container Docker.

Configuração:
Configure o arquivo .env de acordo com seu Sistema de Gerenciamento de Banco de Dados (SGBD).
Certifique-se de ter o Docker instalado na máquina.
Para iniciar o container do banco de dados, execute o seguinte comando:
```bash
docker-compose up
```
### Principais Camadas do Back-end
Controller: Responsável por receber as requisições do front-end e delegar as operações de CRUD para os serviços apropriados.
Service: Contém a lógica de negócio e realiza as operações de manipulação dos dados utilizando JPA.
Repository: Interface responsável pela interação direta com o banco de dados.
Como Executar o Projeto
Clone este repositório:

Atualize as dependências do projeto:
```bash
mvn clean install
```
Configure o arquivo .env para o banco de dados.

Inicie o banco de dados utilizando Docker:
```bash
docker-compose up
```
Execute a aplicação Spring Boot:
  ```bash
  mvn spring-boot:run
  ````
Acesse a aplicação no seu navegador:
 ```bash
    http://localhost:8080/
  ````

Funcionalidades
A aplicação permite as seguintes operações de CRUD:

Criar novas tarefas.
Listar todas as tarefas.
Editar tarefas existentes.
Excluir tarefas.

