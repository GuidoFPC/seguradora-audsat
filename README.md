# Orçamento de seguros Audsat

## Descrição da API

<p align="justify">
  Essa API tem tem o objetivo permitir inicialmente o cadastro e cálculo do orçamento 
  de seguros. O cálculo do orçamento é realizado com base em algumas premissas.
</p>

## Tecnologias utilizadas

- ``Java 8``
- ``Maven 3.8.5``
- ``H2``
- ``Spring Boot 2.7.9``
- ``Lombok``
- ``Swagger``

## Rodando a API

#### O projeto Orçamento de Seguros foi construído com maven. Para rodar o projeto via linha de comando

1. Navegue até a pasta de código fonte:
```sh
Exemplo: {download_folder}\seguradora\codigo-fonte
```

2. Na pasta, execute o comando abaixo:
```sh
mvn install
```

3. Para iniciar o projeto spring boot, execute o seguinte comando:
```sh
mvn spring-boot:run
```

O console do H2 estará disponível em:

<a href="http://localhost:8080/h2-console/" target="_blank">http://localhost:8080/h2-console/</a>

#### A API está pronta para receber requisições rest.

## Documentação SWAGGER

Obs: Para acessar a documentação o projeto deve estar rodando:

<a href="http://localhost:8080/swagger-ui.html" target="_blank">Acesse aqui a documentação Swagger</a>

## REST API
| Endpoint | Método| Descrição |
|----------|--------|------------|
| /insurance/budge | POST  | Cadastro de Orçamento |
| /insurance/budge{id} | DELETE  | Remoção de Orçamento |
| /insurance/budge{id} | GET  | Consulta de Orçamento |
| /insurance/budge{id} | PUT  | Atualização de Orçamento |

#### Exemplos
 - Payload Cadastro de Orçamento
```sh
{
  "car": {
    "model": "Corolla Cross",
    "manufacturer": "Toyota",
    "year": "2023",
    "fipeValue": 270000.00
  },
  "drivers": [
    {
      "document": "1234567890",
      "name": "John Ciclans Silva",
      "birthdate": "1984-11-25",
      "main": true
    }
  ],
  "claims": [
    {
      "document": "1234567890",
      "dtEvent": "2020-04-14T10:45"
    }
  ]
}
```

 - Response com JSON esperado:
```sh
{
  "idInsurance": 1,
  "dtCreation": "2023-02-26T23:12:20.549",
  "dtUpdated": null,
  "car": {
    "idCar": 1,
    "deModel": "Corolla Cross",
    "deManufacturer": "Toyota",
    "nuYear": 2023,
    "vrFipeValue": 270000.00
  },
  "customer": {
    "idCustomer": 1,
    "deName": "John Ciclans Silva",
    "driver": {
      "idDriver": 1,
      "nuDocument": 1234567890,
      "dtBirthdate": "1984-11-25"
    }
  },
  "active": true
  }
}
```

 - Consulta de Orçamento
 ```sh
	/insurance/budget/1
```

 - Response com JSON esperado:
 ```sh
{
  "idInsurance": 1,
  "active": true,
  "dtCreation": "2023-02-26T23:12",
  "dtUpdated": null,
  "car": {
    "idCar": 1,
    "model": "Corolla Cross",
    "manufacturer": "Toyota",
    "year": 2023,
    "fipeValue": 270000.00
  },
  "customer": {
    "idDriver": 1,
    "name": "John Ciclans Silva"
  },
  "vrOrcamento": 27000.0
}
```

## Testes unitários

Testes unitários disponíveis em:
```sh
com.guido.seguradora.SeguradoraApplicationTests
```