/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author peani371
 */
public class ProductDatabase implements DAOInterface {

    private String dbURL = "jdbc:h2:tcp://localhost:9047/project;IFEXISTS=TRUE";

    public ProductDatabase() {
    }

    public ProductDatabase(String newDbURL) {
        this.dbURL = newDbURL;
    }

    @Override
    public void deleteProduct(Product oldProd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Product> filterProductCategory(String categoryToFilter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<String> getCategories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Product> getProducts() {

        String sql = "select * from Product order by PID";

        try (
                Connection dbCon = JdbcConnection.getConnection(dbURL);
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            ResultSet rs = stmt.executeQuery();

            Collection<Product> products = new HashSet<>();

            // While there are more products, loop and add them to collection
            while (rs.next()) {

                String productID = rs.getString("PID");
                String name = rs.getString("Pname");
                String description = rs.getString("Description");
                String category = rs.getString("Category");
                BigDecimal price = rs.getBigDecimal("Price");
                Integer quantityInStock = rs.getInt("Quantity");

                Product p = new Product();

                p.setProductID(productID);
                p.setName(name);
                p.setDescription(description);
                p.setCategory(category);
                p.setPrice(price);
                p.setQuantityInStock(quantityInStock);

                products.add(p);
            }

            return products;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void saveProduct(Product newProd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product searchForProduct(String searchID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
