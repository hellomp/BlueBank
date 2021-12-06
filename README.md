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

(to-do: instalação do banco de dados)

Apesar de poder ser executado localmente, este projeto foi feito para ser implantado em um servidor remoto da AWS
(to-do: isso deveria ter uma marcação de anotação ?)

(to-do: explicar rapidamente o processo de deploy na AWS)

## Documentação

[Javadoc](./project/doc/index.html)
swagger

[Descrição do desafio](./documentation/challenge_description.md)
[gestão](./documentation/management.md)
[Ferramentas e técnicas](./documentation/project_patterns.md)
[Lista de Endpoints](./documentation/endpoint_list)

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

(to-do: tópicos para licença e agradecimentos, localizar o índice da documentação)

## Autores

Este repositório foi construído colaborativamente pelos seguintes membros: [Alano Menezes](https://github.com/alanomenezes), [Marcos Paulo](https://github.com/hellomp), [Hellimateas Chaves](https://github.com/Hellimateas), [Pedro Henrique](https://github.com/PedroHenriquebc) e [Ícaro Pablo](https://github.com/IcaroPablo).
