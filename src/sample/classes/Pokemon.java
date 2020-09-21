package sample.classes;

/**
 * Classe genérica pokemon, com todas as informações que uma carta tem. A base da base de dados, com getters 2 generators diferentes
 */
public class Pokemon {
    private String URL;
    private String Nome;
    private String Raridade;
    private String Serie;
    private String Colecao;
    private String ID;
    private int Quantidade;

    public Pokemon(String ID, String URL, String nome, String raridade, String serie, String colecao, int Quantidade) {
        this.URL = URL;
        this.Nome = nome;
        this.Raridade = raridade;
        this.Serie = serie;
        this.Colecao = colecao;
        this.ID = ID;
        this.Quantidade =Quantidade;
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
                ", Quantidade=" + Quantidade +
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
        return Quantidade;
    }

}
