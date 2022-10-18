package model.base.ops;

import infra.ProdutoDAO;
import model.base.Produto;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ObterProdutos {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos();

        for (Produto produto : produtos
        ){
            System.out.println("ID: "+produto.getId() + " Nome: "+produto.getNome());
        }

        double precoTotal = produtos
                .stream()
                .map(p->p.getPreco())
                .reduce(0.0, (t,p)->t+p)
                .doubleValue();
        System.out.println("O valor total é R$ "+precoTotal);

        Produto precoMaior= produtos
                .stream()
                .max((x,y)->Double.compare(x.getPreco(),y.getPreco()))
                .get();

        System.out.println("O maior preço é:"+precoMaior.getPreco());
        Produto precoMenor= produtos
                .stream()
                .min((x,y)->Double.compare(x.getPreco(),y.getPreco()))
                .get();

        System.out.println("O menor preço é:"+precoMenor.getPreco());



    }
}
/*https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/*/
/*https://www.techiedelight.com/find-maximum-minimum-custom-objects-java/*/