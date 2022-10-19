package model.base.umparamuitos.testeumparamuitos;

import infra.DAO;
import model.base.Produto;
import model.base.umparamuitos.ItemPedido;
import model.base.umparamuitos.Pedido;

public class TesteumParaMuitos {
    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>();
        Produto produto = new Produto("Geladeira", 2589.36);
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(pedido,produto,10);

        dao.abrirTransacao()
                .incluir(produto)
                .incluir(pedido)
                .incluir(item)
                .fecharTransacao()
                .fechar();//fechei o EntityManger







    }
}
