# Orçamento de seguros Audsat

## Descrição do projeto 

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

## Como rodar a aplicação

O projeto Orçamento de Seguros foi construído na estrura maven. 
Então para rodar o projeto, entre até a pasta de código fonte
```sh
\{download_folder}\seguradora\codigo-fonte
```

Executar o comando abaixo na pasta do código fonte.
```sh
mvn install
```

Iniciar o projeto spring boot.
```sh
mvn spring-boot:run
```

O console do H2 estará disponível em:
```sh
http://localhost:8080/h2-console/
```

## REST API

- ``GET: http://localhost:8080/documentos?page=0&size=5&sort=nome,ASC``
- ``GET: http://localhost:8180/documentos/{id}`` (Recuperar por id)
- ``POST: http://localhost:8180/documentos`` (Inclusão)
- ``PUT: http://localhost:8180/documentos/{id}`` (Alteração)
- ``DELETE: http://localhost:8180/documentos/{id}`` (Deleção)

