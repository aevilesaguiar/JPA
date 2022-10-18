## Observações

EntityManager:gerente das entidades, entidades são as classes que estão mapeadas(orm) com anotações ex: @Entity
EntityManager é o responsável por alterar, inserir, consultar, excluir uma entidade
EntityManager é o responsável por fazer o CRUD a interação com o Banco de Dados
EntityManager representa uma conexão e também a classe que ajuda a persistir os dados no BD

![](../../Users/aesilva/AppData/Local/Temp/Entity-Manager-JPA1.png)

Um Entity Manager é sempre obtido através de um EntityManagerFactory que determina os parâmetros de configuração que vão 
dizer como será o funcionamento do Entity Manager. 

## JPQL

JPQL se parece com SQL, só que você não estará consultando tabela e sim Objeto.
E quem converte o JPQL para SQL será o próprio framework.