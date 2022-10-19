package model.base.umpraum.testeumparaum;

import infra.DAO;
import model.base.umpraum.Assento;
import model.base.umpraum.Cliente;

public class ObterClienteAssento {
    public static void main(String[] args) {
        DAO< Cliente> dao = new DAO<>(Cliente.class);

        Cliente cliente = dao.obterPorID(1L);
        System.out.println(cliente.getAssento().getNome());

        dao.fechar();
        DAO<Assento> assentoDAO = new DAO<>(Assento.class);

        Assento assento = assentoDAO.obterPorID(4L);
        System.out.println(assento.getCliente().getNome());

        assentoDAO.fechar();


    }
}
