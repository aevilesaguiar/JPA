package model.base.muitoparamuitos;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double nota;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            //temos chaves primárias que vem de duas tabelas diferentes filme e ator indo para uma tabela intermediária que é atores_filmes
            //joinColumns = @JoinColumn(name ="" ,referencedColumnName ="" ), está relacionada com a classe que estou agora que é Filme
            //onde @JoinColumn(name = "filme_id é o nome da coluna", referencedColumnName = "id que é a coluna que ela se referencia dentro da tabela filmes é a coluna chamada id(atributo) "
            //já o inverseJoinColumns = @JoinColumn(name = "ator_id é o nome da coluna", referencedColumnName = "id que é a coluna que ela se referencia dentro da tabela filmes é a coluna chamada id(atributo)")) é o inverso daquilo que vem da outra entidade que é a classe Ator
            name = "atores_filmes",
            joinColumns = @JoinColumn(name ="filme_id" ,referencedColumnName ="id" ),
            inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id"))
    private List<Ator> atores = new ArrayList<>();

    public Filme() {
    }

    public Filme(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        //esse método garante que ele sempre traga uma lista válida mesmo que seja vazia ou seja nunca retornará algo nulo

        //se atores forem nulos crie uma lista vazia
        if(atores==null){
            atores=new ArrayList<>();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    //criar método que adiciona ator para evitar que façamos isso na classe main
    public void adicionarAtor(Ator ator){

        //se ator for diferente de null e e ele não está incluido na lista de atores desse filme
        if(ator != null && !getAtores().contains(ator)) {
            getAtores().add(ator);

            //senão contém o filme atual ele adiciona o filme
            if(!ator.getFilmes().contains(this)){
            ator.getFilmes().add(this);

            }
        }
    }

}
