# Desafio ESIG

### - **Observações**

**Do sistema**: O nome da aplicação é Sistema de Gestão de Tarefas, nessa resolução optei por me basear no exemplo fornecido só que com um pouco mais de tecnologias. Essa versão de implementação se divide em dois modulos,a interface gráfica que é feita com o JSF e roda em cima do wildFly, e a API RestFull nivel 3 que implementa a lógica de negócio, feita em spring boot. Para a comunicação entre interface e api foi escolhido o JS, para otimizar o desempenho do servidor, uma vez que esse processamento ficara do lado do cliente. Poderia tambem fazer essa comicação com a biblioteca rest template do proprio java, porem visando um pouco mais de desempenho optei por javaScript.

**Itens implementados**:

- A: O item referente foi implementado com a interface gráfica

- B: A persistencia dos dados é atráves da API restFull nivel 3

- C: O JPA é utilizado na API

- E: Acesse o sistema no link:

- F: Os direnciais que julguei conveniente é a criação de uma API RestFull nivel 3, com a implementação da paginação e o Hateoas e a integração de sistemas interface-api.


## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal utilizada na aplicação.
- **JSF (JavaServer Faces)**: Framework utilizado no front-end para renderizar as páginas.
- **Spring Boot**: Framework utilizado para desenvolver a API RESTfull nível 3, responsável pelas funcionalidades de negócio e operações no banco de dados.
- **JPA (Java Persistence API)**: API utilizada para persistência e gerenciamento de dados.
- **JavaScript (JS)**: Linguagem utilizada para comunicação entre a interface e a API.
- **PostgreSQL**: Banco de dados utilizado, rodando em um container Docker.

# Configuração de ambiente


## Configurando a API RestFull Nivel 3

É obrigatorio ter o JDK 21 ou superior para rodar o projeto.

Primeiramente o projeto está configurado para ser utilizado no intellij

- **Intellij IDEA Ultimate**: versão 2024.2.3 ou superior

O sistema utiliza o Docker, caso queira utilizar um SGB altere no arquivo application.yml

Configurando o Docker

- **Docker**: versão 4.34.2 ou superior

Após a instalação do Docker e Intellij, abra a pasta crud dentro da pasta api no intellij

Rode o comando:

```bash
docker-compose up
```
A api já está pronta para ser utilizada

Verifique a api na URL:
 ````bash
    http://localhost:8081/tarefas/
  ````

## Configurando a Interface gráfica

Assim como a api a interface tambem roda no intellij

- **WildFly**: Versão 34.0.0 ou superior.

A instalação do wildfly se faz necessario para rodar o projeto, após a instalação adicione o wildfly como application server

Rode o projeto com o wildfly

Verifique a interface na URL:
 ````bash
    http://localhost:8080/tarefas
  ````

## Video auxiliar para configuração

Acesse o link do video:

 ````bash
    https://youtu.be/YNEB4utsGkA
  ````
