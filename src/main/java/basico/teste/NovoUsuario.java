package basico.teste;

import model.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {

        //seu papel é criar o EntityManager fabrica de gerente de entidade
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("exerciciosjpa");

        //EntityManager:gerente das entidades, entidades são as classes que estão mapeadas(orm) com anotações ex: @Entity
        //EntityManager é o responsável por alterar, inserir, consultar, excluir uma entidade
        //EntityManager é o responsável por fazer o CRUD a interação com o Banco de Dados
        //EntityManager representa uma conexão e também a classe que ajuda a persistir os dados no BD
        EntityManager em= emf.createEntityManager();

        Usuario u1= new Usuario("Arthur","arthur@mail.com");
        //u1.setId(1L);

        //begin(): Inicia uma transação;
        em.getTransaction().begin();

        //inserir um objeto no BD ou seja ele gera um insert
        em.persist(u1);

       // commit(): Finaliza/efetiva uma transação;
        em.getTransaction().commit();

        System.out.println(" O id gerado foi:"+u1.getId());

        em.close();
        emf.close();


    }
}
