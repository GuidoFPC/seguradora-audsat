# springboot

## Descrição do projeto 

<p align="justify">
  Serviço de precificação de seguros audsat
</p>

## Status

<p align="justify">
  Em desenvolvimento
</p>

## Pré-requisitos

- ``Java 8``
- ``Maven``

## Tecnologias utilizadas

- ``Springboot 2.7.0``

## Como rodar a aplicação

- ``1. Em criação``
- ``2. Configure o banco de dados em \backend\src\main\resources\application.properties``

<A documentação desse tópico ainda será concluída>

## EndPoints ([DocumentoController](https://github.com/GuidoFPC/springbootvue/blob/main/backend/src/main/java/br/leg/camara/helloword/controllers/DocumentoController.java))

- ``GET: http://localhost:8180/documentos?page=0&size=5&sort=nome,ASC`` (Recuperar todos)
- ``GET: http://localhost:8180/documentos/{id}`` (Recuperar por id)
- ``POST: http://localhost:8180/documentos`` (Inclusão)
- ``PUT: http://localhost:8180/documentos/{id}`` (Alteração)
- ``DELETE: http://localhost:8180/documentos/{id}`` (Deleção)

## Tarefas em aberto

:memo: 1. Componente de mensagem ( exibir msgs do sistema )

:memo: 2. Paginação

:memo: 3. Ordenação da tabela

:memo: 4. Filtros da tabela