# Orçamento de seguros Audsat

## Descrição da API

<p align="justify">
  Essa API tem tem o objetivo permitir inicialmente o cadastro e cálculo do orçamento 
  de seguros. O cálculo do orçamento é realizado com base em algumas premissas.
</p>

## Pré-requisitos

- ``Java 8``
- ``Maven``

## Tecnologias utilizadas

- ``Java 8``
- ``H2``
- ``Springboot 2.7.9``
- ``Lombok``

## Rodando a API

O projeto Orçamento de Seguros foi construído com maven. 
Para rodar o projeto via linha de comando, navegue até a pasta de código fonte:
```sh
Exemplo: {download_folder}\seguradora\codigo-fonte
```

Na pasta, execute o comando abaixo:
```sh
mvn install
```

Para iniciar o projeto spring boot, execute o seguinte comando:
```sh
mvn spring-boot:run
```

O console do H2 estará disponível em:
```sh
http://localhost:8080/h2-console/
```

A API está pronta para receber requisições rest.

## Documentação SWAGGER

#### Projeto deve estar rodando

<a href="http://localhost:8080/swagger-ui.html" target="_blank">Swagger</a>

## REST API
| Endpoint | Método| Descrição |
|----------|--------|------------|
| /insurance/budge | POST  | Cadastro de Orçamento |
| /insurance/budge{id} | DELETE  | Remoção de Orçamento |
| /insurance/budge{id} | GET  | Consulta de Orçamento |
| /insurance/budge{id} | PUT  | Atualização de Orçamento |

#### Exemplos
 - Payload: Cadastro de Orçamento:
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