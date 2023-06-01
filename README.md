### Pré requisitos

* Intellij IDE -> IDE utilizada para desenvolver o script de automação
* maven -> gerenciador de dependências
* java -> linguagem utilizada

### Executando os teste

* Pode ser encontrado no pacote runner um arquivo chamado SuiteTest basta executa-lo como Runner Test.

### Arquitetura

* Client -> Pacote com o padrão de projeto Client utilizado para te metodos abstratos para que possa sem ser utilizados em outras classes
* Builder -> Pacote com o padrão de projeto Builder para construção de objetos complexos
* DTO -> Onde tem os atributos que vão ser criados o payload para as requisições (somente atributos obrigatórios)
* Enum -> Contém um enumerador com os status code
* Utils -> contém metodos reutilizaveis (utilitários)

### Executando por linha de comando

* mvn test

### Autor

* Alexandre 
