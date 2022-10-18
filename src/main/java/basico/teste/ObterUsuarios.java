package basico.teste;

import model.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios
{
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("exerciciosjpa");

        EntityManager em= emf.createEntityManager();

        String jpql = "select u from Usuario u ";// em sql -> select u. * from Usuario u;

        TypedQuery<Usuario> query=em.createQuery(jpql, Usuario.class);
        query.setMaxResults(5);

        List<Usuario> usuarios = query.getResultList();

        for (Usuario u:usuarios
             ) {
            System.out.println("ID: "+u.getId() + " \nEmail: "+u.getEmail() + "\nNome: "+ u.getNome());
            System.out.println("--------------------------------------");
        }


        //outra forma
        List<Usuario> usuarios1 = em.createQuery("select u from Usuario u", Usuario.class)
               // .setMaxResults(5)
                        .getResultList();

        for (Usuario usuario1: usuarios1){
            System.out.println("ID: "+usuario1.getId() + " \nEmail: "+usuario1.getEmail() + "\nNome: "+ usuario1.getNome());
            System.out.println("--------------------------------------");
        }


        em.close();
        emf.close();
    }
}
