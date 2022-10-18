package basico.teste;

import model.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("exerciciosjpa");

        EntityManager em= emf.createEntityManager();

        //inicia a transação
        em.getTransaction().begin();

        Usuario u1 = em.find(Usuario.class,4L);

        //desanexar /desassociar tirar o objeto do estado gerenciado
        em.detach(u1);

        u1.setNome("Joao ferreira SANTOS");
        u1.setEmail("JF@mail.com");
        //merge responsável por pegar um objeto que está no banco e fazer um update
       // em.merge(u1);
        System.out.println(u1.getNome());


        //finaliza a transação
        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
