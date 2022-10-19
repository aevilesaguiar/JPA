package model.base.umparamuitos;


import model.base.Produto;

import javax.persistence.*;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    //muitos items de pedido está para um pedido
    //many é do lado da classe que você está anotando e ToOne e do lado do pedido
    @ManyToOne
    private Pedido pedido;

    //um produto pode estar relacionado a muitos items de pedido
    //esse é o valor default de fetch( ... ToOne -> EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        //se o preço não for nulo e o preco for nulo
        if(produto != null && this.preco == null){
            //por padrão ele já seta o preço de produto no preço do item do pedido no momento que você setar o produto
            this.setPreco(produto.getPreco());
        }
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
