
import dao.DAOInterface;
import dao.ProductDatabase;
import gui.MainMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peani371
 */
public class Administration {

    public static void main(String[] args) {

        DAOInterface dao = new ProductDatabase();
        MainMenu menu = new MainMenu(dao);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
