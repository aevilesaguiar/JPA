package model.base.umpraum.testeumparaum;

import infra.DAO;
import model.base.umpraum.Assento;
import model.base.umpraum.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {


    Assento assento = new Assento("1A");
    Cliente cliente = new Cliente("Flavio", assento);

    DAO<Object> dao = new DAO<>();

    dao.abrirTransacao();
    dao.incluir(assento);
    dao.incluir(cliente);
    dao.fecharTransacao();
    dao.fechar();

    }

}
