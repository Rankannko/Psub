package sample.classes;

import sample.classes.Pokemon;
import sample.DAO.PokemonDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDAO {
    private List<Pokemon> pokemons;
    private PokemonDAO pokemonDAO;
    private Scanner scanner;

    public MenuDAO(){
        pokemons = new ArrayList<>();
        pokemonDAO = new PokemonDAO();
        scanner = new Scanner(System.in);
    }
    public void run(){
        boolean alive= true;
        do{
            menu();
            int opcao = Integer.parseInt(scanner.next());
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    exibirCartas();
                    break;
                case 2:
                    deletarCarta();
                    break;
                case 3:
                    atualizarCarta();
                    break;
                case 4:
                    adicionarCarta();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    private void atualizarCarta() {
        pokemons = pokemonDAO.getAll();
        System.out.println("Excrever ID da carta a ser atualizada:");
        String ID = scanner.next();
        System.out.println("Cadastre os novos valores:");
        String URL, Nome, Raridade, Serie, Colecao;
        int quantidade;
        System.out.println("Informe os dados:");
        URL = scanner.next();
        Nome = scanner.next();
        Raridade = scanner.next();
        Serie = scanner.next();
        Colecao = scanner.next();
        quantidade = Integer.parseInt(scanner.next());
        pokemonDAO.update(new Pokemon(
                ID,URL, Nome, Raridade,Serie,Colecao, quantidade
        ));
    }

    private void adicionarCarta() {
        String URL, Nome, Raridade, Serie, Colecao,ID;
        int quantidade;
        System.out.println("Informe os dados da nova Carta:");
        ID= scanner.next();
        URL = scanner.next();
        Nome = scanner.next();
        Raridade = scanner.next();
        Serie = scanner.next();
        Colecao = scanner.next();
        quantidade = Integer.parseInt(scanner.next());
        pokemonDAO.create(new Pokemon(
                ID,URL, Nome, Raridade,Serie,Colecao, quantidade
        ));
    }
    private void deletarCarta() {
        System.out.println("Codigo da carta:");
        String codigo = scanner.next();
        Pokemon pokemon = new Pokemon(codigo);
        pokemonDAO.delete(pokemon);
    }

    private void exibirCartas() {
        pokemons = pokemonDAO.getAll();
        System.out.println("Produto:");
        pokemons.forEach( pokemon-> System.out.println(pokemon));
    }
    private void menu() {
        System.out.println("Menu das cartas");
        System.out.println("1 - Exibir inventário");
        System.out.println("2 - Retirar Carta do inventário:");
        System.out.println("3 - Modificar detalhes de uma carta");
        System.out.println("4 - Adicionar nova carta");
        System.out.println("0 - Sair");
    }
}
