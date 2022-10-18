package basico.teste;

import model.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("exerciciosjpa");

        EntityManager em= emf.createEntityManager();

        Usuario u1= em.find(Usuario.class, 1L);
        System.out.println(u1.getNome() + " - "+u1.getId());



        em.close();
        emf.close();

    }
}
