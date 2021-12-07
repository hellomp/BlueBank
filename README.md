# Desafio final da PanAcademy

Um desafio que consiste em criar uma API para gerenciamento de contas bancárias e suas respectivas transações.

## Sobre este repositório

Este repositório foi construído não só para cumprir o desafio final do bootcamp de `Java + Spring + AWS` ministrado pela [Gama Academy](https://www.gama.academy/) em conjunto com o [Banco Pan](https://www.bancopan.com.br/), mas também porque nos propusemos a sermos desafiados por nós mesmos com relação ao nosso trabalho em equipe e, obviamente, em conhecimentos técnicos referentes às ferramentas usadas.

Este repositório contém não só o código principal da aplicação, mas também uma documentação que visa explicar o processo de concepção e de desenvolvimento do projeto, incluindo, além das explicações referentes a ferramentas e métodos técnicos, explicações referentes a ferramentas e métodos de gestão.

>_Logo abaixo você encontrará um índice com explicações mais detalhadas sobre o que foi mencionado :)_

## Documentação

As funcionalidades do código estão descritas em uma série de páginas web construídas pela ferramenta [Javadoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html), para ter acesso à documentação do código basta entrar na pasta [/project/doc](./project/doc/) e dar dois clicks no arquivo [`index.html`](./project/doc/index.html), seu navegador deverá fazer o resto ;)

As descrições de cada endpoint estão em uma página web construída pela ferramenta [`Swagger`](https://swagger.io/), esta página pode ser acessada através do link [endpoint do swagger](endpoint do swagger) quando a aplicação estiver em execução ;D

No índice de links a seguir estão detalhes sobre o desafio proposto, o desenvolvimento do projeto e um guia rápido para todos os endpoints que poderão ser igualmente acessado pelo `Swagger`.

- [Descrição do desafio](./documentation/challenge_description.md)
- [Estratégias de gestão e fluxo de trabalho](./documentation/management.md)
- [Ferramentas e técnicas usadas no código](./documentation/project_patterns.md)
- [Deploy na AWS](./documentation/AWS_deploy.md)
- [Lista de endpoints da aplicação](./documentation/endpoint_list.md)

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

>_Apesar de poder ser executado localmente, este projeto foi feito para ser implantado em um servidor remoto da AWS, a descrição do processo está no arquivo [documentation/AWS_deploy.md](./documentation/AWS_deploy.md)_

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

## Licença

Este projeto está licenciado sob a licensa **GPLv3**, veja o arquivo [LICENSE](./LICENSE) para mais detalhes.

## Agradecimentos

Gama academy e banco Pan, por todas essas aulas interessantes, pelos desafios propostos e pela excelente orientação durante todo o percurso do treinamento. Agradecemos especialmente nossos instrutores [Jenifer Plácido](https://www.linkedin.com/in/jenifer-pl%C3%A1cido-00b5611ab/), [Jonathan Ferreira](https://www.linkedin.com/in/jferreira33/) e [Ana Verônica](https://www.linkedin.com/in/ana-ver%C3%B4nica-nascimento-cruz-1896a0158/)
