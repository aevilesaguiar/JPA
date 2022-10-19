package model.base.muitoparamuitos.testemuitosparamuitos;

import infra.DAO;
import model.base.muitoparamuitos.Ator;
import model.base.muitoparamuitos.Filme;

public class NovoFilmeAtor {
    public static void main(String[] args) {
        Filme filmeA = new Filme("Alice no Pais das maravilhas", 9.4);
        Filme filmeB = new Filme("O fugitivo", 5.5);

        Ator atorA = new Ator("Francisca Silva");
        Ator atorB = new Ator("João da Silva");

        filmeA.adicionarAtor(atorA);
        filmeA.adicionarAtor(atorB);

        filmeB.adicionarAtor(atorB);

        DAO<Filme> dao = new DAO<Filme>();
        dao.incluirAtomico(filmeA);




    }
}
