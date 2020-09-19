package sample.classes;
import java.util.Scanner;
import sample.classes.Pokemon;

public class Menu {
    public static void Run(){
        String URL, nome, raridade, serie, set;
        int ID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Pokemon:");
        nome= scanner.nextLine();
        Pokemon pokemon = new Pokemon("swsh2-36", "https://images.pokemontcg.io/swsh2/36_hires.png",nome, "Rare Holo", "SW/SW", "Rebel Clash");
        System.out.println("O pokemon é:" + pokemon.getNome()+ " Sura raridade é:" + pokemon.getRaridade());
    }
}
