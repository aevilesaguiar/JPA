package basico.teste;

import model.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("exerciciosjpa");

        EntityManager em= emf.createEntityManager();

        Usuario u1 = em.find(Usuario.class, 6L);

        if(u1!= null){
            em.getTransaction().begin();
            em.remove(u1);
            em.getTransaction().commit();
        }






        emf.close();
        em.close();
    }
}
