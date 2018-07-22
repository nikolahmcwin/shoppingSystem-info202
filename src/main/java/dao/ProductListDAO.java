/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peani371
 */
public class ProductListDAO {

    private static List<Product> products = new ArrayList<>();
    // Add a set of categories, cos it removes duplicates. Hash set or tree set.

    public void saveProduct(Product newProd) {
        products.add(newProd);
    }

    public static List<Product> getProducts() {
        return products;
    }
}
