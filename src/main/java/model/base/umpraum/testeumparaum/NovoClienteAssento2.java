package model.base.umpraum.testeumparaum;

import infra.DAO;
import model.base.umpraum.Assento;
import model.base.umpraum.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {


    Assento assento = new Assento("4k");
    Cliente cliente = new Cliente("Inez", assento);

    DAO<Cliente> dao = new DAO<>(Cliente.class);

    dao.incluirAtomico(cliente);

    }

}
