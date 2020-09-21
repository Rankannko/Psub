// João Pedro de Padua Santoro Azevedo RA:18.02277-4@maua.br
//Como discutido, graças a problemas no scene builder, o programa não possui os trechos de JavaFX.

package sample;


import sample.classes.Menu;
import sample.classes.MenuDAO;


/**
 * Classe publica Main, onde ocorre o início do programa. Faz a chamada da classe MenuDAO, para inicializar o Menu
 * @Author João Pedro de Pauda Santoro Azevedo RA: 18.02277-4 e-mail: azevedomasterjp27@hotmail.com
 * @since 21/09
 * @Version 1.0
 */
public class Main  {
    public static void main (String[] args){
        MenuDAO menu = new MenuDAO();
        menu.run();
    }
}
