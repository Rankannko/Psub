package sample.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sample.classes.Pokemon;

/**
 * Classe PokemonDAO, com as informações para que a classe Pokemon funcione corretamente com um banco de dados.
 * @Author João Pedro de Pauda Santoro Azevedo RA: 18.02277-4 e-mail: azevedomasterjp27@hotmail.com
 * @since 21/09
 */
public class PokemonDAO implements DAO<Pokemon>, DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:sqlite_paramodificar.db";

    /**
     * Inicializa a conecção com o banco de dados, colocado como arquivo.
     */
    public PokemonDAO(){
    try{
        connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables){
        throwables.printStackTrace();
        }
    }

    /**
     * @param condition Função get, feita para gerar uma lista com as informações do banco de dados, retornando uma lista propriamente formatada.
     * @return Lista de pokemons
     */
    @Override
    public List<Pokemon> get(String condition) {
        List<Pokemon> pokemons = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Pokemon pokemon = new Pokemon(
                        result.getString("ID"),
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getInt("Quantidade")
                );
                pokemons.add(pokemon);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return pokemons;
    }

    /**
     * @return Lista de pokemons, da como retorno todos os valores dessa lista.
     */
    @Override
    public List<Pokemon> getAll() {
        List<Pokemon> pokemons = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Pokemon pokemon = new Pokemon(
                        result.getString("Id"),
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getInt("quantidade")
                );
                pokemons.add(pokemon);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return pokemons;
    }

    /**
     * @param pokemon Função base, utilizada para atualizar valores de um dos items da base de dados
     */
    @Override
    public void update(Pokemon pokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, pokemon.getID());
            preparedStatement.setString(2, pokemon.getURL());
            preparedStatement.setString(3, pokemon.getNome());
            preparedStatement.setString(4, pokemon.getRaridade());
            preparedStatement.setString(5, pokemon.getSerie());
            preparedStatement.setString(6, pokemon.getColecao());
            preparedStatement.setInt(7, pokemon.getQuantidade());
            preparedStatement.setString(8, pokemon.getID());
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param pokemon Função base, recebe um pokemon e o deleta da base de dados.
     */
    @Override
    public void delete(Pokemon pokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, pokemon.getID());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param pokemon Cria um novo pokemon, para o adicionar na base de dados
     */
    @Override
    public void create(Pokemon pokemon) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, pokemon.getID());
            preparedStatement.setString(2, pokemon.getURL());
            preparedStatement.setString(3, pokemon.getNome());
            preparedStatement.setString(4, pokemon.getRaridade());
            preparedStatement.setString(5, pokemon.getSerie());
            preparedStatement.setString(6, pokemon.getColecao());
            preparedStatement.setInt(7, pokemon.getQuantidade());
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Funcões utilizadas para trabalhar com o SQL. Necessárias para modificar a base de dados, de acordo com os seus parâmetros
     * @return
     */

    @Override
    public String getTableName() {
        return "pokemons";
    }

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE Id = ?";
    }

    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET Id = ?, URL = ?, nome = ?, raridade = ?, serie = ?, colecao = ?, Quantidade = ? WHERE Id = ?;";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (Id, url, nome, raridade, serie, colecao, Quantidade) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
