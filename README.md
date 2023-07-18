# Aplicação de cadastro de veículo

Esta é uma aplicação de cadastro desenvolvida em Java, 
utilizando JavaFX para a interface gráfica e banco de dados Postgres 
para armazenar os registros. A aplicação permite cadastrar veículos, 
modelos e marcas, além de realizar alterações e exclusões nos 
registros existentes. Há três abas na tela de cadastro, correspondendo 
a cada entidade.

## Tecnologia
* Java 19 ou superior
* JavaFX
* PostgreSQL - instalado e configurado
* IntelliJ IDEA Community Edition 2022.3.2

## Utilização da Aplicação
Após executar a aplicação, a tela de cadastro será exibida, 
contendo três abas: Veículo, Modelo e Marca.
* Na aba Veículo, preencha os campos necessários e clique em 
"Salvar" para cadastrar um novo veículo. Os campos obrigatórios serão validados, assim como campos numéricos.
* Na aba Modelo, preencha os campos necessários, incluindo o ID do 
veículo ao qual o modelo pertence. Clique em "Salvar" para cadastrar 
um novo modelo. O ID do veículo será validado.
* Na aba Marca, preencha os campos necessários, incluindo o ID do 
modelo ao qual a marca pertence. Clique em "Salvar" para cadastrar 
uma nova marca. O ID do modelo será validado.

### Obs:
É possível realizar alterações nos registros existentes dando dois 
cliques no registro desejado. Após efetuar as alterações, clique em 
"Salvar" para atualizar o registro.
Para excluir um registro, é necessário excluir primeiro a marca, 
depois o modelo e, por fim, o veículo. Clique no botão "Excluir" 
correspondente ao registro que deseja remover.
## Notas
Certifique-se de fornecer as dependências corretas do JavaFX ao 
compilar e executar o projeto.
Os alertas para campos obrigatórios, campos numéricos e registros 
duplicados já estão implementados na aplicação.




