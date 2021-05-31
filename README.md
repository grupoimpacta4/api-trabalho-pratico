 
 
# Trabalho final API Gateway & Integration

### Como fazer deploy:
Entrar no diret�rio do projeto e rodar
```
mvn spring-boot:run 
```

### Documenta��o da API
Para ver a documenta��o completa da API, entrar no seguinte endere�o
```
http://localhost:8080/swagger-ui/index.html#
``` 

### Observa��es
Para rodar o projeto ser� necess�rio ter o Mysql instalado.   <br/>
As api constru�das precisam de uma api-key para rodar , caso n�o usemos a api-key elas devem retorna 403(Forbidden)  <br/>
Inicialmente utilizamos duas api-key j� pr�-cadastradas em nossos bancos:  <br/>
Api key 1   -  36b5ae58-56a6-43e3-b474-0ffb7b4ae227  <br/>
Api key 2   -  aec093c2-c981-44f9-9a4a-365ad1d2f05e  <br/>  <br/>

Podemos cadastrar mais keys na tabela auth de nosso banco ( api-key , email). 
