package model.base.umparamuitos.testeumparamuitos;

import infra.DAO;
import model.base.umparamuitos.ItemPedido;
import model.base.umparamuitos.Pedido;

public class ObterPedidos {
    public static void main(String[] args) {
        DAO< Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterPorID(1L);

        for (ItemPedido item: pedido.getItens()
             ) {
            System.out.println(item.getQuantidade() + " - "+ item.getProduto().getNome());
             }
        dao.fechar();
    }
}
