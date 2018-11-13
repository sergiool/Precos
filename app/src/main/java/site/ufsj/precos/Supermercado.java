package site.ufsj.precos;

public class Supermercado {
    private String nome;
    private String endereco;
    private String cidade;
    private int id;

    public Supermercado() {
    }

    public Supermercado(String nome, String endereco, String cidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
