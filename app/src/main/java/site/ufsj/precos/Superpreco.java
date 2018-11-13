package site.ufsj.precos;

public class Superpreco {
    private String nome;
    private String descricao;
    private float preco;

    public Superpreco() {
    }

    public Superpreco(String supermercado, String produto, float preco) {
        this.nome = supermercado;
        this.descricao = produto;
        this.preco = preco;
    }

    public String getSupermercado() {
        return nome;
    }

    public void setSupermercado(String supermercado) {
        this.nome = supermercado;
    }

    public String getProduto() {
        return descricao;
    }

    public void setProduto(String produto) {
        this.descricao= produto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
