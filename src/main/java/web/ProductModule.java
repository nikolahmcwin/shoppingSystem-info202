/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.DAOInterface;
import org.jooby.Jooby;

/**
 *
 * @author peani371
 */
public class ProductModule extends Jooby {

    public ProductModule(DAOInterface dao) {
        get("/api/products", () -> dao.getProducts());

        get("/api/products/:id", (req) -> {
            String id = req.param("id").value();
            return dao.searchForProduct(id);
        });
    }

}
