![WmTest](grapHA.gif?raw=true)

[![SonarQube Tech Debt](https://img.shields.io/sonar/http/nemo.sonarqube.org/es.usc.citius.hipster:hipster-pom/tech_debt.svg)](http://nemo.sonarqube.org/dashboard/index/es.usc.citius.hipster:hipster-pom) 
[![Coverage](https://img.shields.io/sonar/http/nemo.sonarqube.org/es.usc.citius.hipster:hipster-pom/coverage.svg)]()
![Build Status](https://api.travis-ci.org/citiususc/hipster.svg?branch=development)


## Motivação

Para este app foi usado jboss, hibernate, hipster4j
O uso do hibernate foi motivado pelo fato de estar embedado no jboss e possibilitar facil acesso à base de persistencia
A base de dados usada foi um Mysql por ser a mais comum e mais simples de rodar, considerando que se trata de um app de exemplo
Usaria uma base NoSql em casos onde a carga for elevada
O hipster4J foi usado por implementar o algoritmo Dijkstra ( o mais comum para o problema em questão)

## Pre requisitos
Java 8 [Java 8](https://www.java.com/pt_BR/download/)
Wildfly9 [Wildfly8 Download](http://download.jboss.org/wildfly/9.0.2.Final/wildfly-9.0.2.Final.tar.gz
Mysql
