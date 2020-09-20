package sample.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sample.classes.Pokemon;

public class PokemonDAO implements DAO<Pokemon>, DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:sqlite_paramodificar.db";

    public PokemonDAO(){
    try{
        connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables){
        throwables.printStackTrace();
        }
    }

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
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
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
