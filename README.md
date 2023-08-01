<h1>API de Sistema de Conta Digital</h1>

* [Descrição](#descricao)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Localização dos artefatos requeridos](#artefatos-requeridos)
* [Rodar localmente](#executar-localmente)
* [Endpoints principais](#endpoints)
* [Importar Collections ao Postman](#collections)
* [Exceções personalizadas](#exceptions)
* [População do banco de dados via Mockaroo](#mockaroo)

## Descrição <a name="descricao"></a>
Essa API é um sistema de conta bancária digital que oferece funcionalidades para gerenciamento de contas de clientes e movimentações financeiras. Com ela, é possível criar e atualizar dados de clientes, criar e atualizar contas de clientes, além de permitir a realização de movimentações financeiras de depósito e saque.

##  Principais tecnologias utilizadas <a name="tecnologias-utilizadas"></a>
- Java 20
- Spring Framework 3.1.2
- MySQL
- MapStruct
- OpenAPI (Swagger)
- Flyway

## Localização dos artefatos requeridos <a name="artefatos-requeridos"></a>
O Modelo e Diagrama Entidade Relacionamento estão disponíveis em *src/main/resources/DBModeling* . Os arquivos .brM são arquivos para executar no software de modelagem de banco de dados brModelo.
Já os scripts DDL e DML estão disponíveis em *src/main/resources/DBScripts* . Entretanto, como na API está implementado suporte a migrations via Flyway, com a configuração do banco de dados no arquivo *application.yml* e o banco de dados criado, ao executar a API as migrações irão ser feitas automaticamente. Na pasta *src/main/resources/db/migration* estão os scripts para fazer as migrações, onde os comandos de DDL e DML estão separados, com uma compreensão mais fácil e detalhada.

## 📁 Executar localmente <a name="executar-localmente"></a>
### Pré-requisitos
- Java 20 (Maven)

### Configurações
1. Clone o repositório:

   ```bash
   git clone https://github.com/GelinskiGu/api-BTG-Challenge.git

2. Navegue até o diretório do projeto:

    ```bash
    cd api-Btg-Challenge
    ```

3. Configure o arquivo application-example, que está disponível em: *src/main/resources*. Insira as informações de conexão ao banco de dados MySQL e altere o nome do arquivo para *application.yml*.

4. Compile a aplicação usando Maven:
    ```
    mvn spring-boot:run
    ```

5. Execute o arquivo de inicialização *Startup.java*.

## Endpoints Principais <a name="endpoints"></a>
A documentação da API está detalhada via OpenAPI. Portanto, para acessar a documentação basta ir em *http://localhost:8081/swagger-ui/index.html* com a aplicação em execução.

1. *GET /api/client/v1* retorna uma lista de todos os clientes cadastrados. Possui queryParams opcionais de paginação, sendo /api/client/v1?page=0&size=10 os seus valores padrão.
2. *GET /api/client/v1/{id}* retorna o cliente que possui o Id informado caso exista.
3. *GET /api/client/v1/findByName/{name}* retorna uma lista de todos os clientes que possuem o nome informado.
4. *GET /api/client/v1/findByCpf/{cpf}* retorna uma lista de todos os clientes que possuem parte do CPF informado.
5. *POST /api/client/v1* faz a criação de um cliente enviando o seguinte objeto via body:

  ```
  {
    "email": "<string>",
    "cellPhoneNumber": "<string>",
    "maritalStatus": "<string>",
    "countryBirth": "<string>",
    "cityBirth": "<string>",
    "stateBirth": "<string>",
    "cityAddress": "<string>",
    "additionAddress": "<string>",
    "numberAddress": "<string>",
    "neighborhood": "<string>",
    "stateAddress": "<string>",
    "cpf": "<string>",
    "fullName": "<string>",
    "cep": "<string>",
    "profession": "<string>",
    "income": "<number>",
    "moveableAssets": "<number>",
    "realEstateProperties": "<number>",
    "investments": "<number>",
    "retirementFunds": "<number>",
    "otherPatrimonies": "<number>",
    "numberDocument": "<string>",
    "issuerDocument": "<string>",
    "typeDocument": "<string>",
    "backPhotoDocument": "<string>",
    "frontPhotoDocument": "<string>",
    "dateBirth": "<dateTime>",
    "selfiePhoto": "<string>",
    "otherNationality": "<string>",
    "euataxAddress": "<string>"
  }
  ```
Sendo que os atributos additionAddress, moveableAssets, realEstateProperties, investments, retirementFunds, otherPatrimonies, otherNationality e euataxAddress são opcionais e podem ser nulos. A data de nascimento segue o formato yyyy-mm-dd.

6. *PUT /api/client/v1* faz a atualização de um cliente. Recebe via body um json do mesmo formato mencionado anteriormente, porém, com a adição do campo Id do cliente desejado a ter suas informações alteradas.

7. Nos endpoints relacionado a entidade Account, existe as operações de GET para listar todas as contas, para fazer consulta de contas via Id da conta e, para fazer consulta de todas as contas que um cliente possui passando o Id do cliente.

8 *POST /api/account/v1* faz a criação de uma conta passando o seguinte objeto:
  ```
  {
    "bankNumber": "<string>",
    "accountNumber": "<string>",
    "branchNumber": "<string>",
    "typeAccount": "<string>",
    "status": "<string>",
    "client_id": "<long>"
  }
  ```
Por padrão, o saldo da conta é inicializado sendo 0 e o status da conta vem como "Active".

9. *PUT /api/account/v1* faz a atualização de uma conta. Os dados que são possíveis de serem alterados são apenas o status da conta e o tipo da conta. Dado como saldo da conta apenas é alterado via movimentações de transações e, dados referente a identificação da conta como número bancário são imutáveis. Portanto, o objeto que deve ser enviado é do tipo:
  ```
  {
    "typeAccount": "<string>",
    "status": "<string>",
  }
  ```
Sendo que typeAccount ou é "Investiment" ou é "Checking". Status ou é "Active" ou "Disable".

10. Relacionado a entidade Transaction, a API suporta endpoints de GET relacionados a listagem de todas as transações, retorno de uma transação específica por meio de seu Id, ou listagem de todas as movimentações de uma conta em específico, informando o Id da conta no endpoint */api/transaction/v1/findTransactionsByAccountId/{accountId}*.

11. *POST /api/transaction/v1* cadastra uma nova movimentação. É necessário passar o seguinte JSON:
  ```
  {
    "amount": "<number>",
    "transactionType": "<string>",
    "account_id": "<long>"
  }
  ```
Os tipos suportados para transação são: "D" (para "Deposit") e "W" (para "Withdraw"). Caso seja feito uma requisição de saque e a conta não possua valor suficiente irá ser retornado um status code 403: Forbidden com a mensagem que o saldo é insuficiente para fazer esse saque.

## Importar Collections ao Postman <a name="collections"></a>
No diretório *src/main/resources/Collections* estão as collections.json e enviroment.json que podem ser importadas para o Postman, para uma maior facilidade de requisições.

## Exceções Personalizadas <a name="exceptions"></a>
No diretório *src/main/java/exceptions* existem três classes de exceção para retornar erros 400, 403 ou 404 para a API detalhar de forma mais clara os erros ocorridos durante as requisições.

## População do Banco de Dados via Mockaroo <a name="mockaroo"></a>
Para uma testagem mais realista das funcionalidades da API, foi feito uma injeção de dados com dados fictícios utilizando a ferramenta Mockaroo. Através dessa ferramenta, foi feito o cadastro de 500 clientes diferentes e, também, o cadastro de 500 contas diferentes, sendo que para as contas foi feito também um tratamento de dados via querys SQL para que não exista um cliente com mais de 2 contas ("Investiment" e "Checking") e, também, para que não tenham contas do mesmo tipo.

### Dados Gerados
Foram criados 500 clientes diferentes, cada um com informações pessoais e financeiras únicas. Além disso, foram criadas 500 contas distintas, garantindo que cada conta estivesse vinculada a um cliente específico.

### Tratamento de Dados
Para garantir a integridade dos dados gerados, foi aplicado um tratamento adicional aos registros das contas. As seguintes regras foram implementadas:

1. Limite de duas contas por cliente: Cada cliente foi associado a no máximo duas contas (por exemplo, "Investimento" e "Checking").

2. Tipos de conta únicos: Não foram permitidas contas do mesmo tipo (por exemplo, não há dois registros "Investimento" para o mesmo cliente).

Essas medidas de tratamento de dados ajudaram a criar um conjunto de dados mais realista e consistente para a avaliação da API.

Por fim, é importante ressaltar que esses dados são totalmente fictícios e gerados exclusivamente para fins de teste e demonstração da API.
