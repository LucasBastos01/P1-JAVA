# API de Adoção de Animais

Sistema para cadastro e gerenciamento de animais disponíveis para adoção, desenvolvido em Java com Spring Boot e API REST.

A aplicação permite cadastrar, consultar, atualizar e excluir animais.

## Tecnologias utilizadas

- Java 25
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Docker Compose

## Como executar o projeto

Para executar o projeto, é necessário ter o **Docker instalado e em execução**.

Abra um terminal na raiz do projeto e execute:

```bash
docker compose up --build
```

O Docker irá construir e iniciar automaticamente a **API Spring Boot** e o **banco de dados MySQL**.

Após a inicialização, a API estará disponível em:

```text
http://localhost:8080
```

## Endpoints

Os endpoints podem ser testados utilizando o arquivo do **Insomnia** disponibilizado no projeto.

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/animals` | Cadastrar um animal |
| GET | `/animals` | Listar todos os animais |
| GET | `/animals/{id}` | Buscar um animal pelo ID |
| PUT | `/animals/{id}` | Atualizar um animal |
| DELETE | `/animals/{id}` | Excluir um animal |

Também é possível filtrar os animais por faixa de idade e espécie:

```text
GET /animals?minAge=2&maxAge=5&species=DOG
```

Para encerrar a aplicação e os containers, execute:

```bash
docker compose down
```

## Testando a API com Insomnia ou Postman

O projeto já possui um arquivo de configuração do **Insomnia** com as requisições preparadas para testar os endpoints da API.

Para utilizá-lo:

1. Abra o **Insomnia** ou **Postman**.
2. Importe o arquivo do Insomnia disponível na raiz do projeto.
3. Certifique-se de que a aplicação esteja rodando com:

```bash
docker compose up --build
```

4. Após a importação, as requisições estarão disponíveis para testar as operações de **cadastro, consulta, atualização e exclusão de animais**.

A URL base utilizada nas requisições é:

```text
http://localhost:8080
```

Dessa forma, não é necessário criar manualmente cada requisição no Insomnia.