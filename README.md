
## Projeto Case Técnico WebService para a empresa PlaceTi!

Este é um projeto CRUD (Create, Read, Update, Delete) completo, desenvolvido com Java SpringBoot, Docker e o banco de dados Postgres para facilitar a criação, leitura, atualização e exclusão de dados de forma eficiente.

## 🚀 Começando

Siga estas instruções para ter o projeto rodando na sua máquina local:

### 📋 Pré-requisitos

-   **Docker:** Certifique-se de ter o Docker e o Docker Compose instalados. Se não tiver, baixe e instale em [https://www.docker.com/get-started](https://www.docker.com/get-started).
-   **Java Development Kit (JDK):** Versão 8 ou superior.


### 🔧 Instalação

1.  **Clone o Repositório:**
    
    Bash
    
    ```
    git clone https://github.com/Guil61/webService
    
    ```
    
2.  **Acesse a Pasta do Projeto:**
    
    Bash
    
    ```
    cd webService
    
    ```

    
3.  **Construa e Inicie os Containers:**
    
    Bash
    
    ```
    docker build -t webservice-app .
    
    ```
    
    ```
    docker compose up -d
    
    ```    

4. **Opcional: Rodar a aplicação localmente pela IDE**

   Caso deseje rodar a aplicação localmente pela IDE, deve-se pausar o container da aplicação do Docker ("app"). Ou case prefira pelo terminal

    Bash
   
    ```
    docker stop webservice-app
    ```
    
  Após isso, entre na aplicação pela sua IDE e altere o arquivo "application.yaml" que fica no diretório src/main/resources e altere a linha 16 para:

  ```
  url: "jdbc:postgresql://localhost:5432/postgres"
  ````

    

Agora você pode acessar a aplicação em `http://localhost:8080` (ou a porta que você configurou no `docker-compose.yml`).



### 🔧 Endpoints para testes


### GET /contratos

**Descrição:** Retorna uma lista de todos os contratos.

**Exemplo de Requisição:**

Bash

```
http://localhost:8080/contratos

```

**Exemplo de Resposta:**

JSON

```
[
    {
        "id": 1,
        "nomeDevedor": "Fulano de Tal",
        "dataNascimentoDevedor": "1990-01-05",
        "numeroRegistroEletronico": "ABCDE12322245",
        "veiculo": []
    },
    {
        "id": 2,
        "nomeDevedor": "Fulano de Tal",
        "dataNascimentoDevedor": "1990-01-05",
        "numeroRegistroEletronico": "ABCDE12322245",
        "veiculo": []
    }
]

```

### GET /contratos/{id}

**Descrição:** Retorna um contrato específico pelo ID.

**Exemplo de Requisição:**

Bash

```
http://localhost:8080/contratos/2

```


**Exemplo de Resposta:**

JSON

```
{
    "id": 2,
    "nomeDevedor": "Fulano de Tal",
    "dataNascimentoDevedor": null,
    "numeroRegistroEletronico": "ABCDE12322245",
    "veiculo": []
}
```


### POST /contratos

**Descrição:** Cria um novo contrato.

**Exemplo de Requisição:**

JSON

```
{   
    "nomeDevedor": "Fulano de Tal",
    "dataNascimentoDevedor": "1990-01-05",
    "numeroRegistroEletronico": "ABCDE12322245"
}

```


**Exemplo de Resposta:**

JSON

```
{
    "id": 3,
    "nomeDevedor": "Fulano de Tal",
    "dataNascimentoDevedor": "1990-01-05",
    "numeroRegistroEletronico": "ABCDE12322245",
    "veiculo": null
}

```


### PUT /contratos/{id}

**Descrição:** Atualiza um contrato existente pelo ID.

**Exemplo de Requisição:**

Bash

```
http://localhost:8080/contratos/3
```

JSON

```
{   
    "nomeDevedor": "nome atualizado",
    "dataNascimentoDevedor": "1990-01-05",
    "numeroRegistroEletronico": "ABCDE12322245"
}

```


**Exemplo de Resposta:**

JSON

```
{
{
    "id": null,
    "nomeDevedor": "nome atualizado",
    "dataNascimentoDevedor": "1990-01-05",
    "numeroRegistroEletronico": "ABCDE12322245",
    "veiculo": null
}

```


### DELETE /contratos/{id}

**Descrição:** Exclui um contrato pelo ID.

**Exemplo de Requisição:**

Bash

```
DELETE http://localhost:8080/contratos/3

```


**Exemplo de Resposta:**

```
DELETED
```


### GET /veiculos

**Descrição:** Retorna uma lista de todos os veiculos.

**Exemplo de Requisição:**

Bash

```
http://localhost:8080/veiculos
```

**Exemplo de Resposta:**

JSON

```
[
    {
        "id": 2,
        "numeroGravame": "000000",
        "numeroRenavam": "123123",
        "placa": "ABC123",
        "numeroChassi": "3123213",
        "contrato": {
            "id": 1,
            "nomeDevedor": "Fulano de Tal",
            "dataNascimentoDevedor": "1990-01-05",
            "numeroRegistroEletronico": "ABCDE12322245",
            "veiculo": [
                {
                    "id": 2,
                    "numeroGravame": "000000",
                    "numeroRenavam": "123123",
                    "placa": "ABC123",
                    "numeroChassi": "3123213"
                }
            ]
        }
    }
]

```

### GET /veiculos/{id}

**Descrição:** Retorna um veiculo específico pelo ID.

**Exemplo de Requisição:**

Bash

```
http://localhost:8080/veiculos/

```


**Exemplo de Resposta:**

JSON

```
[
    {
        "id": 2,
        "numeroGravame": "000000",
        "numeroRenavam": "123123",
        "placa": "ABC123",
        "numeroChassi": "3123213",
        "contrato": {
            "id": 1,
            "nomeDevedor": "Fulano de Tal",
            "dataNascimentoDevedor": "1990-01-05",
            "numeroRegistroEletronico": "ABCDE12322245",
            "veiculo": [
                {
                    "id": 2,
                    "numeroGravame": "000000",
                    "numeroRenavam": "123123",
                    "placa": "ABC123",
                    "numeroChassi": "3123213"
                }
            ]
        }
    }
]
```


### POST /veiculos

**Descrição:** Cria um novo veiculo.

**Exemplo de Requisição:**

JSON

```
{
    "numeroGravame" : "23213213",
    "numeroRenavam" : "123123",
    "placa" : "ABC123",
    "numeroChassi" : "3123213",
    "contrato": {
        "id" : 1
    }
}


```


**Exemplo de Resposta:**

JSON

```
{
    "id": 6,
    "numeroGravame": "23213213",
    "numeroRenavam": "123123",
    "placa": "ABC123",
    "numeroChassi": "3123213",
    "contrato": {
        "id": 1,
        "nomeDevedor": null,
        "dataNascimentoDevedor": null,
        "numeroRegistroEletronico": null,
        "veiculo": null
    }
}

```


### PUT /veiculos/{id}

**Descrição:** Atualiza um veiculo existente pelo ID.

**Exemplo de Requisição:**

Bash

```
http://localhost:8080/veiculos/2
```

JSON

```
{   
{
    "numeroGravame" : "NUMERO ATUALIZADO",
    "numeroRenavam" : "123123",
    "placa" : "ABC123",
    "numeroChassi" : "3123213",
    "contrato": {
        "id" : 1
    }
}
}

```


**Exemplo de Resposta:**

JSON

```
{
    "id": null,
    "numeroGravame": "NUMERO ATUALIZADO",
    "numeroRenavam": "123123",
    "placa": "ABC123",
    "numeroChassi": "3123213",
    "contrato": {
        "id": 1,
        "nomeDevedor": null,
        "dataNascimentoDevedor": null,
        "numeroRegistroEletronico": null,
        "veiculo": null
    }
}

```


### DELETE /recursos/{id}

**Descrição:** Exclui um veiculo pelo ID.

**Exemplo de Requisição:**

Bash

```
DELETE http://localhost:8080/veiculos/2

```


**Exemplo de Resposta:**

```
DELETED
```








## 🛠️ Construído com

-   **Java SpringBoot**
-   **Postgres**
-   **Maven** 
-   **Docker** 

----------

 Feito com ❤️ por [André Guil](https://github.com/Guil61) 
