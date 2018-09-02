/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import dao.ProductDAOInterface;

/**
 *
 * @author peani371
 */
public class ProductModule extends Jooby {

    public ProductModule(ProductDAOInterface dao) {
        get("/api/products", () -> dao.getProducts());

        get("/api/products/:id", (req) -> {
            String id = req.param("id").value();
            return dao.searchForProduct(id);
        });
        
        get("/api/categories", () -> dao.getCategories());
        
        get("/api/categories/:category", (req) -> {
            String cat = req.param("category").value();
            return dao.filterProductCategory(cat);
        });
        
    }

}
