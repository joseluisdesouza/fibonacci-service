### Bem-vindo(a) ao meu projeto!👋🏽

#### Teste pratico - Fibonacci Service

### ✅Tecnologias usadas para realizar o projeto
As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/pt-BR/)
- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/)  
- [Docker](https://docs.docker.com/desktop/windows/install/)

- ### Pré requisitos

- ### Docker
    docker -v\
    Docker version 20.10.12, build e91ed57
- ### Java 11
    java --version\
    Java(TM) SE Runtime Environment 18.9 (build 11.0.12+8-LTS-237)

### Construir imagem
    docker build -t fibonacci-api .
### Subir aplicação
    docker run -p 8080:8080 fibonacci-api
### Swagger
    http://localhost:8080/swagger-ui/index.html#/

Esta API contem dois endpoints sendo eles:
### GET ​/fibonacci​/{fibonacciIndex} return value
    Passe um valor no indice e de retorno terá o indice
    e o calculo do ultimo numero da sequencia
    EX de retorno:
        {
            "fibonacciIndex": 8,
            "fibonacciValue": 21
        }
    Neste exemplo foi passado o valor 8
### GET ​/fibonacci​/sequence return sequence
    E se caso queira ver a sequencia, passe o valor do indice
    e terá como retorno a sequencia
    EX de retorno:
        [
            1,
            1,
            2,
            3,
            5,
            8,
            13,
            21
        ]