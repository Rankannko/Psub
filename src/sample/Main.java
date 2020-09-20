package sample;

import sample.classes.Menu;
import sample.classes.MenuDAO;

public class Main  {
    public static void main (String[] args){
        MenuDAO menu = new MenuDAO();
        menu.run();
    }
}
