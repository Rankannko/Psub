package sample.classes;

public class Pokemon {
    public Pokemon(String ID, String URL, String nome, String raridade, String serie, String colecao, int quantidade) {
        this.URL = URL;
        this.Nome = nome;
        this.Raridade = raridade;
        this.Serie = serie;
        this.Colecao = colecao;
        this.ID = ID;
        this.quantidade=quantidade;
    }

    public String getURL() {
        return URL;
    }

    public String getNome() {
        return Nome;
    }

    public String getRaridade() {
        return Raridade;
    }

    public String getSerie() {
        return Serie;
    }

    public String getColecao() {
        return Colecao;
    }

    public String getID() {
        return ID;
    }
    public int getQuantidade() {
        return quantidade;
    }

    private String URL, Nome, Raridade, Serie, Colecao, ID;
    
    private int quantidade;
}
