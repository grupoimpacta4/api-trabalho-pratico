 


# GRUPO D
Andrade Alves Sampaio
David Stefano Aranda da Silva
Irai Fernandes Daniele
Marília Gabriela Pires Matos
Paolo Angelo Martins



# Trabalho final API Gateway & Integration

### Como fazer deploy:
Entrar no diretório do projeto e rodar
```
mvn spring-boot:run 
```

### Documentação da API
Para ver a documentação completa da API, entrar no seguinte endereço
```
http://localhost:8080/swagger-ui/index.html#
``` 

### Observações
Para rodar o projeto será necessário ter o Mysql instalado.   <br/>
As api construídas precisam de uma api-key para rodar , caso não usemos a api-key elas devem retorna 403(Forbidden)  <br/>
Inicialmente utilizamos duas api-key já pré-cadastradas em nossos bancos:  <br/>
Api key 1   -  36b5ae58-56a6-43e3-b474-0ffb7b4ae227  <br/>
Api key 2   -  aec093c2-c981-44f9-9a4a-365ad1d2f05e  <br/>  <br/>

Podemos cadastrar mais keys na tabela auth de nosso banco ( api-key , email). 
