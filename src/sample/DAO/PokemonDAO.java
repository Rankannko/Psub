package sample.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sample.classes.Pokemon;

public class PokemonDAO implements DAO <Pokemon>, DAOFields {
    private Connection connection;
    private final String myDBConnectionString = "jdbc:sqlite:sqlite.db";

    public PokemonDao(){
    try{
        connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables){
        throwables.printStackTrace();
        }
    }
    public List<Pokemon> get(String condition) {
        List<Pokemon> pokemons = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Pokemon pokemon = new Pokemon(
                        result.getString("id"),
                        result.getString("url"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie"),
                        result.getString("colecao"),
                        result.getInt("quantidade")
                );
                clientes.add(cliente);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return clientes;
    }
}
