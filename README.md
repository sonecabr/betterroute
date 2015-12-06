![WmTest](grapHA.gif?raw=true)

![Build Status](https://travis-ci.org/sonecabr/betterroute.svg?branch=master)


## Motivação

Para este app foi usado jboss, hibernate, hipster4j

O uso do hibernate foi motivado pelo fato de estar embedado no jboss e possibilitar facil acesso à base de persistencia

A base de dados usada foi um Mysql por ser a mais comum e mais simples de rodar, considerando que se trata de um app de exemplo

Usaria uma base NoSql em casos onde a carga for elevada

O hipster4J foi usado por implementar o algoritmo Dijkstra ( o mais comum para o problema em questão)

Os webservices foram construidos em Rest/Json, por ser atualmente o tipo mais usado para aplicações Web.

A framework de Rest usado foi o Resteasy por estar embedado no Wildfly

Vale considerar que esta arquitetura é apenas de escopo simples e não atende a um sistema em produção, nem atende a requisitos de escala horizontal

Não me preocupei em criar uma camada de sec por não ter insumos deste requisito


## Pre requisitos

Java 8 [Java 8](https://www.java.com/pt_BR/download/)

Wildfly9 [Wildfly8 Download](http://download.jboss.org/wildfly/9.0.2.Final/wildfly-9.0.2.Final.tar.gz)

Mysql (yum install mysql ou [Mysql Download] (http://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.9-1.fc22.x86_64.rpm-bundle.tar)

## Preparando as dependencias

1- Adicionar a lib do mysql ao Jboss

1.1 - Descompacte o arquivo `resources/wildfly-9.0.2.Final/mysql4Wildfly.zip para ${wildfly.home}/modules/`

2 - Adicione o xml de start ao standalone do wildfly

2.1 - Copie o arquivo `resources/wildfly-9.0.2.Final/standalone/configuration/wmtest.xml` para `${wildfly.home}/standalone/configuration/`

## Rodando o Jboss

`sh ${wildfly.home}/bin/standalone.sh -c wmtest.xml -b 0.0.0.0 -bmanagement 0.0.0.0`

## Aplicando o deploy

Opção 1 : Copie o arquivo `resources/wildfly-9.0.2.Final/standalone/deployments/wm-api-1.0-SNAPSHOT.war` para `${wildfly.home}/standalone/deployments/`

Opção 2 (via maven): execute na pasta principal do projeto ` mvn clean install && mvn -f wm-api/pom.xml wildfly:deploy`

## Verificando o status da aplicação

`GET http://localhost:8080/wm-api-1.0-SNAPSHOT/probe`

* O retorno esperado é `{"status": "OK"}`

## Consumindo a api

1 - Alimentando as rotas

1.1 - Adicinar n rotas

`PUT http://localhost:8080/wm-api-1.0-SNAPSHOT/route/_bulk
[
    {
        "name": "F",
        "neighbor": "G",
        "distance": 15,
        "parentName": "São Paulo"
    },
    {
        "name": "G",
        "neighbor": "H",
        "distance": 15,
        "parentName": "São Paulo"
    }
]
`

1.2 - Adicionar/atualizar uma rota

`PUT http://localhost:8080/wm-api-1.0-SNAPSHOT/route
{
    "name": "F",
    "neighbor": "G",
    "distance": 15,
    "parentName": "São Paulo"
}
`

Para atualizar é necessário informar o id retornado no cadastro

`PUT http://localhost:8080/wm-api-1.0-SNAPSHOT/route
{
    "id":1,
    "name": "F",
    "neighbor": "G",
    "distance": 15,
    "parentName": "São Paulo"
}
`
2 - Listando as rotas por dominio

`GET http://localhost:8080/wm-api-1.0-SNAPSHOT/route/list/São Paulo`

3 - Encontrando a melhor rota

`POST http://localhost:8080/wm-api-1.0-SNAPSHOT/route/best
{
    "parentName":"São Paulo",
    "start":"A",
    "end":"D",
    "autonomy":10,
    "gasCost":2.5
}
`

## Dúvidas?
`devel.andrerocha@gmail.com`







