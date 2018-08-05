/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import domain.Product;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author peani371
 */
public class ProductListDAO {

    private static Collection<Product> products = new HashSet<>();
    private static Collection<String> categories = new HashSet<>();
    private static Map<String, Product> productMap = new HashMap<>();
    private static Multimap<String, Product> categoryMultimap = HashMultimap.create();

    // Add a set of categories, cos it removes duplicates. Hash set or tree set.
    public Collection<String> getCategories() {
        return categories;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void saveProduct(Product newProd) {
        
        // If the old category existed, remove it
        Product test = searchForProduct(newProd.getProductID());
        if (test != null) {
            String cat = test.getCategory();
            
            Collection<Product> testCategories = filterProductCategory(cat);
            System.out.println("Size of category collectoin: " 
                    + testCategories.size());
            
            boolean remove = categoryMultimap.remove(cat, test);
            if (remove) {
                System.out.println("MM REMOVED SUCCESSFULLY.");
            }
            
            
            if (testCategories.size() == 1) {
                // the old product was the only one in that category - remove it
                categories.remove(cat);
                System.out.println("REMOVED SUCCESSFULLY.");
            }   
            
            System.out.println("Size of category collectoin AFTER: " 
                    + testCategories.size());
            
        }
        
        products.add(newProd);
        categories.add(newProd.getCategory());
        productMap.put(newProd.getProductID(), newProd);
        categoryMultimap.put(newProd.getCategory(), newProd);
    }

    public void deleteProduct(Product oldProd) {
        products.remove(oldProd);
        // doesn't remove from categories as category may still exist
        productMap.remove(oldProd.getProductID());
        categoryMultimap.remove(oldProd.getCategory(), oldProd);
    }

    public Product searchForProduct(String searchID) {

        // If the product exists, return it
        if (productMap.containsKey(searchID)) {
            return productMap.get(searchID);
        }
        // Product doesn't exist, return null instead
        return null;
    }

    public Collection<Product> filterProductCategory(String categoryToFilter) {
        return categoryMultimap.get(categoryToFilter);
    }
}
