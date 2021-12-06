// Padrões e dependências/pacotes/bibliotecas/plugins

## Ferramentas e Técnicas

Neste arquivo estão descritas algumas ferramentas que usamos ao longo do projeto assim como as razões para a sua aplicação

### Padrões de Projeto e Boas Práticas

- **DTO**: do inglês, Data transfer object, é um padrão de projeto de software usado para transferir dados entre subsistemas de um software. Usar um `DTO` nos permite enviar aos endpoints da aplicação apenas as informações pertinentes sobre as entidades consultadas ou até mesmo alterá-las para que facilitem a compreensão geral do usuário.

- **MVC**: do inglês, Model View Controller, é um padrão de arquitetura de software que define 3 camadas com responsabilidades distintas em uma aplicação. Model, uma estrutura para gerenciar e agrupar os dados que serão utilizados na aplicação. View, uma interface de interação para o usuário que o permitirá acessar os serviços da aplicação de maneira ágiil e prática. Controller, a camada responsável por intermediar as requisições recebidas pelo usuário e chamar os métodos necessários para seu processamento. Essa arquitetura é usada pelo framework que utilizamos, o `Spring`, que será explicado mais a diante.

- **SOLID**: o [`SOLID`](https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530) é um acrônimo para um conjunto de princípios que guiam o desenvolvimento orientado a objetos. São regras simples, mas que facilitam a construção e a manutenção de um código limpo e elegante, permitindo que as implementações de suas funcionalidades possam ser escritas de maneira sucinta.

- **Java Code Conventions**: tentamos, de acordo com nossos conhecimentos, seguir o estilo de código definido pela Sun Microsystems (RIP): [`Java Code Conventions`](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf). O guia é muito extenso então nem todas as orientações puderam ser revisadas pelo nosso time, mas tentamos ao máximo tornar o código legível e elegante usando, por exemplo, nomes de variáveis e assinaturas de métodos bem descritivas escritas em inglês.

- **Mappers**: em certos pontos do código, precisamos passar a informação contida nas entidades difinidas pelo já mencionado `model` aos também já mencionados `DTOs`, há alguns frameworks que realizam essa função com um alto grau de customização até. Porém, por problemas de compatibilidade decidimos implementar nossas próprias classes de `mapping`, elas estão divididas correspondentemente aos models e seus respectivos DTOs.

- exception handling

### Documentação
javadoc
testes com postman insomnia swagger e vscode
teste com junit

anotações transactional

- métodos especiais no repositorio (explicar vantagens dos derived query methods)
- 

explicar o uso da interface de transação

funcionalidades

realizar empréstimo
- clientes, contas e transações só poderão ser criadas e consultadas, nunca deletadas ou editadas
- 
- fazemos consultas por cpf ou cnpj

## Ferramentas
Java spring boot my sql aws

IDE de desenvolvimento: Eclipse, IntelliJ Versionamento de código:Git e Github Banco de dados: MySQL Software Cliente para banco de dados: DBeaver Hospedagem: Amazon Web Services (AWS) Postman Swagger Cliente SSH: Putty, MobaXTerm Jira: https://dbluebank.atlassian.net/jira/software/projects/DBLUEB/boards/1/roadmap
