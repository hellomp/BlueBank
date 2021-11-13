# Desafio final da PanAcademy

Um desafio que consiste em criar uma API para gerenciamento de contas bancárias e suas respectivas transações.

## Sobre este repositório

Este repositório foi construído não só para cumprir o desafio final do bootcamp de `Java + Spring + AWS` ministrado pela [Gama Academy](https://www.gama.academy/) em conjunto com o [Banco Pan](https://www.bancopan.com.br/), mas também porque nos propusemos a sermos desafiados por nós mesmos com relação ao nosso trabalho em equipe e, obviamente, em conhecimentos técnicos referentes às ferramentas usadas.

Este repositório contém não só o código principal da aplicação, mas também uma documentação que visa explicar o processo de concepção e de desenvolvimento do projeto, incluindo, além das explicações referentes a ferramentas e métodos técnicos, explicações referentes a ferramentas e métodos de gestão.

>_Logo abaixo você encontrará um índice com explicações mais detalhadas sobre o que foi mencionado :)_

## Instruções para instalação e execução

Caso vocẽ queira executar o projeto na sua própria máquina basta ter pelo menos o `JDK` instalado e alguma `IDE` de sua preferência

Você poderá obter o JDK pelos seguintes meios:
- [Website da Oracle](https://www.oracle.com/java/technologies/downloads/)
- [Website do OpenJDK](https://openjdk.java.net/)
- [Usando a Ferramenta SDKMAN](https://sdkman.io/)

>_Guiá-lo por todo o processo de instalação dessa ferramenta e correção de eventuais problemas estão além do escopo deste guia._

Caso você já tenha o JDK instalado e já esteja familiarizado com o uso de uma IDE basta importar o projeto e executar sua classe principal.

Uma página descrevendo cada possível `requisição` em cada possível `endpoint` deverá estar acessível a partir do endereço [127.0.0.1:8080](http://127.0.0.1:8080) no seu navegador.

Apesar de poder ser executado localmente, este projeto foi feito para ser implantado em um servidor remoto da AWS
(to-do: isso deveria ter uma marcação de anotação ?)

(to-do: explicar rapidamente o processo de deploy na AWS)

## Como contribuir

1. Faça um `fork` deste repositório clicando [aqui](https://github.com/IcaroPablo/BlueBank/fork) e clone-o na sua máquina pessoal
```console
$ git clone https://github.com/alanomenezes/BlueBank.git
```
3. Crie uma `branch` para implementar a sua contribuição (apenas por boa prática, mas você pode simplesmente modificar sua branch `main`)
```console
$ git checkout -b my-new-feature-branch
```
3. Dê commit na sua contribuição
```console
$ git commit -am 'Add some feature'
```
4. Dê um push para seu repositório remoto
```console
$ git push origin my-new-feature-branch
```
5. Crie um novo pull request para este repositório a partir do repositório do seu fork

## Autores

Este repositório foi construído colaborativamente pelos seguintes membros: [Alano Menezes](https://github.com/alanomenezes), [Marcos Paulo](https://github.com/hellomp), [Hellimateas Chaves](https://github.com/Hellimateas), [Pedro Henrique](https://github.com/PedroHenriquebc) e [Ícaro Pablo](https://github.com/IcaroPablo).

### BlueBank

O banco fictício BlueBank está construindo uma nova plataforma e precisa de
uma API para gerenciar as transações. Utilize suas novas habilidades com Java, Banco
de dados e AWS.
O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais e
dados para contato. O cliente deve ser atrelado a uma conta bancária e registrar
histórico de transações entre as contas.



#### SUGESTÃO DE ORGANIZAÇÃO DO PROJETO

Elaboração do kanban com definição dos entregáveis
\1. Elaboração do kanban(sugestão de utilização: Trello,Jira, etc)
\2. Criação do backlog(com tarefas referente ao desenvolvimento)
\3. Detalhamento descritivo das tarefas da squad dentro dos seus cards (e
não apenas com títulos genéricos no card)-Nome para a squad
\4. Formatação do kanban padrão "to do, doing, done"
\5. Definição de data de entrega das tarefas nos cards
\6. Definição de responsável pelo card ou checklist de completude
\7. Priorização dos cards (ex: tags com cores para maior relevância ou com
títulos descritivos para nível de importância na priorização)



#### ENTREGAS MÍNIMAS

\1. Metodologias Ágeis:
a. Kanban com todas as tarefas organizadas e responsáveis definidos.
\2. Back-end:
a. Cadastro de clientes
b. Listagem de clientes
c. Atualização de clientes
d. Deletar clientes
e. Histórico de transações entre contas

\3. Banco de Dados:
a. Tabelas bem estruturadas e populadas com valores para testes.
b. O Banco deve ser entregue em script SQL junto ao repositório.
\4. Gerais:
a. O código deve ser entregue em um repositório no Github.
b. AAPIdeveserdisponibilizadaemambienteAWScomEC2eemBeanstalk.
c. A aplicação deve ter um pipeline em Jenkins ou no Aws Build.
d. A aplicação precisa ser configurada no API Gateway da AWS.
e. A aplicação precisa ter no mínimo um endpoint de SNS para cadastro de
emails e verificação automática.
f. A aplicação precisa ter no mínimo um Lambda.
g. Liste os endpoints no README.md



#### ENTREGA OPCIONAL

\1. Testes automatizados, podem ser testes unitários ou testes de integração.
CRITÉRIOS DE AVALIAÇÃO
\1. Documentação da Aplicação;
\2. Sugestão de documentação com swagger;



=======
## Ferramentas

Java spring boot my sql aws

IDE de desenvolvimento: Eclipse, IntelliJ Versionamento de código:Git e Github Banco de dados: MySQL Software Cliente para banco de dados: DBeaver Hospedagem: Amazon Web Services (AWS) Postman Swagger Cliente SSH: Putty, MobaXTerm Jira: https://dbluebank.atlassian.net/jira/software/projects/DBLUEB/boards/1/roadmap

## Links uteis

Swagger: https://app.swaggerhub.com/organizations/PanAcademy Postman: https://www.postman.com/# RunRunIt: https://runrun.it/pt-BR/user_session/new Github: https://github.com/alanomenezes/BlueBank Clientes SSH: https://mobaxterm.mobatek.net/download.html https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html PhpMyAdmin: http://54.232.238.144/phpMyAdmin/ Git Flow: https://www.atlassian.com/br/git/tutorials/comparing-workflows/gitflow-workflow

## Processos

## Mapas de processos/negócios

## Regras de negócio

