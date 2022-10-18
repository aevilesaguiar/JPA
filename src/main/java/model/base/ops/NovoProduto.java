package model.base.ops;

import infra.DAO;
import model.base.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        Produto produto= new Produto("Monitor 23",1915.45);

        DAO< Produto> dao = new DAO<>(Produto.class);

        dao.incluirAtomico(produto).fechar();

        System.out.println("Id do produto: "+produto.getId());



    }
}
