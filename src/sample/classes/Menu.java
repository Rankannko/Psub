package sample.classes;
import java.sql.*;
import java.util.Scanner;
import sample.classes.Pokemon;

public class Menu {
    /*public static void Run(){
        String URL, nome, raridade, serie, set;
        int ID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Pokemon:");
        nome= scanner.nextLine();
        Pokemon pokemon = new Pokemon("swsh2-36", "https://images.pokemontcg.io/swsh2/36_hires.png",nome, "Rare Holo", "SW/SW", "Rebel Clash",2);
        System.out.println("O pokemon é:" + pokemon.getNome()+ " Sura raridade é:" + pokemon.getRaridade());
    }*/
    public void run(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sqlite_paramodificar.db");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM pokemons");
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
                System.out.println(pokemon);
            }
            result.close();
            result = statement.executeQuery("SELECT * FROM pokemons");
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
                System.out.println(pokemon);
            }
            result.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
