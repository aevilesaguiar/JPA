package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

//Será criado com o generics
public class DAO <E>{

    private static EntityManagerFactory emf;

    //posso inicializar no construtor o EntityManger
    private EntityManager em;
    private Class<E> classe;

    static {
        try {

            //Fabrica de EntityManager
            emf= Persistence.createEntityManagerFactory("exerciciosjpa");

        }catch (Exception e){

        }
    }
    public DAO( ){
        this(null);
    }


    public DAO(Class<E> classe){
        this.classe=classe;

        //EntityManager que representa a conexão
        em= emf.createEntityManager();
    }

    public  DAO<E> abrirTransacao(){
        em.getTransaction().begin();
        return this;

    }

    public  DAO<E> fecharTransacao(){
        em.getTransaction().commit();
        return this;//retorna o proprio DAO

    }

    public  DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;//retorna o proprio DAO

    }

    //faz a inclusão já com as transaçãoes
    //ele inclui a abertura e fechamento da transação
    public  DAO<E> incluirAtomico(E entidade){

        return this.abrirTransacao().incluir(entidade).fecharTransacao();

    }

    public E obterPorID(Object id){
        return em.find(classe, id);
    }

//sobrecarga de métodos
    public List<E> obterTodos( ){
                            //quantidade=10  deslocamento padrao =0
        return this.obterTodos(10,0);
    }

    //select u. * from Usuario u limit 4 offset 3; paginando dentro da cosulta
    public List<E> obterTodos(int limit, int offset){
        if(classe==null){
            throw new UnsupportedOperationException("Classe nula.");
        }
        String jpql = "select e from " + classe.getName() + " e"; //toda consulta com jpql precisa ter um alias
        TypedQuery<E> query = em.createQuery(jpql, classe);

        query.setMaxResults(limit);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    public List<E>  consultar(String nomeConsulta , Object ... params){
        return null;
    }

    public void fechar(){
        em.close();
    }


}
