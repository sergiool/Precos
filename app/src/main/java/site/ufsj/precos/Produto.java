package site.ufsj.precos;

public class Produto {
    private String id;
    private String descricao;
    private int fabricante;
    private String foto;

    public Produto() {
    }

    public Produto(String id, String descricao, int fabricante, String foto) {
        this.id = id;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFabricante() {
        return fabricante;
    }

    public void setFabricante(int fabricante) {
        this.fabricante = fabricante;
    }
}

