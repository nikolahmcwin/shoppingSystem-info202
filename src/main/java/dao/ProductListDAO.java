/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author peani371
 */
public class ProductListDAO {

    private static Collection<Product> products = new HashSet<>();

    private static Collection<String> categories = new HashSet<>();

    // Add a set of categories, cos it removes duplicates. Hash set or tree set.
    public static Collection<String> getCategories() {
        return categories;
    }

    public static Collection<Product> getProducts() {
        return products;
    }

    public void saveProduct(Product newProd) {
        products.add(newProd);
        categories.add(newProd.getCategory());
    }

    public void deleteProduct(Product oldProd) {
        products.remove(oldProd);
    }
}
