package sample.classes;

public class Pokemon {
    private String URL;
    private String Nome;
    private String Raridade;
    private String Serie;
    private String Colecao;
    private String ID;
    private int quantidade;

    public Pokemon(String ID, String URL, String nome, String raridade, String serie, String colecao, int quantidade) {
        this.URL = URL;
        this.Nome = nome;
        this.Raridade = raridade;
        this.Serie = serie;
        this.Colecao = colecao;
        this.ID = ID;
        this.quantidade=quantidade;
    }

    public Pokemon(String ID) { this(ID,null,null,null,null,null,0); }
    @Override
    public String toString() {
        return "Pokemon{" +
                "ID='" + ID + '\'' +
                ", URL='" + URL + '\'' +
                ", Nome='" + Nome + '\'' +
                ", Raridade=" + Raridade + '\'' +
                ", Serie=" + Serie + '\'' +
                ", Colecao=" + Colecao+ '\'' +
                ", quantidade=" + quantidade +
                '}';
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

}
