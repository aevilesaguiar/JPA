package heranca.testeHeranca;

import heranca.Aluno;
import heranca.AlunoBolsista;
import infra.DAO;

public class NovoAluno {
    public static void main(String[] args) {
        DAO< Aluno> alunoDAO = new DAO<>();

        Aluno aluno = new Aluno(1234L, "Joao");
        AlunoBolsista alunoBolsista = new AlunoBolsista(1258L, "Francisco",1000.00);

        alunoDAO.incluirAtomico(aluno);
        alunoDAO.incluirAtomico(alunoBolsista);

        alunoDAO.fechar();
    }
}
