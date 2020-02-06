# Front

Esse projeto foi criado usando Angular: [Angular CLI](https://github.com/angular/angular-cli) version 8.3.24.

## Server front

Executar `ng serve` no terminal. Navegar para `http://localhost:4200/`.
Em alguns casos, é necessário executar  npm install --save @angular-devkit/build-angular

## Back
Executar a aplicação Java (ProvaApplication), irá rodar na porta 8080.
Utilizado banco local h2, tive problemas com o MySQL em minha máquina.

## Exercício

Requisito 1:
Criar uma aplicação Web;
Utilizar alguma linguagem de programação web (preferencialmente Java EE);
Utilizar o banco MySQL;
Utilizar Angular 6+ (preferencialmente a última versão disponível).
Cenário 1:
Dado que sou um solicitante;
Preciso solicitar a compra de pilhas AAA.
O sistema deve possibilitar registrar: “Nome do solicitante”, “Descrição do item” (texto livre) e
“Preço do produto” (texto livre com máscara de “R$ XX,XX”).
Obs.:
 Não há necessidade de editar ou excluir os produtos através do sistema, apenas incluir a
solicitação.
 Dados não especificados no cenário (como o tipo de dado numérico ou alfanumérico) ficam
a seu critério.
Cenário 2:
Dado que sou Almoxarife, aprovador de solicitações de compra.
Preciso aprovar ou reprovas as solicitações;
O sistema deve possibilitar que o aprovador selecione uma ação para a solicitação (Aprovar ou
Reprovar).
Obs.: A tela do aprovador deve ser idêntica a tela do usuário solicitante, porém com todos os
campos já preenchidos como readonly, e ainda com dois campos adicionais:
 Um campo do tipo select com as options “Aprovar” e “Reprovar”.
 Um campo de Observações, que o aprovador precisa preencher de forma obrigatória,
apenas se a solicitação for reprovada.
Cenário 3:
Dado que sou um usuário da área do setor administrativo.
Quero consultar os fluxos de solicitação de compra de material de escritório.
O sistema deve ter uma página para que possa realizar a consulta de todos os dados das
solicitações.
Obs.: A página do usuário administrativo deve possibilitar filtrar por status do fluxo (Aprovados e
reprovados), nome do solicitante e descrição do item.
