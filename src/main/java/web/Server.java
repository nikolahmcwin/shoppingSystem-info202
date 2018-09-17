/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CustomerCollectionsDAO;
import dao.ProductDatabase;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;
import dao.ProductDAOInterface;
import dao.CustomerDAOInterface;
import dao.CustomerDatabase;
import dao.SaleDAO;
import dao.SaleJdbcDAO;

/**
 *
 * @author peani371
 */
public class Server extends Jooby {

    private ProductDAOInterface dao = new ProductDatabase();
    //private CustomerDAOInterface custDao = new CustomerCollectionsDAO();
    private CustomerDAOInterface custDao = new CustomerDatabase();
    private SaleDAO saleDao = new SaleJdbcDAO();

    public Server() {
        port(2147);
        use(new Gzon());
        use(new ProductModule(dao));
        use(new CustomerModule(custDao));
        use(new AssetModule());
        use(new SaleModule(saleDao));
    }

    public static void main(String[] args) throws Exception {

        System.out.println("\nStarting Server.");
        Server server = new Server();

        CompletableFuture.runAsync(() -> {
            server.start();
        });

        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });

        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }
}
