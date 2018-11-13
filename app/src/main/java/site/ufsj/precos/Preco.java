package site.ufsj.precos;

public class Preco {
    private String produto;
    private int Supermercado;
    private float preco;

    public Preco() {
    }

    public Preco(String produto, int supermercado, float preco) {
        this.produto = produto;
        Supermercado = supermercado;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getSupermercado() {
        return Supermercado;
    }

    public void setSupermercado(int supermercado) {
        Supermercado = supermercado;
    }
}
