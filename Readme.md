## Curso Java 2022 COMPLETO: Do Zero ao Profissional + Projetos!

JPA

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
