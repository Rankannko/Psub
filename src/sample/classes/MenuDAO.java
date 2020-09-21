package sample.classes;

import sample.classes.Pokemon;
import sample.DAO.PokemonDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe MenuDAO, onde é chamado o menu para a interação com o usuario, utilizando o metodo DAO para controle com SQL. Importa classe PokemonDAO para as informaçoes
 * A serem adicionadas no banco de dados
 * @Author João Pedro de Pauda Santoro Azevedo RA: 18.02277-4 e-mail: azevedomasterjp27@hotmail.com
 * @since 21/09
 */
public class MenuDAO {
    private List<Pokemon> pokemons;
    private PokemonDAO pokemonDAO;
    private Scanner scanner;

    /**
     * Inicialização do MenuDAO, com os parametros necessários para sua modificação
     */
    public MenuDAO(){
        pokemons = new ArrayList<>();
        pokemonDAO = new PokemonDAO();
        scanner = new Scanner(System.in);
    }

    /**
     * Função Run, utilizada para iniciar o menu, com as diferentes opções sendo os diferentes opções de modificações no banco de dados
     */
    public void run(){
        boolean alive= true;
        do{
            menu();
            int opcao = Integer.parseInt(scanner.nextLine());
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

    /**
     * Função utilizada para atualizar uma carta, a partir do seu ID, as informações da carta são modificadas.
     */
    private void atualizarCarta() {
        pokemons = pokemonDAO.getAll();
        System.out.println("Excrever ID da carta a ser atualizada:");
        String ID = scanner.nextLine();
        String URL, Nome, Raridade, Serie, Colecao;
        int quantidade;
        System.out.println("Informe A URL da carta:");
        URL = scanner.nextLine();
        System.out.println("Informe o Nome do Pokemon:");
        Nome = scanner.nextLine();
        System.out.println("Informe a Raridade da Carta:");
        Raridade = scanner.nextLine();
        System.out.println("Informe a Serie da Carta:");
        Serie = scanner.nextLine();
        System.out.println("Informe a Colecao da Carta:");
        Colecao = scanner.nextLine();
        System.out.println("Informe a quantidade de cartas:");
        quantidade = Integer.parseInt(scanner.nextLine());
        pokemonDAO.update(new Pokemon(
                ID, URL, Nome, Raridade, Serie, Colecao, quantidade
        ));
    }

    /**
     * Funcão para adicionar uma carta nova ao banco de dados.
     */
    private void adicionarCarta() {
        String URL, Nome, Raridade, Serie, Colecao,ID;
        int quantidade;
        System.out.println("Informe a ID da nova carta:");
        ID= scanner.nextLine();
        System.out.println("Informe A URL da carta:");
        URL = scanner.nextLine();
        System.out.println("Informe o Nome do Pokemon:");
        Nome = scanner.nextLine();
        System.out.println("Informe a Raridade da Carta:");
        Raridade = scanner.nextLine();
        System.out.println("Informe a Serie da Carta:");
        Serie = scanner.nextLine();
        System.out.println("Informe a Colecao da Carta:");
        Colecao = scanner.nextLine();
        System.out.println("Informe a quantidade de cartas:");
        quantidade = Integer.parseInt(scanner.nextLine());
        pokemonDAO.create(new Pokemon(
                ID,URL, Nome, Raridade,Serie,Colecao,quantidade
        ));
    }

    /**
     * Função utilizada para deletar uma carta do banco de dados.
     */
    private void deletarCarta() {
        System.out.println("Id da carta a ser deletada:");
        String Id = scanner.nextLine();
        Pokemon pokemon = new Pokemon(Id);
        pokemonDAO.delete(pokemon);
    }

    /**
     * Função utilizada para exibir todas as cartas do banco de dados, permitindo sua vizualização
     */
    private void exibirCartas() {
        pokemons = pokemonDAO.getAll();
        System.out.println("Pokemons:");
        pokemons.forEach( pokemon-> System.out.println(pokemon));
    }

    /**
     * Funcão void, que retorna uma interface para vizualização de um menu, para que o usuario consiga selecionar a opção correta.
     */
    private void menu() {
        System.out.println("Menu das cartas");
        System.out.println("1 - Exibir inventário");
        System.out.println("2 - Retirar Carta do inventário");
        System.out.println("3 - Modificar detalhes de uma carta");
        System.out.println("4 - Adicionar nova carta");
        System.out.println("0 - Sair");
    }
}
