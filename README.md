## Observabilidade
[![CI Pipeline](https://github.com/dsamuel32/spring-observability/actions/workflows/ci.yml/badge.svg)](https://github.com/dsamuel32/spring-observability/actions/workflows/ci.yml)
[![Release](https://github.com/dsamuel32/spring-observability/actions/workflows/cd.yml/badge.svg)](https://github.com/dsamuel32/spring-observability/actions/workflows/cd.yml)
### Tecnólogias Utilizadas
### Tecnólogias Utilizadas
* Spring Boot 3
* Elastic Stack (Elastic Search, Kibana, Logstash, Filebeat)
* Docker

### Arquitetura
* Clean architecture

 
### Como executar o projeto

* Criar uma conta no [Sportify](https://developer.spotify.com/documentation/web-api)
* Obter as credenciais
* Prencher   ``` CLIENT_ID ```
* Prencher   ``` CLIENT_SECRET ```
* No arquivo ``` .env ``` localizado no diretório ``` sandbox/app/.env ```

#### Executar o arquivo para Linux/Mac

``` ./run.sh ```

#### Executar o arquivo para Windows

``` ./run.bat ```

Após inicialização do Kibana é necessário criar um index pattern do Logstash chamado ``logstash-*``
e selecionar o ``@timestamp``. Depois dessas configurações pode acessar a opção  `` Analitics -> Discover``

#### Request da API
``` curl --location 'localhost:8080/artists?artistsName=pitty&itemsPerPages=10&pageNumber=0' ```
