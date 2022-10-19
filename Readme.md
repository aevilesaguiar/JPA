## Curso Java 2022 COMPLETO: Do Zero ao Profissional + Projetos!


## Padrão DAO(Data Acces Object)

O objetivo do DAO é isolar todo o código de acesso a dados fornecendo para a aplicação métodos de mais alto nivel de fácil chamada.
Sem se preocupar com o que ocorre no Banco de dados.

JDBC é um requisito o DAO.


## JPA (JAVA PERSISTENSE API)

Especificações do JPA

Padrão de Projeto Data Mapper.
ORM Mapeamento Objeto Relacional

JPA (ou Java Persistence API) é uma especificação oficial que descreve como deve ser o comportamento dos frameworks de
persistência Java que desejarem implementá-la.

Ser uma especificação significa que a JPA não possui código que possa ser executado.

Por analogia, você pode pensar na especificação JPA como uma interface que possui algumas assinaturas, mas que precisa
que alguém a implemente.

Apesar de não ter nada executável, a especificação possui algumas classes, interfaces e anotações que ajudam o
desenvolvedor a abstrair o código.

São artefatos do pacote javax.persistence que ajudam a manter o código independente das implementações da especificação.

Assim não precisamos importar classes de terceiros em nosso código.

Implementação é quem dá vida para a especificação. É o código que podemos executar, que chamamos de framework.

Enfim, para persistir dados com JPA, é preciso escolher uma implementação que é quem, de fato, vai fazer todo o trabalho.

Mapeamento Objeto Relacional é a representação de uma tabela de um banco de dados relacional através de classes Java.

É também conhecido como ORM ou Object Relational Mapping.

Banco de dados	Linguagem Orientada a Objetos

Tabela  	Classe
Coluna   	Atributo
Registro	Objeto

Para completar, temos as anotações que adicionarão metadados às classes e permitirão os frameworks ORM, como Hibernate ou EclipseLink, entrarem em ação.

Algumas muito usadas são:

@Entity
@Table
@Id
@Column

## Data mapper

Data Mapper trata da forma como você controla a sua camada de persistencia em um projeto Orientado a Objetos em bases Relacionais.
O Data Mapper Pattern é um padrão arquitetural introduzido por Martin Fowler em seu livro Patterns of Enterprise Application Architecture .
Um Mapeador de Dados é um tipo de Camada de Acesso a Dados que realiza transferência bidirecional de dados entre objetos na
memória e armazenamento persistente. Com o Padrão Mapeador de Dados, os objetos na memória não têm ideia de que existe um banco
de dados e o esquema do banco de dados não tem conhecimento de nenhum objeto que o utilize. Essa separação é o objetivo
principal de um Mapeador de Dados.

ORM : a ideia de você mapear cada um dos atributos e cada Objeto que representa o modelo da sua aplicação e mapear isso para a tabela dos BD.


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

## Relacionamentos

@OneToOne
@OneToMany - @ManyToOne
List
@ManyToMany


@JoinColumn() : anotação especifica para mapear uma coluna que representa uma relação entre duas tabelas

@OneToOne(cascade = {CascadeType.PERSIST}) : através da propriedade cascade você consegue gerar inserções , atualizações em cascata.

Não existe relacionamento bidirecional em BD caso contrário viola os princípios de BD. Usamos o mappedBy 
senão ele irá gerar um atributo dentro de assento chamado cliente_id e ele cria a coluna nas duas tabelas,
gera inconsistencia de dados.

MappedBy: Relação bidirecional que já foi mapeada em outro atributo indicamos com mappedBy aí incluimos o nomes do
outro atributo . ex:

A partir do mappedBy conseguimos definir uma relação bidirecional

//classe Cliente( atributo assento)

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "assento_id", unique = true)
    private Assento assento;     <-


//classe Assento( atributo cliente)
                               
a relação 1:1 está mapeada pelo o atributo assento dentro da classe Cliente

        @OneToOne(mappedBy = "assento")    <-
        private Cliente cliente;

Relação 1:1 mas o atributo que realmente mapeia essa relação 1:1 é o atributo assento que está na outra classe 
como mostra acima.


## Carregamento tardio(lazi) VS Carregamento Apressado( eager)

quando temos uma relação 1:1 ou n:1 ( eager) ->     @ManyToOne(fetch = FetchType.EAGER)   o fetch de uma relação toOne padrão é eager

Ex:
@ManyToOne(fetch = FetchType.EAGER)
private Produto produto;

quando temos 1:n ou n:1 (lazing) ->  @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)  o fetch de uma relação toMany padrão é Lazy
Porque é uma lista de itens ele não vai trazer por que pode ser dezenas de informações, ele deixa para que o usuario de forma explicita solicite através do get ou outros...
ex:
@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
private List<ItemPedido> itens=new ArrayList<>();


## Junção de Tabela

    @JoinTable(name = "atores_filmes")

Apenas para servir como referencia

@ManyToMany
@JoinTable(
//temos chaves primárias que vem de duas tabelas diferentes filme e ator indo para uma tabela intermediária que é atores_filmes
//joinColumns = @JoinColumn(name ="" ,referencedColumnName ="" ), está relacionada com a classe que estou agora que é Filme
//onde @JoinColumn(name = "filme_id é o nome da coluna", referencedColumnName = "id que é a coluna que ela se referencia dentro da tabela filmes é a coluna chamada id(atributo) "
//já o inverseJoinColumns = @JoinColumn(name = "ator_id é o nome da coluna", referencedColumnName = "id que é a coluna que ela se referencia dentro da tabela filmes é a coluna chamada id(atributo)")) é o inverso daquilo que vem da outra entidade que é a classe Ator
name = "atores_filmes",
joinColumns = @JoinColumn(name ="filme_id" ,referencedColumnName ="id" ),
inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id"))
private List<Ator> atores = new ArrayList<>();

## Named Query

https://www.baeldung.com/hibernate-named-query  



Referencia

<query>
//lembrando que não é o nome da tabela é sim o nome da Entidade(Classe nesse caso Filme)
        select f from Filme f
        join fetch f.atores  (atores são o atributo)
        where f.nota >:nota  (esses dois pontos é para passar parametro par a consulta)
</query>

## Embeddable

A JPA fornece a anotação @Embeddable  para declarar que uma classe será incorporada por outras entidades.

ou seja não preciso anotar nas tabelas onetoMany.... eu incluo apenas o tipo e ele já deduz que a mesma incorpora


## Inheritance( herança)

@Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  ESTRATÉGIA PADRÃO GERA DUAS TABELAS
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  -> cria apenas uma tabela

@Inheritance(strategy = InheritanceType.Joined)  -> cria duas tabelas (os dados comuns fica na tabela principal)

@DiscriminatorValue("AL") : essa anotação ajuda a discriminar as tabelas.


## Observações

- TodoList: Estudar sobre : NamedQuery e NamedNativeQuery ( não entendi o funcionamento com o arquivo xml)
- TodoList: jpql
