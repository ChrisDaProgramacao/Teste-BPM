# Desafio BPM

Este repositório foi criado para entregar o desafio passado pela Fábrica de Software, onde eu deveria criar um sistema de solicitações de produtos.

## Front End

Esse projeto foi desenvolvido usando Angular na versão 8.3.24.

## Execução Font End

Para executar o server do Angular, deve-se navegar para a pasta onde se encontra o Front-End: `frontend` e abrir um terminal (cmd, node, git bash ou PowerShell).
Executar `ng serve` no terminal. Navegar para `http://localhost:4200/`.
Em alguns casos, é necessário executar  `npm install --save @angular-devkit/build-angular`

## Execução Back End

Para executar o Back-End em ambiente de desenvolvimento, deve abrir o projeto localizado na pasta: `backend`. No meu caso, utilizei o [eclipse](https://www.eclipse.org/) para abrir o projeto.
Para iniciar o servidor, deve-se executar a classe ProvaApplication.java como uma aplicação java, o servidor irá executar na porta 8080.
O banco de dados utilizado foi o H2, um banco de dados em memória para um melhor desempenho neste desafio, não necessitando prévia configuração de uma base de dados para executá-lo.

## Execução da aplicação

Para testar a aplicação, deve-se navegar para `http://localhost:4200/`, haverá uma Navbar acima da página, onde deve selecionar o Usuário que deseja entrar. Selecionando "Solicitante", abrirá uma página onde deve inserir o nome do solicitante, o valor do item e a descrição do item. Selecionando "Aprovador", abrirá uma página que trará os itens inseridos e aparecerá a opção de aprovar ou reprovar a solicitação. Selecionando "Administrador", abrirá um pequeno filtro para selecionar os aprovados, os reprovados ou filtrar pelo nome do item.

## Exercício

Requisito 1:

Criar uma aplicação Web;

Utilizar alguma linguagem de programação web (preferencialmente Java EE);

Utilizar o banco MySQL;

Utilizar Angular 6+ (preferencialmente a última versão disponível).


## Cenário 1:

Dado que sou um solicitante;

Preciso solicitar a compra de pilhas AAA.

O sistema deve possibilitar registrar: “Nome do solicitante”, “Descrição do item” (texto livre) e
“Preço do produto” (texto livre com máscara de “R$ XX,XX”).

Obs.:
* Não há necessidade de editar ou excluir os produtos através do sistema, apenas incluir a
solicitação.

* Dados não especificados no cenário (como o tipo de dado numérico ou alfanumérico) ficam
a seu critério.

## Cenário 2:

Dado que sou Almoxarife, aprovador de solicitações de compra.

Preciso aprovar ou reprovas as solicitações;

O sistema deve possibilitar que o aprovador selecione uma ação para a solicitação (Aprovar ou
Reprovar).

Obs.: A tela do aprovador deve ser idêntica a tela do usuário solicitante, porém com todos os
campos já preenchidos como readonly, e ainda com dois campos adicionais:

* Um campo do tipo select com as options “Aprovar” e “Reprovar”.

* Um campo de Observações, que o aprovador precisa preencher de forma obrigatória,
apenas se a solicitação for reprovada.

## Cenário 3:

Dado que sou um usuário da área do setor administrativo.

Quero consultar os fluxos de solicitação de compra de material de escritório.

O sistema deve ter uma página para que possa realizar a consulta de todos os dados das
solicitações.

Obs.: A página do usuário administrativo deve possibilitar filtrar por status do fluxo (Aprovados e
reprovados), nome do solicitante e descrição do item.
