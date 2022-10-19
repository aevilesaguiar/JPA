package model.base.umpraum;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) insert         ou     update: fazer uma operação em cascata tanto para inserir quanto para atualizar
    //    @OneToOne(cascade = {CascadeType.ALL, CascadeType.MERGE}) fazer operações em cascata para todos os cenários, inclusão, exclusão ,update..
    //  @OneToOne(cascade = {CascadeType.PERSIST}) fazer operação em cascata apenas na persistencia
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "assento_id", unique = true)
    private Assento assento;


    public Cliente() {

    }

    public Cliente(String nome, Assento assento) {
        this.nome = nome;
        this.assento = assento;
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

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }
}
